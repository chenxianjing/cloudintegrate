package org.cc.task.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.cc.task.enums.GovStatusEnum;
import org.cc.task.model.foreign.GovCommonOModel;
import org.cc.task.model.foreign.customer.in.CustomerSealDataInValidSearchIModel;
import org.cc.task.model.foreign.customer.in.CustomerSealDataUserIModel;
import org.cc.task.model.foreign.customer.out.CustomerSealDataInValidOModel;
import org.cc.task.model.foreign.customer.out.CustomerSealDataUserOModel;
import org.cc.task.model.foreign.in.GovDeactiveIModel;
import org.cc.task.model.foreign.in.GovStatusRegisterIModel;
import org.cc.task.model.foreign.in.GovStatusUnRegisterIModel;
import org.cc.task.model.foreign.in.GovTokenIModel;
import org.cc.task.model.foreign.out.GovDeactiveOModel;
import org.cc.task.model.foreign.out.GovTokenOModel;
import org.cc.task.util.DateUtils;
import org.cc.task.util.GovSealMethod;
import org.cc.task.util.GovUrl;
import org.cc.task.util.GovUtil;
import org.cc.task.util.SymmetricEncoder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

/**
 * 调用国家状态系统查询接口<br>
 *
 * @author chenxianjing
 * @date 2019-06-18 13:13:36
 * @since 1.0.0
 */
@Slf4j
@Service
public class GovSealService {

    @Value("${business.signature.gov.username}")
    private String userName;
    @Value("${business.signature.gov.password}")
    private String password;
    @Value("${business.signature.gov.userSalt}")
    private String userSalt;
    //@Value("${business.signature.gov.queryUrl}")
    //private String govSealQueryUrl;
    @Value("${business.signature.gov.appKeyToken}")
    private String appKey;

    @Value("${business.signature.gov.version}")
    private String version;
    @Autowired
    private RestTemplate restTemplate;
	/*
	 * @Resource(name = "jedisTemplate") private RedisTemplate<String, Object>
	 * redisTemplate;
	 * 
	 * @Autowired
	 */
    private GovSecretService govSecretService;
    @Autowired
    private GovUrl govUrl;
    @Autowired
    private GovUtil govUtil;

    /**
     * 获取token
     */
    public String getToken() {
    	//TODO
        String secret = "";
        if (StringUtils.isEmpty(secret)) {
            log.error("获取token失败,密钥为空");
            return "";
        }
        //ValueOperations<String, Object> value = redisTemplate.opsForValue();
        GovTokenIModel token = new GovTokenIModel();
        token.setMethod(GovSealMethod.TOKEN_METHOD);
        token.setUsername(userName);
        //对密码做一次SM3得到得到32字节摘，将摘要要的16进制值作为64个字符(小写字母)与盐值拼接后再做SM3
        token.setPassword(SymmetricEncoder.sm3(SymmetricEncoder.sm3(password) + userSalt));
        token.setClient_id(appKey);
        token.setClient_secret(secret);
        token.setVersion(version);
        token.setTimestamp(DateUtils.dateToStr3(new Date()));
        HttpEntity<GovTokenIModel> httpEntity = new HttpEntity<>(token,govUtil.getCommonHeaders());
        log.info("获取token接口开始调用,参数:{}", JSON.toJSONString(httpEntity));
        ResponseEntity<GovCommonOModel<GovTokenOModel>> tokenResponseEntity = restTemplate.exchange(govUrl.getGovInterfaceUrl(GovUrl.TOKEN), HttpMethod.POST, httpEntity,
                new ParameterizedTypeReference<GovCommonOModel<GovTokenOModel>>() {
                });
        log.info("获取token接口调用结束,返回值:{}", JSON.toJSONString(tokenResponseEntity));
        if (HttpStatus.OK.equals(tokenResponseEntity.getStatusCode())) {
            GovCommonOModel<GovTokenOModel> govTokenResponseOModel = tokenResponseEntity.getBody();
            if (!Objects.isNull(govTokenResponseOModel) && GovStatusEnum.SUCCESS.getCode().equals(govTokenResponseOModel.getCode())) {
                //TODO 目前token 先取第一个，多个也不知道该吗
                if (!CollectionUtils.isEmpty(govTokenResponseOModel.getData())) {
                    GovTokenOModel tokenOModel = govTokenResponseOModel.getData().get(0);
                    //TODO 国家获取token的缓存失效时间目前当秒为单位
                    Integer cacheTime = Integer.valueOf(tokenOModel.getExpires_in()) - 10;
                    //value.set(CacheKeyUtil.GOV_TOKEN, tokenOModel.getAccess_token(), cacheTime, TimeUnit.SECONDS);
                    return tokenOModel.getAccess_token();
                } else {
                    return "";
                }
            } else {
                return "";
            }
        } else {
            return "";
        }
    }

