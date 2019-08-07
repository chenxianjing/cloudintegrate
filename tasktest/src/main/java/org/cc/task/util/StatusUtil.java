package org.cc.task.util;

import org.springframework.util.Assert;

import java.util.Date;
import java.util.Objects;

public class StatusUtil {

    /**
     * 印章是否有效判定
     * @param validStartTime
     * @param validEndTime
     * @param invalidEffectTime
     * @param invalidType
     * @return
     */
    public static boolean isValid(Date validStartTime, Date validEndTime, Date invalidEffectTime, Integer invalidType){
        return isValid(new Date(),validStartTime,validEndTime,invalidEffectTime,invalidType);
    }

    /**
     * 印章是否有效判定
     * @param compareDate
     * @param validStartTime
     * @param validEndTime
     * @param invalidEffectTime
     * @param invalidType
     * @return
     */
    public static boolean isValid(Date compareDate,Date validStartTime, Date validEndTime, Date invalidEffectTime, Integer invalidType){
        Assert.notNull(validStartTime,"validStartTime must not null");
        boolean flag = (compareDate.compareTo(validStartTime) > -1 && compareDate.compareTo(validEndTime) < 1);
        /**
         * invalidType默认值为100,invalidType默认值=100且当前时间在印章有效期内，说明此事印章是有效
         * invalidType不为100，0：吊销，1：撤销，2：挂失，说明印章申请了吊销或撤销或挂失，如果吊销或撤销或挂失的生效时间小于当前时间，
         * 说明吊销或撤销或挂失未生效，需判断印章是否在有效期内，逻辑同invalidType为100；否则说明吊销或撤销或挂失已生效，此时印章无效
         */
        if(invalidType == 100){
            if(flag){
                return true;
            }else{
                return false;
            }
        }else{
            if(!Objects.isNull(invalidEffectTime) && compareDate.compareTo(invalidEffectTime) > -1){
                return false;
            }else{
                if(flag){
                    return true;
                }else{
                    return false;
                }
            }
        }
    }
}
