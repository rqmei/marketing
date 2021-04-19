package com.tibi.common.function.lib.module.discount.detail;

import android.content.Context;

import com.tibi.common.function.lib.api.HttpApi;
import com.tibi.common.function.lib.api.TbCallBack;
import com.tibi.common.function.lib.module.ticket.Ticket;

import io.reactivex.disposables.Disposable;
import lib.android.timingbar.com.base.mvp.IPresenter;
import lib.android.timingbar.com.http.exception.ApiException;

public class DiscountDetailPresenter implements IPresenter {
    private HttpApi httpApi;

    public DiscountDetailPresenter() {
        httpApi = new HttpApi();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {

    }

    /**
     * 我的优惠-详情
     *
     * @param iDiscountDetailView
     * @return
     */
    public Disposable getTicketDiscountDetail(Context mContext, String discountId, final IDiscountDetailView iDiscountDetailView) {
        Disposable disposable = httpApi.getTicketDiscountDetail(discountId, new TbCallBack<Ticket>(mContext) {
            @Override
            public void onFail(int code, ApiException e) {
                if (iDiscountDetailView != null) {
                    iDiscountDetailView.getDiscountDetailResult(null);
                }
            }

            @Override
            public void onSuccess(Ticket ticket) {
                if (iDiscountDetailView != null) {
                    iDiscountDetailView.getDiscountDetailResult(ticket);
                }
            }
        });
        return disposable;
    }
}
