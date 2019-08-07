package org.cc.task.model.foreign.in;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 获取token
 *
 * @author chenxianjing
 * @date 2019.07.08 11:23
 */
@Data
public class GovTokenIModel implements Serializable {


    private static final long serialVersionUID = -9082396751972632309L;

    @ApiModelProperty("接口名称(必须)")
    private String method;

    @ApiModelProperty("用户账号名(必须)")
    private String username;

    @ApiModelProperty("用户 密码 ，用户密码 + 用户盐值拼接后进行散列(必须)")
    private String password;

    @ApiModelProperty("用户注册并通过审核后返回的appkey(必须)")
    private String client_id;

    @ApiModelProperty("用户注册并通过审核后返回的appsecret(必须)")
    private String client_secret;

    @ApiModelProperty("授权模式，固定为password(必须)")
    private String grant_type;

    @ApiModelProperty("版本，目前为1.0(必须)")
    private String version;

    @ApiModelProperty("时间戳，格式为yyyyMMddHHmmss(必须)")
    private String timestamp;
}