    /**
     * 先从redis里面取token,token失效再调用国家接口去取
     *
     * @return
     */
	/*
	 * public String getTokenCache() { ValueOperations<String, Object> value =
	 * redisTemplate.opsForValue(); String token = (String)
	 * value.get(CacheKeyUtil.GOV_TOKEN); if (StringUtils.hasText(token)) { return
	 * token; } else { token = this.getToken(); return token; } }
	 */
    /**
     * 注册用户获取印章状态
     *
     * @param customerSealDataUserIModel
     * @return
     */
    public List<CustomerSealDataUserOModel> getRegisterSeal(CustomerSealDataUserIModel customerSealDataUserIModel) {
        Assert.notNull(customerSealDataUserIModel, "customerSealDataUserIModel must not null");
        String token = getToken();
        if (StringUtils.isEmpty(token)) {
            log.error("token获取失败");
            return Collections.emptyList();
        }
        GovStatusRegisterIModel govStatusRegisterIModel = new GovStatusRegisterIModel();
        BeanUtils.copyProperties(customerSealDataUserIModel, govStatusRegisterIModel);
        govStatusRegisterIModel.setMethod(GovSealMethod.REGISTER_QUERY);
        govStatusRegisterIModel.setAppKey(appKey);
        //TODO 文档没有说明 暂时先对业务参数做签名
        govStatusRegisterIModel.setSign(SymmetricEncoder.sm3("sealCode" + customerSealDataUserIModel.getSealCode() + "sealName" + customerSealDataUserIModel.getSealName()
                + "queryTime" + customerSealDataUserIModel.getQueryTime()));
        govStatusRegisterIModel.setUsername(userName);
        govStatusRegisterIModel.setToken(token);
        govStatusRegisterIModel.setTimestamp(DateUtils.dateToStr3(new Date()));
        govStatusRegisterIModel.setVersion(version);
        return this.getSealStatus(govUrl.getGovInterfaceUrl(GovUrl.REGISTERSEAL), govStatusRegisterIModel);
    }


    /**
     * 非注册用户获取印章状态
     *
     * @param customerSealDataUserIModel
     * @return
     */
    public List<CustomerSealDataUserOModel> getUnRegisterSeal(CustomerSealDataUserIModel customerSealDataUserIModel) {
        Assert.notNull(customerSealDataUserIModel, "customerSealDataUserIModel must not null");
        GovStatusUnRegisterIModel govStatusRegisterIModel = new GovStatusUnRegisterIModel();
        BeanUtils.copyProperties(customerSealDataUserIModel, govStatusRegisterIModel);
        govStatusRegisterIModel.setMethod(GovSealMethod.REGISTER_QUERY);
        //TODO 文档没有说明 暂时先对业务参数做签名
        govStatusRegisterIModel.setSign(SymmetricEncoder.sm3("sealCode" + customerSealDataUserIModel.getSealCode() + "sealName" + customerSealDataUserIModel.getSealName()
                + "queryTime" + customerSealDataUserIModel.getQueryTime()));
        govStatusRegisterIModel.setTimestamp(DateUtils.dateToStr3(new Date()));
        govStatusRegisterIModel.setVersion(version);
        return this.getSealStatus(govUrl.getGovInterfaceUrl(GovUrl.UNREGITERSEAL), govStatusRegisterIModel);
    }

