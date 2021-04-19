package com.tibi.common.function.lib.api.callback;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.tibi.common.function.lib.R;

import lib.android.timingbar.com.base.util.DataHelper;
import lib.android.timingbar.com.http.subsciber.IProgressDialog;
import lib.android.timingbar.com.imageloader.ImageLoader;
import lib.android.timingbar.com.imageloader.glide.GlideImageConfig;

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
        String url = DataHelper.getMipmapImg(mContext,R.mipmap.loading);
        url = "https://img2.baidu.com/it/u=3054638224,4132759364&fm=26&fmt=auto&gp=0.jpg";
/*        new ImageLoader().loadImage(mContext,
                GlideImageConfig.builder().imageView(imageView).url(url).build());*/
//        Glide.with(mContext).load(url).into(imageView);
        return new ProgressDialog(mContext);
    }
    public TBProgressDialog(Context context){
        this.mContext=context;
    }
}
