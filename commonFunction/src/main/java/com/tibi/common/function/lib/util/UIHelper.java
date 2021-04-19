package com.tibi.common.function.lib.util;

import android.app.Activity;
import android.content.Intent;

import com.tibi.common.function.lib.module.discount.history.HistoryDiscountActivity;
import com.tibi.common.function.lib.module.ticket.detail.TicketDetailActivity;

public class UIHelper {
    /**
     * 购卷中心-跳详情
     *
     * @param activity
     * @param discountId
     */
    public static void toCollarTicketDetail(Activity activity,  String discountId) {
        Intent intent = new Intent(activity, TicketDetailActivity.class);
        intent.putExtra("discountId", discountId);
        activity.startActivity(intent);
    }

    /**
     * 我的优惠-历史优惠
     *
     * @param activity
     * @param userId
     */
    public static void toHistoryDiscountDetail(Activity activity, String userId, String productCode) {
        Intent intent = new Intent(activity, HistoryDiscountActivity.class);
        intent.putExtra("userId", userId);
        intent.putExtra("productCode", productCode);
        activity.startActivity(intent);
    }
}
