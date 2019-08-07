package org.cc.task.model.foreign.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 电子印章同步数据印章吊销
 *
 * @author chenxianjing
 * @date 2019.07.10 14:55
 */
@ApiModel(description = "电子印章同步数据印章续期")
@Data
public class GovSealDeactiveIModel  implements Serializable {

    private static final long serialVersionUID = -3319535863263214440L;
    @ApiModelProperty("电子印章状态发布系统证书(否)")
    private String provincePubSysId;
    @ApiModelProperty("印章名称(必须)")
    private String sealName;
    @ApiModelProperty("挂失或吊销或撤销原因(必须)")
    private String cancelReason;
    @ApiModelProperty("挂失或吊销或撤销原因描述(必须)")
    private String cancelDescribe;
    @ApiModelProperty("挂失或吊销或撤销申请时间(必须)")
    private String applyDate;
    @ApiModelProperty("印章签名值(必须)")
    private String signature;
    @ApiModelProperty("类型：0:吊销，1:撤销，2:挂失(必须)")
    private String invalidType;
    @ApiModelProperty("挂失或吊销或撤销生效时间(必须),格式;yyyy-MM-dd HH:mm:ss")
    private String invalidEffectTime;
}
