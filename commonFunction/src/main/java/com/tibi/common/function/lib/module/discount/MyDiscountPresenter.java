package com.tibi.common.function.lib.module.discount;

import android.content.Context;
import android.util.Log;

import com.tibi.common.function.lib.api.HttpApi;
import com.tibi.common.function.lib.api.TbCallBack;
import com.tibi.common.function.lib.module.ticket.ITicketView;
import com.tibi.common.function.lib.module.ticket.Ticket;

import java.util.List;

import io.reactivex.disposables.Disposable;
import lib.android.timingbar.com.base.mvp.IPresenter;
import lib.android.timingbar.com.http.exception.ApiException;

public class MyDiscountPresenter implements IPresenter {
    private HttpApi httpApi;

    public MyDiscountPresenter() {
        httpApi = new HttpApi();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {

    }

    /**
     * 获取我的优惠列表
     *
     * @param userId
     * @param iMyDiscountView
     * @return
     */
    public Disposable getTicketDiscountList(Context mContext, String userId, String productCode, int currentPage, int state, final IMyDiscountView iMyDiscountView) {
        Disposable disposable = httpApi.getTicketDiscountList(userId, productCode, currentPage, state,
        new TbCallBack<List<Ticket>>(mContext) {
            @Override
            public void onFail(int code, ApiException e) {
                if (iMyDiscountView != null) {
                    iMyDiscountView.getTicketDiscountList(null);
                }
            }

            @Override
            public void onSuccess(List<Ticket> tickets) {
                Log.i("getTicketShopList", "tickets--" + tickets.size());
                if (iMyDiscountView != null) {
                    iMyDiscountView.getTicketDiscountList(tickets);
                }
            }
        });
        return disposable;
    }
}
