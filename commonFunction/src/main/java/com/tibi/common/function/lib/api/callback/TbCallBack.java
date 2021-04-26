package com.tibi.common.function.lib.api.callback;

import android.content.Context;
import android.util.Log;

import com.tibi.common.function.lib.api.callback.TBProgressDialog;

import lib.android.timingbar.com.http.callback.ProgressDialogCallBack;
import lib.android.timingbar.com.http.exception.ApiException;

/**
 * TbCallBack
 * -------------------------------------------------------------------------------------------------
 *
 * @param <T>
 * @author yelian on 2019/8/9
 */
public abstract class TbCallBack<T> extends ProgressDialogCallBack<T> {

    public TbCallBack() {
        super(null);
    }


    public TbCallBack(Context context) {
            // 带加载框的请求
            super(new TBProgressDialog(context), true, true);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("TbCallBack", "onStart===");
    }

    @Override
    public void onCompleted() {
        super.onCompleted();
        Log.i("TbCallBack", "onCompleted===");
    }

    @Override
    public void onError(ApiException e) {
        super.onError(e);
        Log.i("TbCallBack", "onError===" + e.getCode());
        // 统一处理请求返回的通用错误
        // 错误编码
        int code = e.getCode();
        // 错误描述
        String msg = e.getMessage();
        this.onFail(code, e);
    }

    public abstract void onFail(int code, ApiException e);
}
