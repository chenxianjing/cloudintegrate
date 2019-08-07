package org.cc.task.service;

import java.util.Objects;

import org.cc.task.enums.GovStatusEnum;
import org.cc.task.enums.TaskEnum;
import org.cc.task.model.foreign.in.GovRandomIModel;
import org.cc.task.model.foreign.in.GovSealDeactiveIModel;
import org.cc.task.model.foreign.in.GovSealReleaseIModel;
import org.cc.task.model.foreign.in.GovSealRenewalIModel;
import org.cc.task.model.foreign.in.GovTextIModel;
import org.cc.task.model.foreign.in.GovTransferIModel;
import org.cc.task.model.foreign.out.GovRandomOModel;
import org.cc.task.model.foreign.out.GovTransferOModel;
import org.cc.task.util.CertUtil;
import org.cc.task.util.GovUrl;
import org.cc.task.util.GovUtil;
import org.cc.task.util.SymmetricEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

/**
 * 调用国家状态系统传输数据接口<br>
 *
 * @author chenxianjing
 * @date 2019-07-10 13:34:36
 * @since 1.0.0
 */
@Slf4j
@Service
public class GovSealTransferService {
    @Autowired
    private RestTemplate restTemplate;

    //@Value("${business.signature.gov.transferUrl}")
    //private String govSealDataUrl;

	/*
	 * @Resource(name = "jedisTemplate") private RedisTemplate<String, String>
	 * redisTemplate;
	 */
    @Autowired
    private GovUrl govUrl;
    @Autowired
    private GovUtil govUtil;


    /**
     * 电子印章同步数据获取随机数接口（身份认证）
     *
     * @return
     */
    public GovRandomOModel getRandom() {
        GovRandomIModel govRandomIModel = new GovRandomIModel(CertUtil.systemCert, IdentityAuthenticationService.getAccountIdByUUId());
        HttpEntity<GovRandomIModel> httpEntity = new HttpEntity<>(govRandomIModel,govUtil.getCommonHeaders());
        log.info("电子印章同步数据获取随机数接口（身份认证）开始调用,参数:{}", JSON.toJSONString(govRandomIModel));
        ResponseEntity<GovRandomOModel> responseEntity = restTemplate.postForEntity(govUrl.getGovInterfaceUrl(GovUrl.IDENTITY_AUTHENTICATION), httpEntity, GovRandomOModel.class);
        log.info("电子印章同步数据获取随机数接口（身份认证）调用结束,返回值:{}", JSON.toJSONString(responseEntity));
        if (HttpStatus.OK.equals(responseEntity.getStatusCode())) {
            GovRandomOModel govRandomOModel = responseEntity.getBody();
            if (Objects.isNull(govRandomOModel)) {
                return null;
            }
            return govRandomOModel;
        } else {
            return null;
        }
    }

    /**
     * 电子印章同步数据获取随机数接口缓存接口（身份认证）
     *
     * @return
     */
	/*
	 * public String getRandomCache() { ValueOperations<String, String> ops =
	 * redisTemplate.opsForValue(); String random =
	 * ops.get(CacheKeyUtil.GOV_RANDOM); if (StringUtils.isEmpty(random)) {
	 * GovRandomOModel govRandomOModel = this.getRandom(); if
	 * (!Objects.isNull(govRandomOModel)) { ops.set(CacheKeyUtil.GOV_RANDOM,
	 * govRandomOModel.getRandomB()); return govRandomOModel.getRandomB(); } } else
	 * { return random; } return ""; }
	 */
    /**
     * 印章数据同步
     *
     * @param taskEnum {@link TaskEnum} 区分是印章发布还是印章续期还是吊销
     * @param t        {@link GovSealDeactiveIModel,GovSealReleaseIModel,GovSealRenewalIModel}
     * @return
     */
    private <T> Boolean transfer(TaskEnum taskEnum, T t, String signValue) {
        Boolean result = Boolean.FALSE;
        GovTransferIModel govTransferIModel = new GovTransferIModel();
        String idA = CertUtil.systemCert;
        String randomB = this.getRandom().getRandomB();
        GovTextIModel govTextIModel = new GovTextIModel();
        govTextIModel.setTaskCode(taskEnum.getCode());
        govTextIModel.setTaskData(JSON.toJSONString(t));
        //TODO 对印章参数做的签名
        govTextIModel.setTaskSignature(signValue);
        govTransferIModel.setData(idA + "||" + randomB + "||" + JSON.toJSONString(govTextIModel) + "||" + signValue);
        log.info("电子印章同步数据接口开始调用,参数:{}", JSON.toJSONString(govTextIModel));
        HttpEntity<GovTransferIModel> httpEntity = new HttpEntity<>(govTransferIModel,govUtil.getCommonHeaders());
        ResponseEntity<GovTransferOModel> responseEntity = restTemplate.postForEntity(govUrl.getGovInterfaceUrl(GovUrl.DATA_TRANSFER), httpEntity, GovTransferOModel.class);
        log.info("电子印章同步数据接口调用结束,返回值:{}", JSON.toJSONString(responseEntity));
        if (HttpStatus.OK.equals(responseEntity.getStatusCode())) {
            GovTransferOModel govTransferOModel = responseEntity.getBody();
            if (Objects.isNull(govTransferOModel)) {
                return result;
            }
            //国家接口调用成功
            if (GovStatusEnum.SUCCESS.getCode().equals(govTransferOModel.getCode())) {
                result = Boolean.TRUE;
            }
        }
        return result;
    }

