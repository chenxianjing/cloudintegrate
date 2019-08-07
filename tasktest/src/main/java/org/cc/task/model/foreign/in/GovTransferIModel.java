package org.cc.task.model.foreign.in;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 电子印章同步数据
 *
 * @author chenxianjing
 * @date 2019.07.10 14:55
 */
@Data
public class GovTransferIModel  implements Serializable {

    private static final long serialVersionUID = 2959899260293538984L;
    @ApiModelProperty("请求参数")
    private String data;
}
