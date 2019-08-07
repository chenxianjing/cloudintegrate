package org.cc.task.model.foreign.out;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 数据传输接口——存放返回信息的对象
 *
 * @author chenxianjing
 * @date 2019.07.10 14:55
 */
@Data
public class GovMessageBody  implements Serializable {

    private static final long serialVersionUID = -2081891048546993308L;
    @ApiModelProperty("存放内部接口是否成功")
    private Boolean success;
    @ApiModelProperty("接口返回状态码")
    private String resultCode;
    @ApiModelProperty("返回结果信息")
    private String resultMsg;
}
