package org.cc.task.util;

public class CacheKeyUtil {
    /**
     * 本地查询
     */
    //用户印章状态信息
    public static final String USER_SEAL = "SealDataService:getUserSeal:";
    //用户吊销列表
    public static final String PAGE_INVALID_SEAL = "SealDataService:pageInValidSeal:";
    //对外公众查询接口
    public static final String WIDE = "SealDataService:getWide:";
    //电子印章状态信息查询
    public static final String PAGE_MSG = "SealDataService:pageMsg:";
    //印章数据ID获取状态变更数据
    public static final String DETAIL = "SealDataService:getDetail:";
    /**
     * 调用国家接口
     */
    public static final String GOV_TOKEN = "GovSealService:getToken:";

    /**
     * 获取随机数
     */
    public static final String GOV_RANDOM = "GovSealTransferService:getRandom:";

    /**
     * 获取密钥
     */
    public static final String GOV_SECRET = "GovSecretService:getSecret";
}
