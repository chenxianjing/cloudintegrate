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
public class GovMessageHeader  implements Serializable {
    @ApiModelProperty("返回的状态码,0未成功")
    private String code;
    @ApiModelProperty("返回的描述信息")
    private String msg;
}
