package org.cc.task.enums;

import lombok.Getter;

/**
 * 任务状态
 * @author chenxianjing
 * @date 2019-07-10 17:16
 * @since 1.0.0
 */
public enum TaskEnum {

    RELEASE("207","印章发布"),RENEWAL("108","印章延期/续期"),DEACTIVE("209","印章吊销、挂失、撤销");
    @Getter
    private String code;
    @Getter
    private String value;

    TaskEnum(String code,String value){
        this.code = code;
        this.value = value;
    }
}
