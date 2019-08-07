package org.cc.task.model.foreign.out;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 密钥<br>
 *
 * @author chenxianjing
 * @date 2019-07-23 13:34:36
 * @since 1.0.0
 */
@Data
public class GovSecretOModel  implements Serializable {

    private static final long serialVersionUID = -2141798465380752016L;
    @ApiModelProperty("对code的描述")
    private String message;

    @ApiModelProperty("data存储刷新后的secret")
    private String data;

    @ApiModelProperty("执行结果代码，10表示刷新成功")
    private Integer code;
}
