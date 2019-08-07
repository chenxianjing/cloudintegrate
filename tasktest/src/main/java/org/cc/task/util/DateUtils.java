package org.cc.task.util;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期操作工具类<br>
 *
 * @author chenxianjing
 * @date 2019-06-18 15:25:31
 * @since 1.0.0
 */
@Slf4j
public class DateUtils {

    private final static String DEFALUT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private final static String DATE_FORMAT1 = "yyyy-MM-dd";

    private final static String DATE_FORMAT2 = "yyyyMMddHHmmss";

    /**
     * 字符串转日期
     * @param str 字符串
     * @return 日期 yyyy-MM-dd HH:mm:ss
     */
    public static Date strToDate(String str){
        SimpleDateFormat sdf = new SimpleDateFormat(DEFALUT_DATE_FORMAT);
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            log.error("字符串转换时间出错误",e);
            return null;
        }
    }

    /**
     * 日期转字符串
     * @param date 日期 yyyy-MM-dd
     * @return 字符串
     */
    public static String dateToStr(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT1);
        return sdf.format(date);
    }

    /**
     * 日期转字符串
     * @param date 日期 yyyy-MM-dd HH:mm:ss
     * @return 字符串
     */
    public static String dateToStr2(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(DEFALUT_DATE_FORMAT);
        return sdf.format(date);
    }

    /**
     * 日期转字符串
     * @param date 日期 yyyyMMddHHmmss
     * @return 字符串
     */
    public static String dateToStr3(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT2);
        return sdf.format(date);
    }
}
