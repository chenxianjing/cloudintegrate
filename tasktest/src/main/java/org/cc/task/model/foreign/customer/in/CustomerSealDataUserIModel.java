package org.cc.task.model.foreign.customer.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 印章数据<br>
 *
 * @author chenxianjing
 * @date 2019-06-18 15:25:31
 * @since 1.0.0
 */
@ApiModel(
        description = "用户印章状态"
)
@Data
public class CustomerSealDataUserIModel implements Serializable {

    private static final long serialVersionUID = 4645649917865549453L;

    @ApiModelProperty("印章名称")
    private String sealName;

    @ApiModelProperty("查询时间，格式 yyyy-MM-dd HH:mm:ss")
    private String queryTime;

    @ApiModelProperty("印章编码")
    private String sealCode;
    /**
     * 日志创建人id
     */
    @ApiModelProperty("日志创建人id")
    private String createdBy;

    @ApiModelProperty("查询ip")
    private String ip;
}
