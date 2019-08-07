package org.cc.task.model.foreign.out;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * token的输出数据
 *
 * @author chenxianjing
 * @date 2019.07.08 11:23
 */
@Data
public class GovTokenOModel implements Serializable {


    private static final long serialVersionUID = -2151545175468757953L;

    @ApiModelProperty("生成的token")
    private String access_token;

    @ApiModelProperty("token类型")
    private String token_type;

    @ApiModelProperty("有效时间")
    private String expires_in;

    @ApiModelProperty("授权范围")
    private String scope;
}
