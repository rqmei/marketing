package com.tibi.common.function.lib.view.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;


import com.tibi.common.function.lib.R;

import androidx.fragment.app.FragmentManager;
import lib.android.timingbar.com.view.CustomDialog;

/**
 * DialogManager
 * -------------------------------------------------------------------------------------------------
 *
 * @author rqmei on 2019/4/22
 */
public class DialogManager {
    Context mContext;
    FragmentManager fragmentManager;

    public DialogManager(Context mContext, FragmentManager fragmentManager) {
        this.mContext = mContext;
        this.fragmentManager = fragmentManager;
    }

    /**
     * 切换岗位的弹框
     */
    CustomDialog dialogOneBtn;


    /**
     * 视频加载出错
     */
    public void showOneBtnDialog(String content, String btn) {
        //取消选中
        //构建弹框dialog
        dialogOneBtn = new CustomDialog.Builder(mContext)
                .view(R.layout.dialog_one_button)
                .style(R.style.MiddleDialogStyle)
                .widthDimenRes(R.dimen.dp_250)
                .setText(R.id.tv_dialog_content, content)
                .setText(R.id.stv_ok, btn)
                .addViewOnclick(R.id.stv_ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogOneBtn.dimiss();
                    }
                })
                .gravity(Gravity.CENTER).build();
        //弹框透明度
        dialogOneBtn.setDefaultAlpha(0.8f);
        dialogOneBtn.show(fragmentManager);
    }
}
