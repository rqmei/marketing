package com.tibi.common.function.lib.api;

/**
 * 接口定义
 */
public class ModuleApiConfig {
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
    public static String API_TICKET_SHOP_LIST = "/purchasing/discount/list";

    /**
     * 我的优惠列表
     */
    public static String API_TICKET_DISCOUNT_LIST = "/discountTicket/page/list";

    /**
     * 立即领取
     */
    public static String API_TICKET_APPLY = "/purchasing/get/discount";
    /**
     * 优惠详情
     */
    public static String
            API_TICKET_DETAIL = "/discountManage/one";
    /**
     * 优惠券详情
     */
    public static String API_TICKET_DISCOUNT_DETAIL = "/discountTicket/one";
}
