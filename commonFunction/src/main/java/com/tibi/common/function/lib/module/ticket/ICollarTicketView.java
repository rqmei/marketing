package com.tibi.common.function.lib.module.ticket;

import java.util.List;

public interface ICollarTicketView extends ITicketView {
    /**
     * 获取购卷列表
     *
     * @param tickets
     */
    void getTicketShopListResult(List<Ticket> tickets);
    /**
     * 立即领取
     */
    void putTicketApply(Ticket ticket);
}
