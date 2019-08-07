package org.cc.task.model.foreign.customer.out;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 业务数据保存<br>
 *
 * @author chenxianjing
 * @date 2019-06-18 15:25:31
 * @since 1.0.0
 */
@ApiModel(
        description = "用户印章状态"
)
@Data
public class CustomerSealDataUserOModel implements Serializable {

    private static final long serialVersionUID = 8501416637305223280L;
    @ApiModelProperty("印章名称")
    private String sealName;

    @ApiModelProperty("查询时间，格式 yyyy-MM-dd HH:mm:ss")
    private String queryTime;

    @ApiModelProperty("印章状态，1:有效，2:无效")
    private String sealStatus;
}
