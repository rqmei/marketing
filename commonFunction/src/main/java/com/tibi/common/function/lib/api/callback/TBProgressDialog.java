package com.tibi.common.function.lib.api.callback;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.tibi.common.function.lib.R;

import lib.android.timingbar.com.http.subsciber.IProgressDialog;

/**
 * TBProgressDialog
 * -------------------------------------------------------------------------------------------------
 *
 * @author yelian on 2019/8/14
 */
public class TBProgressDialog implements IProgressDialog {
    Context mContext;
    @Override
    public Dialog getDialog() {
        Log.i("TBProgressDialog","getDialog 创建对话框dialog===");
        Dialog dialog = new Dialog (mContext, R.style.dialog);
        dialog.setContentView (R.layout.dialog_loading);
        dialog.setCanceledOnTouchOutside(false);
        View view = dialog.getWindow().getDecorView();
        ImageView imageView=view.findViewById(R.id.iv_loading);
//        String url = DataHelper.getMipmapImg(mContext,R.mipmap.loading);
//        Glide.with(mContext).load(R.mipmap.loading).into(imageView);

        return dialog;
    }
    public TBProgressDialog(Context context){
        this.mContext=context;
    }
}
