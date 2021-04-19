package com.tibi.common.function.lib.module.ticket.detail;


import com.tibi.common.function.lib.module.ticket.ITicketView;

public interface ITicketDetailView  extends ITicketView {
    void getTicketDetailResult(TicketDetail ticketDetail);
}
