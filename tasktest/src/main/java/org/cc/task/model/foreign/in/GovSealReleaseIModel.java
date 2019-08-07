package org.cc.task.model.foreign.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 电子印章同步数据获取随机数接口（身份认证）
 *
 * @author chenxianjing
 * @date 2019.07.10 14:55
 */
@ApiModel(description = "电子印章同步数据获取随机数接口（身份认证）")
@Data
public class GovSealReleaseIModel implements Serializable {

    private static final long serialVersionUID = -7773614729829441351L;

    @ApiModelProperty("电子印章状态发布系统证书(否)")
    private String provincePubSysId;

    @ApiModelProperty("印章编码(必须)")
    private String sealCode;

    @ApiModelProperty("印章名称(必须)")
    private String sealName;

    @ApiModelProperty("社会信用代码(必须)")
    private String useUnitCode;

    @ApiModelProperty("印章所属区域(必须)")
    private String sealZone;

    @ApiModelProperty("印章有效起始时间(必须),格式;yyyy-MM-dd HH:mm:ss")
    private String validStartTime;

    @ApiModelProperty("印章有效截至时间(必须),格式;yyyy-MM-dd HH:mm:ss")
    private String validEndTime;

    @ApiModelProperty("印章上级编码(必须)")
    private String parentSealCode;

    @ApiModelProperty("印章创建时间(必须),格式;yyyy-MM-dd HH:mm:ss")
    private String createTime;

    @ApiModelProperty("制章点名称(必须)")
    private String creater;

    @ApiModelProperty("法人类型(必须)")
    private String legalType;

    @ApiModelProperty("印章签名值(必须)")
    private String signature;

    @ApiModelProperty("证书有效起始时间(必须),格式;yyyy-MM-dd HH:mm:ss")
    private String certStartTime;

    @ApiModelProperty("证书有效截至时间(必须),格式;yyyy-MM-dd HH:mm:ss")
    private String certEndTime;

    @ApiModelProperty("印章证书(必须)")
    private String signCert;

    @ApiModelProperty("印章参数转为JSON格式(必须)")
    private String requestParam;
}
