package org.cc.task.model.foreign.out;

import java.io.Serializable;

import org.springframework.util.StringUtils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
/**
 * 印章吊销
 *
 * @author chenxianjing
 * @date 2019.07.10 14:56
 */
@Slf4j
public class GovRandomOModel implements Serializable {


    private static final long serialVersionUID = 3719452484279100738L;

    @ApiModelProperty("获取随机数成功为“0”，失败为“1”")
    @Getter
    @Setter
    private String result;

    @ApiModelProperty("返回的描述信息")
    @Getter
    @Setter
    private String msg;

    @ApiModelProperty("随机数，签名值，国办发布系统证书拼接的字符串,格式:idB||randomB||randomA||signValue")
    @Getter
    @Setter
    private volatile String token;

    @ApiModelProperty("国家政务服务平台电子印章状态发布系统生成的随机数")
    private transient String randomB;

    @ApiModelProperty("国家政务服务平台电子印章状态发布系统的内部签名")
    private transient String signValue;

    @ApiModelProperty("国家政务服务平台电子印章状态发布系统证书")
    private transient String certB;

    /**
     * token 拆分
     * @return
     */
    private String[] getTokenSplit(){
        String[] empty = new String[]{"","",""};
        if(StringUtils.hasText(token)){
            if(StringUtils.hasText(token)){
                synchronized(this){
                    if(StringUtils.hasText(token)){
                        String[] tokenSplit = token.split("||");
                        if(tokenSplit.length != 4){
                            log.error("token格式不对,{}",token);
                            return empty;
                        }
                        return tokenSplit;
                    }
                }
            }
        }
        return empty;
    }

    public String getRandomB(){
        return getTokenSplit()[0];
    }

    public String getSignValue(){
        return getTokenSplit()[1];
    }

    public String getCertB(){
        return getTokenSplit()[2];
    }
}
