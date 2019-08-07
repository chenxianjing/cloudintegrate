package org.cc.task.model.foreign;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 政府印章接口返回公共参数
 * @author chenxianjing
 * @date 2019.07.08 11:23
 */
@Data
public class GovCommonOModel<T> implements Serializable {


    private static final long serialVersionUID = -3259798380005266627L;

    @ApiModelProperty("接口名称(必须)")
    private String method;

    @ApiModelProperty("请求ID(必须)")
    private String requestId;

    @ApiModelProperty("请求结果代码(必须)")
    private String code;

    @ApiModelProperty("业务数据信息")
    private List<T> data;

    @ApiModelProperty("请求结果说明")
    private String message;
}
