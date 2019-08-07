package org.cc.task.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.cc.task.model.foreign.out.GovSecretOModel;
import org.cc.task.util.SymmetricEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

/**
 * 调用国家状态系统获取密钥接口<br>
 *
 * @author chenxianjing
 * @date 2019-07-23 13:34:36
 * @since 1.0.0
 */
@Slf4j
@Service
public class GovSecretService {
    @Value("${business.signature.gov.secretUrl}")
    private String govSecretUrl;
    @Value("${business.signature.gov.appKeySecret}")
    private String appKey;
    @Value("${business.signature.gov.username}")
    private String userName;
    @Value("${business.signature.gov.password}")
    private String password;
    @Autowired
    private RestTemplate restTemplate;
	/*
	 * @Resource(name = "jedisTemplate") private RedisTemplate<String, String>
	 * redisTemplate;
	 */

    /**
     * 获取密钥
     *
     * @return
     */
    public String getSecret() {
        //ValueOperations<String, String> value = redisTemplate.opsForValue();
        Map<String, String> uriVariables = new HashMap<>(3);
        uriVariables.put("appkey", appKey);
        uriVariables.put("username", userName);
        uriVariables.put("sign", SymmetricEncoder.sm3(userName + "#" + appKey + "#" + password));
        log.info("获取密钥开始调用,参数:{}", JSON.toJSONString(uriVariables));
        ResponseEntity<GovSecretOModel> responseEntity = restTemplate.postForEntity(govSecretUrl, null, GovSecretOModel.class, uriVariables);
        log.info("获取密钥调用结束,返回值:{}", JSON.toJSONString(responseEntity));
        if (HttpStatus.OK.equals(responseEntity.getStatusCode())) {
            GovSecretOModel govSecretOModel = responseEntity.getBody();
            if (Objects.isNull(govSecretOModel)) {
                return "";
            } else {
                if (govSecretOModel.getCode() == 10) {
                   // value.set(CacheKeyUtil.GOV_SECRET, govSecretOModel.getData());
                    return SymmetricEncoder.AESDncode(appKey, govSecretOModel.getData());
                } else {
                    return "";
                }
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
	 * public String getSecretCache() { ValueOperations<String, String> value =
	 * redisTemplate.opsForValue(); String secret =
	 * value.get(CacheKeyUtil.GOV_SECRET); if (StringUtils.hasText(secret)) { return
	 * secret; } else { return this.getSecret(); } }
	 */
}
