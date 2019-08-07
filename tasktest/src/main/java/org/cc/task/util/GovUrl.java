package org.cc.task.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * 政府接口的url
 *
 * @author chenxiajing
 * @date 2019.07.10 10:05 am
 */
@Component
public class GovUrl {
    /**
     * 电子印章状态同步：IK1008→IK1009
     * 电子印章状态查询： IK1012（非注册用户）
     * 电子印章状态查询： IK1010→IK1011（注册用户）
     * 电子印章吊销列表查询：IK1010→IK1013
     */
    //http://域名或IP:端口号/resource/rest/v1/shared/{catalogId}/1,
    @Value("${business.signature.gov.queryUrl}")
    private String govSealQueryUrl;
    //url http://域名或IP:端口号/seal/seal/v1
    //http://域名或IP:端口号/resource/rest/v{n}/shared/{catalogId}/{catalogVersion},目前n和catalogVersion都为1,电子印章接口函数的catlogID为IK1001-IK1013
    //---------------------------------------
    //身份认证接口 http://域名或IP:端口号/resource/rest/v1/shared/IK1008/1
    public static final String IDENTITY_AUTHENTICATION = "IK1008";
    //数据传输接口 http://域名或IP:端口号/resource/rest/v1/shared/IK1009/1
    public static final String DATA_TRANSFER = "IK1009";
    //获取token http://域名或IP:端口号/resource/rest/v1/shared/IK1010/1
    public static final String TOKEN = "IK1010";
    //印章状态查询接口(注册用户） http://域名或IP:端口号/resource/rest/v1/shared/IK1011/1
    public static final String REGISTERSEAL = "IK1011";
    //印章状态查询接口(非注册用户） http://域名或IP:端口号/resource/rest/v1/shared/IK1012/1
    public static final String UNREGITERSEAL = "IK1012";
    //印章状态查询接口(非注册用户） http://域名或IP:端口号/resource/rest/v1/shared/IK1013/1
    public static final String DEACTIVESEAL = "IK1013";

    /**
     * 获取具体接口调用地址
     *
     * @param interfaceCode
     * @return
     */
    public final String getGovInterfaceUrl(final String interfaceCode) {
        Assert.notNull(interfaceCode, "interfaceCode must not null");
        return govSealQueryUrl.replace("{catalogId}", interfaceCode);
    }
}
