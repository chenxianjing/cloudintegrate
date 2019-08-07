package org.cc.task.model.foreign.in;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 非注册用户获取印章状态
 *
 * @author chenxianjing
 * @date 2019.07.08 11:23
 */
@Data
public class GovStatusUnRegisterIModel implements Serializable {

    private static final long serialVersionUID = 6063755547521886348L;

    @ApiModelProperty("接口名称(必须)")
    private String method;

    @ApiModelProperty("请求签名(必须)")
    private String sign;

    @ApiModelProperty("时间戳(必须)")
    private String timestamp;

    @ApiModelProperty("响应格式(必须)")
    private String format = "json";

    @ApiModelProperty("版本(必须)")
    private String version;

    @ApiModelProperty("请求类型 (必须)")
    private String type = "sync";

    @ApiModelProperty("印章名称(必须)")
    private String sealName;

    @ApiModelProperty("印章编码(必须)")
    private String sealCode;

    @ApiModelProperty("查询时间(必须)")
    private String queryTime;

    @ApiModelProperty("使用印章证书(否)")
    private String sealUserCert;
}
