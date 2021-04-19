package com.tibi.common.function.lib.util;

import android.view.View;

import java.util.List;

/**
 * RefreshNoDataUtil
 * -----------------------------------------------------------------------------------------------------------------------------------
 *
 * @author yelian on 2019/10/11
 */
public class RefreshNoDataUtil {
    
    public static void refreshNoData(List list, View hasDataView,View NoDataView){
        if (list != null && list.size() > 0) {
            hasDataView.setVisibility(View.VISIBLE);
            NoDataView.setVisibility(View.GONE);
        } else {
            hasDataView.setVisibility(View.GONE);
            NoDataView.setVisibility(View.VISIBLE);
        }
    }
}
