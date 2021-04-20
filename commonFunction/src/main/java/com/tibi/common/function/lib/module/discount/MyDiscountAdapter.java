package com.tibi.common.function.lib.module.discount;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tibi.common.function.lib.R;
import com.tibi.common.function.lib.util.UIModuleHelper;
import com.tibi.common.function.lib.view.dialog.DialogManager;

import java.util.List;

import androidx.fragment.app.FragmentManager;

public class MyDiscountAdapter extends BaseQuickAdapter<Discount, BaseViewHolder> implements BaseQuickAdapter.OnItemChildClickListener {
    IMyDiscountView iMyDiscountView;
    /**
     * 0：我的优惠 1：历史优惠
     */
    int type = 0;
    Activity activity;
    DialogManager dialogManager;

    public MyDiscountAdapter(Activity activity, int type, int layoutResId, List<Discount> data, IMyDiscountView iMyDiscountView, FragmentManager fragmentManager) {
        super(layoutResId, data);
        this.activity = activity;
        this.type = type;
        this.iMyDiscountView = iMyDiscountView;
        dialogManager = new DialogManager(activity, fragmentManager);

        setOnItemChildClickListener(this);
    }

    @Override
    protected void convert(BaseViewHolder item, Discount discount) {
        item.setText(R.id.tv_ticket_type_name, discount.getDiscountTypeName());
        item.setText(R.id.tv_ticket_name, discount.getDiscountName());
        item.setText(R.id.tv_ticket_time, discount.getTicketUseTime());
        item.setText(R.id.tv_ticket_operation, "立即使用");
        item.setGone(R.id.iv_is_gain, false);
        if (type == 0) {
            item.setGone(R.id.tv_ticket_operation, true);
            item.setGone(R.id.view_line,true);
        } else {
            item.setGone(R.id.tv_ticket_operation, false);
            item.setGone(R.id.view_line,false);
        }
        //  状态（0：无效，1:未使用，2：已使用，3:过期，4：不可用）
        int state = discount.getState();
        if (state == 0) {
            item.setImageResource(R.id.iv_state, R.mipmap.invalid);
        } else if (state == 1) {
            item.setImageResource(R.id.iv_state, R.mipmap.unuser);
        } else if (state == 2) {
            item.setImageResource(R.id.iv_state, R.mipmap.used);
        } else if (state == 3) {
            item.setImageResource(R.id.iv_state, R.mipmap.expired);
        } else if (state == 4) {
            item.setImageResource(R.id.iv_state, R.mipmap.not_available);
        }
        item.addOnClickListener(R.id.tv_ticket_operation, R.id.ll_ticket_item);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        int i = view.getId();
        Log.i("adapter", "点击事件" + i);
        Discount discount = getItem(position);
        if (i == R.id.tv_ticket_operation) {
            // 立即使用
            if (dialogManager != null) {
                dialogManager.showOneBtnDialog("当前优惠券暂时无法使用", "确定");
            }

        } else if (i == R.id.ll_ticket_item) {
            // 跳详情
            UIModuleHelper.toDiscountDetail(activity,type, discount.getDiscountId());
        }

    }
}