    /**
     * 获取印章状态信息公共方法
     *
     * @param t
     * @param <T>
     * @param url
     * @return
     */
    private <T> List<CustomerSealDataUserOModel> getSealStatus(String url, T t) {
        List<CustomerSealDataUserOModel> result = Collections.emptyList();
        HttpEntity<T> httpEntity = new HttpEntity<>(t,govUtil.getCommonHeaders());
        log.info("获取印章状态接口开始调用,{}", JSON.toJSONString(httpEntity));
        ResponseEntity<GovCommonOModel<CustomerSealDataUserOModel>> statusResponseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
                new ParameterizedTypeReference<GovCommonOModel<CustomerSealDataUserOModel>>() {
                });
        log.info("获取印章状态接口调用结束,{}",  JSON.toJSONString(statusResponseEntity));
        if (HttpStatus.OK.equals(statusResponseEntity.getStatusCode())) {
            GovCommonOModel<CustomerSealDataUserOModel> govStatusCommonOModel = statusResponseEntity.getBody();
            if (!Objects.isNull(govStatusCommonOModel) && GovStatusEnum.SUCCESS.getCode().equals(govStatusCommonOModel.getCode())) {
                if (!CollectionUtils.isEmpty(govStatusCommonOModel.getData())) {
                    result = new ArrayList<>(govStatusCommonOModel.getData().size());
                    BeanUtils.copyProperties(govStatusCommonOModel.getData(), result);
                    /**
                     * 自定义1有效，2无效；政府接口0有效，1无效，转换
                     */
                    result.forEach(c -> {
                        if ("0".equals(c.getSealStatus())) {
                            c.setSealStatus("1");
                        } else {
                            c.setSealStatus("2");
                        }
                    });
                    return result;
                } else {
                    return result;
                }
            } else {
                return Collections.emptyList();
            }
        } else {
            return Collections.emptyList();
        }
    }

    /**
     * 获取印章吊销信息
     */
    public List<CustomerSealDataInValidOModel> getDeactiveSeal(CustomerSealDataInValidSearchIModel customerSealDataInValidSearchIModel) {
        GovDeactiveIModel govDeactiveIModel = new GovDeactiveIModel();
        govDeactiveIModel.setMethod(GovSealMethod.DEACTIVE_QUERY);
        govDeactiveIModel.setUsername(userName);
        govDeactiveIModel.setAppKey(appKey);

        govDeactiveIModel.setUsername(userName);
        govDeactiveIModel.setToken(getToken());
        govDeactiveIModel.setTimestamp(DateUtils.dateToStr3(new Date()));
        govDeactiveIModel.setVersion(version);
        BeanUtils.copyProperties(customerSealDataInValidSearchIModel, govDeactiveIModel, "createdBy", "offset", "limit", "order");
        govDeactiveIModel.setPageNow(customerSealDataInValidSearchIModel.getOffset().toString());
        govDeactiveIModel.setPageSize(customerSealDataInValidSearchIModel.getLimit().toString());
        //TODO 文档没有说明 暂时先对业务参数做签名
        govDeactiveIModel.setSign(SymmetricEncoder.sm3("pageNow" + govDeactiveIModel.getPageNow() + "pageSize" + govDeactiveIModel.getPageSize()
                + "queryEndTime" + govDeactiveIModel.getQueryEndTime() + "queryStartTime" + govDeactiveIModel.getQueryStartTime()));
        HttpEntity<GovDeactiveIModel> httpEntity = new HttpEntity<>(govDeactiveIModel);
        log.info("获取印章吊销信息开始调用,参数:{}", JSON.toJSONString(httpEntity));
        ResponseEntity<GovCommonOModel<GovDeactiveOModel>> deactiveResponseEntity = restTemplate.exchange(govUrl.getGovInterfaceUrl(GovUrl.DEACTIVESEAL), HttpMethod.POST, httpEntity,
                new ParameterizedTypeReference<GovCommonOModel<GovDeactiveOModel>>() {
                });
        log.info("获取印章吊销信息调用结束,返回值:{}", JSON.toJSONString(deactiveResponseEntity));
        if (HttpStatus.OK.equals(deactiveResponseEntity.getStatusCode())) {
            GovCommonOModel<GovDeactiveOModel> deactiveResponseOModel = deactiveResponseEntity.getBody();
            if (!Objects.isNull(deactiveResponseOModel) && GovStatusEnum.SUCCESS.getCode().equals(deactiveResponseOModel.getCode())) {
                if (!CollectionUtils.isEmpty(deactiveResponseOModel.getData())) {
                    GovDeactiveOModel tokenOModel = deactiveResponseOModel.getData().get(0);
                    //TODO 要验签
                    if (CollectionUtils.isEmpty(tokenOModel.getRevocationList())) {
                        return Collections.emptyList();
                    }
                    return tokenOModel.getRevocationList();
                } else {
                    return Collections.emptyList();
                }
            } else {
                return Collections.emptyList();
            }
        } else {
            return Collections.emptyList();
        }
    }
}
