package com.tibi.common.function.lib.module.ticket;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.tibi.common.function.lib.api.HttpApi;
import com.tibi.common.function.lib.api.TbCallBack;
import com.tibi.common.function.lib.base.mvp.IPresenter;
import com.tibi.common.function.lib.module.ticket.detail.ITicketDetailView;
import com.tibi.common.function.lib.module.ticket.detail.TicketDetail;
import com.tibi.common.function.lib.util.StringUtils;


import java.util.List;

import io.reactivex.disposables.Disposable;
import lib.android.timingbar.com.http.exception.ApiException;

public class TicketPresenter implements IPresenter {
    private HttpApi httpApi;

    public TicketPresenter() {
        httpApi = new HttpApi();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {

    }

    /**
     * 获取购票列表
     *
     * @param userId
     * @param iTicketView
     * @return
     */
    public Disposable getTicketShopList(Context mContext, String userId, String productCode, final ICollarTicketView iTicketView) {
        Disposable disposable = httpApi.getTicketShopList(userId, productCode, new TbCallBack<List<Ticket>>(mContext) {
            @Override
            public void onFail(int code, ApiException e) {
                if (iTicketView != null) {
                    iTicketView.getTicketShopListResult(null);
                }
            }

            @Override
            public void onSuccess(List<Ticket> tickets) {
                Log.i("getTicketShopList", "tickets--" + tickets.size());
                if (iTicketView != null) {
                    iTicketView.getTicketShopListResult(tickets);
                }
            }
        });
        return disposable;
    }

    /**
     * 立即领取
     *
     * @param mContext
     * @param ticketApplyParams
     * @param iTicketView
     * @return
     */
    public Disposable putTicketApply(Context mContext, TicketApplyParams ticketApplyParams, final ITicketView iTicketView) {
        Disposable disposable = httpApi.putTicketApply(ticketApplyParams, new TbCallBack<String>(mContext) {
            @Override
            public void onFail(int code, ApiException e) {
                String msg = e.getMessage();
                if (StringUtils.isEmpty(msg)) {
                    msg = "领取失败！";
                }
                Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(String s) {
                if (iTicketView != null) {
                    iTicketView.ticketApplySuccess();
                }

            }
        });
        return disposable;
    }

    /**
     * 获取购票列表-详情
     *
     * @param iTicketDetailView
     * @return
     */
    public Disposable getTicketShopDetail(Context mContext, String discountId, final ITicketDetailView iTicketDetailView) {
        Disposable disposable = httpApi.getTicketDetail(discountId, new TbCallBack<String>(mContext) {
            @Override
            public void onFail(int code, ApiException e) {
                e.printStackTrace();
                Log.i("getTicketShopDetail", "onFail ticket=" + code);
                if (iTicketDetailView != null) {
                    iTicketDetailView.getTicketDetailResult(null);
                }
            }

            @Override
            public void onSuccess(String ticket) {
                Log.i("getTicketShopDetail", "onSuccess ticket=" + ticket);
                if (iTicketDetailView != null) {
                    iTicketDetailView.getTicketDetailResult(new TicketDetail(ticket));
                }
            }
        });
        return disposable;
    }
}
