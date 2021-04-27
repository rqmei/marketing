package com.tibi.common.function.lib.module.discount;

import android.content.Context;
import android.util.Log;

import com.tibi.common.function.lib.api.HttpApi;
import com.tibi.common.function.lib.api.callback.TbCallBack;

import java.util.List;

import io.reactivex.disposables.Disposable;
import lib.android.tb.common.base.mvp.IPresenter;
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
     * @param iMyDiscountView
     * @return
     */
    public Disposable getTicketDiscountList(Context mContext, int currentPage, int state, final IMyDiscountView iMyDiscountView) {
        Disposable disposable = httpApi.getTicketDiscountList(mContext, currentPage, state,
        new TbCallBack<List<Discount>>(currentPage == 1 ? mContext : null) {
            @Override
            public void onFail(int code, ApiException e) {
                if (iMyDiscountView != null) {
                    iMyDiscountView.getTicketDiscountList(null);
                }
            }

            @Override
            public void onSuccess(List<Discount> discounts) {
                Log.i("getTicketShopList", "tickets--" + discounts.size());
                if (iMyDiscountView != null) {
                    iMyDiscountView.getTicketDiscountList(discounts);
                }
            }
        });
        return disposable;
    }
}
