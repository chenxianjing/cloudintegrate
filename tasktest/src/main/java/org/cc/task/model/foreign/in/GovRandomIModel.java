package org.cc.task.model.foreign.in;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * 电子印章同步数据获取随机数接口（身份认证）
 *
 * @author chenxianjing
 * @date 2019.07.10 14:55
 */
public class GovRandomIModel  implements Serializable {


    private static final long serialVersionUID = 459463742034740226L;
    @Getter
    private RandomParam parameters;

    @Builder
    private static final class RandomParam  implements Serializable{

        private static final long serialVersionUID = 5183291500142867083L;

        @ApiModelProperty("省发布系统的证书(必须)")
        @Getter
        private String idA;
        @ApiModelProperty("16位长度的随机数(必须)")
        @Getter
        private String randomA;
    }

    public GovRandomIModel(String idA,String randomA){
        parameters = new RandomParam(idA,randomA);
    }
}
