package org.cc.task.model.foreign.out;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 印章数据传输
 *
 * @author chenxianjing
 * @date 2019.07.10 14:56
 */
@Data
public class GovTransferOModel  implements Serializable {

    private static final long serialVersionUID = 8973681243828877928L;
    @ApiModelProperty("存放返回信息的对象")
    private GovMessageHeader messageHeader;
    @ApiModelProperty("存放返回信息的对象")
    private GovMessageBody messageBody;
    @ApiModelProperty("返回的状态码，0为成功")
    private String code;
    @ApiModelProperty("返回的描述信息")
    private String msg;
    @ApiModelProperty("调用内部接口是否成功")
    private String isSuccess;
    @ApiModelProperty("接口返回状态码")
    private String resultCode;
    @ApiModelProperty("返回结果信息")
    private String resultMsg;




}
