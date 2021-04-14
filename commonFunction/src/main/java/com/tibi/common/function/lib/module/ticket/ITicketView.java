package com.tibi.common.function.lib.module.ticket;

import java.util.List;

public interface ITicketView {
    /**
     * 获取购卷列表
     *
     * @param tickets
     */
    void getCoupinShopListResult(List<Ticket> tickets);

    /**
     * 立即领取
     */
    void getNow();
}
