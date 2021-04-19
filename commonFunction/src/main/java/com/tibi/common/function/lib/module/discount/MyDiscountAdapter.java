package com.tibi.common.function.lib.module.discount;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tibi.common.function.lib.R;
import com.tibi.common.function.lib.module.ticket.Ticket;
import com.tibi.common.function.lib.util.UIHelper;
import com.tibi.common.function.lib.view.dialog.DialogManager;

import java.util.List;

import androidx.fragment.app.FragmentManager;

public class MyDiscountAdapter extends BaseQuickAdapter<Ticket, BaseViewHolder> implements OnItemChildClickListener {
    IMyDiscountView iMyDiscountView;
    /**
     * 0：我的优惠 1：历史优惠
     */
    int type = 0;
    Activity activity;
    DialogManager dialogManager;

    public MyDiscountAdapter(Activity activity, int type, int layoutResId, List<Ticket> data, IMyDiscountView iMyDiscountView, FragmentManager fragmentManager) {
        super(layoutResId, data);
        this.activity = activity;
        this.type = type;
        this.iMyDiscountView = iMyDiscountView;
        dialogManager = new DialogManager(activity, fragmentManager);
        addChildClickViewIds(R.id.tv_ticket_operation, R.id.ll_ticket_item);
        setOnItemChildClickListener(this);
    }

    @Override
    protected void convert(BaseViewHolder item, Ticket ticket) {
        item.setText(R.id.tv_ticket_type_name, ticket.getDiscountTypeName());
        item.setText(R.id.tv_ticket_name, ticket.getDiscountName());
        item.setText(R.id.tv_ticket_time, ticket.getTicketUseTime());
        item.setText(R.id.tv_ticket_operation, "立即使用");
        item.setGone(R.id.iv_is_gain, true);
        if (type == 0) {
            item.setGone(R.id.tv_ticket_operation, false);
        } else {
            item.setGone(R.id.tv_ticket_operation, true);
        }
        //  状态（0：无效，1:草稿，2：停用，3:启用，10：过期）
        int state = ticket.getState();
        if (state == 0) {
            item.setImageResource(R.id.iv_state, R.mipmap.invalid);
        } else if (state == 1 || state == 2) {
            item.setImageResource(R.id.iv_state, R.mipmap.not_available);
        } else if (state == 3) {
            item.setImageResource(R.id.iv_state, R.mipmap.unuser);
        } else if (state == 10) {
            item.setImageResource(R.id.iv_state, R.mipmap.expired);
        } else {
            item.setImageResource(R.id.iv_state, R.mipmap.used);
        }
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        int i = view.getId();
        Log.i("adapter", "点击事件" + i);
        Ticket ticket = getItem(position);
        if (i == R.id.tv_ticket_operation) {
            // 立即使用
            if (dialogManager != null) {
                dialogManager.showOneBtnDialog("当前优惠券暂时无法使用", "确定");
            }

        } else if (i == R.id.ll_ticket_item) {
            // 跳详情
            UIHelper.toCollarTicketDetail(activity, ticket.getDiscountId());
        }

    }
}