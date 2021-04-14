package com.tibi.common.function.lib.module.ticket;


import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tibi.common.function.lib.R;

import java.util.List;


/**
 * 购卷中心
 */
public abstract class TicketAdapter extends BaseQuickAdapter<Ticket, BaseViewHolder> implements OnItemChildClickListener {
    ITicketView iTicketView;
    public TicketAdapter(int layoutResId, List<Ticket> data,ITicketView iTicketView) {
        super(layoutResId, data);
        this.iTicketView = iTicketView;
        addChildClickViewIds(R.id.tv_ticket_operation);
    }

    @Override
    protected void convert(BaseViewHolder item, Ticket ticket) {
        item.setText(R.id.tv_ticket_type_name, ticket.getDiscountTypeName());
        item.setText(R.id.tv_ticket_name, ticket.getDiscountName());
        item.setText(R.id.tv_ticket_time, ticket.getDiscountName());
        if (ticket.getIsGain() == 1) {
            item.setGone(R.id.iv_is_gain, false);
        } else {
            item.setGone(R.id.iv_is_gain, true);
        }
    }
    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if(iTicketView != null) {
            iTicketView.getNow();
        }
    }
}
