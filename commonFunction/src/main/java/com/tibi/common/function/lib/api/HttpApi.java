package com.tibi.common.function.lib.api;

import com.tibi.common.function.lib.module.ticket.Ticket;

import java.util.List;

import io.reactivex.disposables.Disposable;
import lib.android.timingbar.com.http.EasyHttp;
import lib.android.timingbar.com.http.callback.ProgressDialogCallBack;
import lib.android.timingbar.com.http.module.HttpParams;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpApi {
    /**
     * 分页查询新闻列表
     *
     * @return
     */
    public Disposable getCoupinShopList(String userId, int page, ProgressDialogCallBack<List<Ticket>> tbCallBack) {
        HttpParams params = new HttpParams();
        params.put("userId", userId);
        params.put("currentPage", page + "");
        params.put("pageSize", ApiConfig.PAGE_SIZE + "");
        return EasyHttp.get(ApiConfig.API_COUPIN_SHOP_LIST)
                .params(params)
                .addConverterFactory(GsonConverterFactory.create())
                .execute(tbCallBack);
    }
}
