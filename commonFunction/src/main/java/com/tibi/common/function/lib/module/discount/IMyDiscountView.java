package com.tibi.common.function.lib.module.discount;

import com.tibi.common.function.lib.module.ticket.Ticket;

import java.util.List;

public interface IMyDiscountView {
    void getTicketDiscountList(List<Ticket> tickets);
}