    /**
     * 印章发布
     *
     * @param govSealReleaseIModel
     * @return
     */
    public Boolean release(GovSealReleaseIModel govSealReleaseIModel) {
        Assert.notNull(govSealReleaseIModel, "govSealReleaseIModel must not null");
        govSealReleaseIModel.setProvincePubSysId(CertUtil.systemCert);
        log.info("电子印章发布");
        String signValue = SymmetricEncoder.sm2(govSealReleaseIModel.getSealCode() + "|" + govSealReleaseIModel.getParentSealCode() + "|"
                + govSealReleaseIModel.getSealName() + "|" + govSealReleaseIModel.getValidStartTime() + "|" + govSealReleaseIModel.getValidEndTime()
                + "|" + govSealReleaseIModel.getCreater() + "|" + govSealReleaseIModel.getSealCode() + "|" + govSealReleaseIModel.getUseUnitCode()
                + "|" + govSealReleaseIModel.getLegalType() + "|" + govSealReleaseIModel.getSignature() + "|" + govSealReleaseIModel.getCreateTime()
                + "|" + govSealReleaseIModel.getProvincePubSysId() + "|" + govSealReleaseIModel.getCertStartTime() + "|" + govSealReleaseIModel.getCertEndTime()
                + "|" + govSealReleaseIModel.getSignCert() + "|" + govSealReleaseIModel.getRequestParam());
        return this.transfer(TaskEnum.RELEASE, govSealReleaseIModel, signValue);
    }

    /**
     * 印章吊销、挂失、撤销
     *
     * @param govSealDeactiveIModel
     * @return
     */
    public Boolean deactive(GovSealDeactiveIModel govSealDeactiveIModel) {
        Assert.notNull(govSealDeactiveIModel, "govSealDeactiveIModel must not null");
        log.info("电子印章吊销、挂失、撤销");
        govSealDeactiveIModel.setProvincePubSysId(CertUtil.systemCert);
        String signValue = SymmetricEncoder.sm2(govSealDeactiveIModel.getSealName() + "|" + govSealDeactiveIModel.getApplyDate()
                + "|" + govSealDeactiveIModel.getCancelDescribe() + "|" + govSealDeactiveIModel.getCancelReason() + "|" + govSealDeactiveIModel.getInvalidEffectTime()
                + "|" + govSealDeactiveIModel.getInvalidType() + "|" + govSealDeactiveIModel.getSignature() + "|" + govSealDeactiveIModel.getProvincePubSysId());
        return this.transfer(TaskEnum.DEACTIVE, govSealDeactiveIModel, signValue);
    }

    /**
     * 印章续期
     *
     * @param govSealRenewalIModel
     * @return
     */
    public Boolean renewal(GovSealRenewalIModel govSealRenewalIModel) {
        Assert.notNull(govSealRenewalIModel, "govSealRenewalIModel must not null");
        log.info("电子印章续期");
        govSealRenewalIModel.setProvincePubSysId(CertUtil.systemCert);
        String signValue = SymmetricEncoder.sm2(govSealRenewalIModel.getSealCode() + "|" + govSealRenewalIModel.getSealName()
                + "|" + govSealRenewalIModel.getValidEndTime() + "|" + govSealRenewalIModel.getSignCert());
        return this.transfer(TaskEnum.RENEWAL, govSealRenewalIModel, signValue);
    }
}
