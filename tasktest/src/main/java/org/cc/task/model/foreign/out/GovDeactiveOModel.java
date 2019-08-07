package org.cc.task.model.foreign.out;

import java.io.Serializable;
import java.util.List;

import org.cc.task.model.foreign.customer.out.CustomerSealDataInValidOModel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 印章吊销
 *
 * @author chenxianjing
 * @date 2019.07.08 11:23
 */
@Data
public class GovDeactiveOModel implements Serializable {

    private static final long serialVersionUID = 8440937475847066576L;

    @ApiModelProperty("版本号")
    private String version;

    @ApiModelProperty("本次查询生效时间,格式:yyyy-MM-dd HH;mm:ss")
    private String invalidEffectTime;

    @ApiModelProperty("下一次更新时间,建议更新时间一般为1个月，格式yyyy-MM-dd HH:mm:ss")
    private String nextUpdateTime;

    @ApiModelProperty("签名值")
    private String signature;

    @ApiModelProperty("签名算法")
    private String signAlgorithm;

    @ApiModelProperty("签名摘要算法")
    private String signHashAlgorithm;

    @ApiModelProperty("签名公钥")
    private String secretKey;

    @ApiModelProperty("颁发机构名称")
    private String awardCompany;

    @ApiModelProperty("印章吊销列表")
    private List<CustomerSealDataInValidOModel> revocationList;

}
