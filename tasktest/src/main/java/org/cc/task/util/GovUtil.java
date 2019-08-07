package org.cc.task.util;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class GovUtil {

    @Value("${business.signature.gov.appKeyToken}")
    private String appKey;

    @Value("${business.signature.gov.username}")
    private String userName;

    //TODO 需要加到配置文件里面
    private String secret;

    /**
     * 获取公共请求头
     * @return
     */
    public HttpHeaders getCommonHeaders(){
        String nonce = UUID.randomUUID().toString();
        String currentDate = DateUtils.dateToStr2(new Date());
        HttpHeaders headers = new HttpHeaders();
        headers.add("App_key", appKey);
        headers.add("Username ", userName);
        headers.add("Nonce", nonce);
        headers.add("Created ", currentDate);
        headers.add("PasswdDigest ", SymmetricEncoder.sm3(nonce + "_" + currentDate + "_" + secret));
        return headers;
    }
}
