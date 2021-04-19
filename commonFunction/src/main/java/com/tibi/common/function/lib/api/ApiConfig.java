package com.tibi.common.function.lib.api;

/**
 * 接口定义
 */
public class ApiConfig {
    public static boolean DEBUG = true;
    /**
     * 页容量用于分页传参，项目统一
     */
    public static final int PAGE_SIZE = 10;
    /**
     * 营销系统基础路径
     */
//    public static String MARKETING_HOSTSERVER = DEBUG ? "http://marketing-api.t1.tb.com/" : "https://app.tbatb.net/sso/";
    public static String MARKETING_HOSTSERVER = "http://192.168.18.147:8210/";
    /**
     * 购券中心列表
     */
    public static String API_TICKET_SHOP_LIST = "/api/purchasing/discount/list";

    /**
     * 我的优惠列表
     */
    public static String API_TICKET_DISCOUNT_LIST = "/api/discountTicket/page/list";

    /**
     * 立即领取
     */
    public static String API_TICKET_APPLY = "/api/purchasing/get/discount";
    /**
     * 优惠详情
     */
    public static String
            API_TICKET_DETAIL = "/api/discountManage/one";
    /**
     * 优惠券详情
     */
    public static String API_TICKET_DISCOUNT_DETAIL = "/api/discountTicket/one";
}
