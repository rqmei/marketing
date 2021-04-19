package com.tibi.common.function.lib.util;

import android.app.Activity;
import android.content.Intent;

import com.tibi.common.function.lib.module.discount.detail.DiscountDetailActivity;
import com.tibi.common.function.lib.module.discount.history.HistoryDiscountActivity;
import com.tibi.common.function.lib.module.ticket.detail.TicketDetailActivity;

public class UIHelper {
    /**
     * 购卷中心-跳详情
     *
     * @param activity
     * @param discountId
     */
    public static void toCollarTicketDetail(Activity activity,  String discountId,int isGain) {
        Intent intent = new Intent(activity, TicketDetailActivity.class);
        intent.putExtra("discountId", discountId);
        intent.putExtra("isGain",isGain);
        activity.startActivity(intent);
    }

    /**
     * 我的优惠-历史优惠
     *
     * @param activity
     */
    public static void toHistoryDiscountDetail(Activity activity) {
        Intent intent = new Intent(activity, HistoryDiscountActivity.class);
        activity.startActivity(intent);
    }
    /**
     * 我的优惠-跳详情
     *
     * @param activity
     * @param type 0：我的优惠 1：历史优惠
     */
    public static void toDiscountDetail(Activity activity,int type,  String discountId) {
        Intent intent = new Intent(activity, DiscountDetailActivity.class);
        intent.putExtra("discountId", discountId);
        intent.putExtra("type", type);
        activity.startActivity(intent);
    }
}
