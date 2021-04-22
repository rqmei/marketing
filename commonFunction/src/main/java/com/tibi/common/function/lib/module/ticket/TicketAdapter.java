package com.tibi.common.function.lib.module.ticket;


import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tibi.common.function.lib.R;
import com.tibi.common.function.lib.util.UIModuleHelper;

import java.util.List;

import androidx.core.content.ContextCompat;


/**
 * 购卷中心
 */
public class TicketAdapter extends BaseQuickAdapter<Ticket, BaseViewHolder> implements BaseQuickAdapter.OnItemChildClickListener {
    ICollarTicketView iTicketView;
    Activity activity;

    public TicketAdapter(Activity activity, int layoutResId, List<Ticket> data, ICollarTicketView iTicketView) {
        super(layoutResId, data);
        this.activity = activity;
        this.iTicketView = iTicketView;
        setOnItemChildClickListener(this);
    }

    @Override
    protected void convert(BaseViewHolder item, Ticket ticket) {
        item.setText(R.id.tv_ticket_type_name, ticket.getDiscountTypeName());
        item.setText(R.id.tv_ticket_name, ticket.getDiscountName());
        item.setText(R.id.tv_ticket_time, ticket.getTicketUseTime());
        if (ticket.getIsGain() == 1) {
            item.setGone(R.id.iv_is_gain, true);
            item.setTextColor(R.id.tv_ticket_operation, ContextCompat.getColor(activity, R.color.G1));
        } else {
            item.setGone(R.id.iv_is_gain, false);
            item.setTextColor(R.id.tv_ticket_operation, ContextCompat.getColor(activity, R.color.c1));
        }
        item.addOnClickListener(R.id.tv_ticket_operation, R.id.ll_ticket_item);

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        int i = view.getId();
        Log.i("adapter", "点击事件" + i);
        Ticket ticket = getItem(position);
        if (i == R.id.tv_ticket_operation) {
            // 立即领取
            if (iTicketView != null && ticket.getIsGain() == 0) {
                iTicketView.putTicketApply(ticket,position);
            }

        } else if (i == R.id.ll_ticket_item) {
            // 跳详情
            UIModuleHelper.toCollarTicketDetail(activity, ticket.getDiscountId(),ticket.getIsGain());
        }

    }

}
