package org.cc.task.util;
/**
 *  政府电子印章<br>
 *
 * @author chenxianjing
 * @date 2019-07-05 14:13:31
 * @since 1.0.0
 */
public class GovSealMethod {

    //获取token的方法名
    public static final String TOKEN_METHOD = "DB.oauth.token";
    //注册或非注册用户获取印章状态的方法名
    public static final String REGISTER_QUERY = "DB.seal.status.query";
    //印章吊销查询
    public static final String DEACTIVE_QUERY = "DB.seal.deactive.list.query";
}
