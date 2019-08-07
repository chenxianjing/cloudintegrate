package org.cc.task.model.foreign;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 印章公共参数
 *
 * @author chenxianjing
 * @date 2019.07.09 11:15
 */
@Data
public class GovCommonIModel implements Serializable {


    private static final long serialVersionUID = -7194798151499290025L;
    @ApiModelProperty("接口名称(必须)")
    private String method;

    @ApiModelProperty("给用户颁发的appKey(必须)")
    private String appKey;

    @ApiModelProperty("请求签名,用于安全控制(必须)")
    private String sign;

    @ApiModelProperty("用户账户名(必须)")
    private String username;

    @ApiModelProperty("token用于调接口前授权检查(必须)")
    private String token;

    @ApiModelProperty("时间戳,格式为yyyyMMddHHmmss(必须)")
    private String timestamp;

    @ApiModelProperty("响应格式,默认为json格式,可选值:json(否)")
    private String format = "json";

    @ApiModelProperty("API协议版本，当前版本号1.0(必须)")
    private String version;

    @ApiModelProperty("请求类型,默认sync(否)")
    private String type = "sync";
}
