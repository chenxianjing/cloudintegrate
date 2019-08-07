package org.cc.task.model.foreign.in;

import java.io.Serializable;

import org.cc.task.model.foreign.GovCommonIModel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 印章吊销
 *
 * @author chenxianjing
 * @date 2019.07.08 11:23
 */
@Data
public class GovDeactiveIModel extends GovCommonIModel implements Serializable {


    private static final long serialVersionUID = 3928992568462550499L;

    //--------------------------------------------------------
    //业务参数 start
    @ApiModelProperty("查询起始时间 格式 yyyy-MM-dd HH:mm:ss(必须)")
    private String queryStartTime;

    @ApiModelProperty("查询截止时间 格式 yyyy-MM-dd HH:mm:ss(必须)")
    private String queryEndTime;

    @ApiModelProperty("吊销列表每页数量")
    private String pageSize;

    @ApiModelProperty("吊销列表当前页数")
    private String pageNow;
    //业务参数 end
    //-------------------------------------------------------
}
