package com.star.common.constant;

/**
 * 用户常量信息
 *
 * @author ruoyi
 */
public class RedisConstants {

    /**
     * 公司地址经纬度集合
     */
    public static String getTokenKey(String userId){
        return "login:token:" + userId;
    }

    /**
     * 公司地址经纬度集合
     */
    public static final String COMPANY_ = "company_";

    /**
     * 公司地址经纬度集合
     */
    public static final String COMPANY_LOCATION = "company:location";

    /**
     * 师傅提交草稿
     */
    public static final String WORKER_ACEPTANCE_DRAFT = "worker:aceptance:draft:";

    /**
     * 师傅提交补单草稿
     */
    public static final String WORKER_SUPPLEMENT_DRAFT = "worker:supplement:draft:";
}
