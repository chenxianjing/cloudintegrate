package org.cc.task.enums;

import lombok.Getter;

/**
 * 调用国家状态状态枚举<br>
 *
 * @author chenxianjing
 * @date 2019-06-18 13:13:36
 * @since 1.0.0
 */
public enum GovStatusEnum {

    SUCCESS("0","成功");

    @Getter
    private String code;
    @Getter
    private String value;

    GovStatusEnum(String code,String value){
        this.code = code;
        this.value = value;
    }
}
