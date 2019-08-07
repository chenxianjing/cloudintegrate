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
public class GovTextIModel implements Serializable {

    private static final long serialVersionUID = -6544423827937182134L;

    @ApiModelProperty("任务码:印章数据发布207;印章延期/续期103;印章吊销、挂失、撤销209")
    private String taskCode;

    @ApiModelProperty("印章数据")
    private String taskData;

    @ApiModelProperty("签名值")
    private String taskSignature;
}
