package com.tibi.common.function.lib.api;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.tibi.common.function.lib.base.User;
import com.tibi.common.function.lib.constant.SpConstant;
import com.tibi.common.function.lib.module.discount.Discount;
import com.tibi.common.function.lib.module.ticket.Ticket;
import com.tibi.common.function.lib.module.ticket.TicketApplyParams;
import com.tibi.common.function.lib.util.Sputil;

import java.util.HashMap;
import java.util.List;

import io.reactivex.disposables.Disposable;
import lib.android.timingbar.com.http.EasyHttp;
import lib.android.timingbar.com.http.module.HttpParams;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpApi {

    public static void initEasyHttp(Application application) {
        EasyHttp.init(application);
        EasyHttp.getInstance()
                .setRetryCount(0)
                .debug("safe2.0", true);
    }

    /**
     * 领卷中心-获取购票列表
     *
     * @return
     */
    public Disposable getTicketShopList(String userId, String productCode, TbCallBack<List<Ticket>> tbCallBack) {
        HttpParams params = new HttpParams();
        params.put("userId", userId);
        params.put("productCode", productCode);
        return EasyHttp.get(ModuleApiConfig.MARKETING_HOSTSERVER+ModuleApiConfig.API_TICKET_SHOP_LIST)
                .params(params)
                .addConverterFactory(GsonConverterFactory.create())
                .execute(tbCallBack);
    }

    /**
     * 领卷中心-立即领取卷
     *
     * @return
     */
    public Disposable putTicketApply(TicketApplyParams ticketApplyParams, TbCallBack<String> tbCallBack) {
        HashMap params = new HashMap();
        params.put("userId", ticketApplyParams.getUserId());
        params.put("productCode", ticketApplyParams.getProductCode());
        params.put("discountId", ticketApplyParams.getDiscountId());
        params.put("holdType", ticketApplyParams.getHoldType() + "");
        Log.i("putTicketApply",new Gson().toJson(params));
        return EasyHttp.put(ModuleApiConfig.MARKETING_HOSTSERVER+ModuleApiConfig.API_TICKET_APPLY)
                .upObject(params)
                .addConverterFactory(GsonConverterFactory.create())
                .execute(tbCallBack);
    }

    /**
     * 领卷中心-详情
     *
     * @return
     */
    public Disposable getTicketDetail(String discountId, TbCallBack<String> tbCallBack) {
        HttpParams params = new HttpParams();
        params.put("discountId", discountId);
        return EasyHttp.get(ModuleApiConfig.MARKETING_HOSTSERVER+ModuleApiConfig.API_TICKET_DETAIL)
                .params(params)
                .addConverterFactory(GsonConverterFactory.create())
                .execute(tbCallBack);
    }


    /**
     * 获取我的优惠列表
     * @param state 1:我的优惠 99：历史优惠
     * @return
     */
    public Disposable getTicketDiscountList(Context context, int currentPage, int state, TbCallBack<List<Discount>> tbCallBack) {
        HttpParams params = new HttpParams();
        User user = Sputil.getDeviceData(context,SpConstant.USER_DATA);
        if(user != null) {
            params.put("userId", user.getUserId());
            params.put("productCode", user.getProductCode());
        }
        params.put("state",state+"");
        params.put("pageSize", ModuleApiConfig.PAGE_SIZE + "");
        params.put("currentPage", currentPage + "");
        return EasyHttp.get(ModuleApiConfig.MARKETING_HOSTSERVER+ModuleApiConfig.API_TICKET_DISCOUNT_LIST)
                .params(params)
                .addConverterFactory(GsonConverterFactory.create())
                .execute(tbCallBack);
    }
    /**
     * 获取我的优惠列表-详情
     *
     * @return
     */
    public Disposable getTicketDiscountDetail(String discountId, TbCallBack<Discount> tbCallBack) {
        HttpParams params = new HttpParams();
        params.put("discountId",discountId);
        return EasyHttp.get(ModuleApiConfig.MARKETING_HOSTSERVER+ModuleApiConfig.API_TICKET_DISCOUNT_DETAIL)
                .params(params)
                .addConverterFactory(GsonConverterFactory.create())
                .execute(tbCallBack);
    }
}
