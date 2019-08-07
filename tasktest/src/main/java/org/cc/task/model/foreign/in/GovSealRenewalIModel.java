package org.cc.task.model.foreign.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 电子印章同步数据印章续期
 *
 * @author chenxianjing
 * @date 2019.07.10 14:55
 */
@ApiModel(description = "电子印章同步数据印章续期")
@Data
public class GovSealRenewalIModel  implements Serializable {

    private static final long serialVersionUID = 7495792547998516393L;
    @ApiModelProperty("电子印章状态发布系统证书(否)")
    private String provincePubSysId;
    @ApiModelProperty("印章编码(必须)")
    private String sealCode;
    @ApiModelProperty("印章名称(必须)")
    private String sealName;
    @ApiModelProperty("印章有效截至时间(必须),格式;yyyy-MM-dd HH:mm:ss")
    private String validEndTime;
    @ApiModelProperty("印章签名值(必须)")
    private String signature;
    @ApiModelProperty("印章证书(必须)")
    private String signCert;
}
