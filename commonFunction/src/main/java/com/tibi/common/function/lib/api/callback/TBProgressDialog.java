package com.tibi.common.function.lib.api.callback;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


import com.tibi.common.function.lib.R;

import lib.android.timingbar.com.http.subsciber.IProgressDialog;
import lib.android.timingbar.com.imageloader.ImageLoader;
import lib.android.timingbar.com.imageloader.glide.GlideImageConfig;
import lib.android.timingbar.com.util.DataHelper;

/**
 * TBProgressDialog
 * -------------------------------------------------------------------------------------------------
 *
 * @author yelian on 2019/8/14
 */
public class TBProgressDialog implements IProgressDialog {
    Context mContext;
    ImageLoader imageLoader;
    @Override
    public Dialog getDialog() {
        Log.i("TBProgressDialog","getDialog 创建对话框dialog===");
        if(mContext != null) {
            Dialog dialog = new Dialog(mContext, R.style.dialog);
            dialog.setContentView(R.layout.dialog_loading);
            dialog.setCanceledOnTouchOutside(false);
            View view = dialog.getWindow().getDecorView();
            ImageView imageView = view.findViewById(R.id.iv_loading);
            String url = DataHelper.getMipmapImg(mContext, R.mipmap.loading);
            if (imageView == null) {
                imageLoader = new ImageLoader();
            }
            imageLoader.loadImage(mContext,
                    GlideImageConfig.builder().imageView(imageView).url(url).build());
            return dialog;
        }
        return  null;
    }
    public TBProgressDialog(Context context){
        this.mContext=context;
        imageLoader = new ImageLoader();
    }
}
