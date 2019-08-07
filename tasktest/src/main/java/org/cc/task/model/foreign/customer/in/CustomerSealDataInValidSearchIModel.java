package org.cc.task.model.foreign.customer.in;


import org.cc.task.model.foreign.customer.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 吊销印章<br>
 *
 * @author chenxianjing
 * @date 2019-06-18 15:25:31
 * @since 1.0.0
 */
@ApiModel(
        description = "吊销印章",parent = Model.class
)
@Data
public class CustomerSealDataInValidSearchIModel extends Model{

    @ApiModelProperty("查询起始时间 格式 yyyy-MM-dd HH:mm:ss")
    private String queryStartTime;

    @ApiModelProperty("查询截止时间 格式 yyyy-MM-dd HH:mm:ss")
    private String queryEndTime;

    @ApiModelProperty("查询用户id")
    private String createdBy;

    @ApiModelProperty("查询ip")
    private String ip;
}
