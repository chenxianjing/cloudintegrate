package org.cc.task.model.foreign.in;

import org.cc.task.model.foreign.GovCommonIModel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 注册用户获取印章状态
 *
 * @author chenxianjing
 * @date 2019.07.08 11:23
 */
@Data
public class GovStatusRegisterIModel extends GovCommonIModel {

    private static final long serialVersionUID = -4645373749806631316L;
    @ApiModelProperty("印章名称(必须)")
    private String sealName;

    @ApiModelProperty("印章编码(必须)")
    private String sealCode;

    @ApiModelProperty("查询时间(必须)")
    private String queryTime;

    @ApiModelProperty("使用印章证书(否)")
    private String sealUserCert;
}
