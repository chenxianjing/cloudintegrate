package org.cc.task.model.foreign.customer.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 印章吊销查询<br>
 *
 * @author chenxianjing
 * @date 2019-06-18 15:25:31
 * @since 1.0.0
 */
@ApiModel(
        description = "印章吊销查询"
)
@Data
public class CustomerSealDataInValidOModel implements Serializable {


    private static final long serialVersionUID = -7643381670994197764L;
    @ApiModelProperty("印章编码")
    private String sealCode;

    @ApiModelProperty("印章唯一编码")
    private String sealName;

    @ApiModelProperty("印章无效生效时间")
    private String revocationTime;
}
