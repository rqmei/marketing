package com.tibi.common.function.lib.module.discount.history;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.tibi.common.function.lib.R;
import com.tibi.common.function.lib.R2;
import com.tibi.common.function.lib.base.activity.BaseActivity;
import com.tibi.common.function.lib.module.discount.Discount;
import com.tibi.common.function.lib.module.discount.IMyDiscountView;
import com.tibi.common.function.lib.module.discount.MyDiscountAdapter;
import com.tibi.common.function.lib.module.discount.MyDiscountPresenter;
import com.tibi.common.function.lib.module.ticket.Ticket;
import com.tibi.common.function.lib.util.RefreshNoDataUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class HistoryDiscountActivity extends BaseActivity<MyDiscountPresenter> implements IMyDiscountView {
    @BindView(R2.id.iv_navigation_left)
    ImageView ivNavigationLeft;
    @BindView(R2.id.tv_navigation_title)
    TextView tvNavigationTitle;
    @BindView(R2.id.iv_navigation_right)
    ImageView ivNavigationRight;
    @BindView(R2.id.tv_tips)
    TextView tvTips;
    @BindView(R2.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R2.id.iv_no_data)
    ImageView ivNoData;
    @BindView(R2.id.tv_no_data)
    TextView tvNoData;
    @BindView(R2.id.ll_no_data)
    LinearLayout llNoData;
    @BindView(R2.id.footer)
    ClassicsFooter footer;
    @BindView(R2.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R2.id.tv_discount_history)
    TextView tvDiscountHistory;
    int currentPage = 1;
    MyDiscountAdapter adapter;

    @Override
    public int getLayoutResId() {
        return R.layout.my_discount;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        tvNavigationTitle.setText("历史优惠");
        tvTips.setVisibility(View.GONE);
        tvDiscountHistory.setVisibility(View.GONE);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        adapter = new MyDiscountAdapter(this, 1, R.layout.ticket_item, new ArrayList<>(),
                this, getSupportFragmentManager());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        // 是否启用越界回弹
        refreshLayout.setEnableOverScrollBounce(false);
        refreshLayout.setEnableLoadMore(true);
        refreshLayout.setEnableRefresh(true);
        // 启用嵌套滚动
        refreshLayout.setEnableNestedScroll(true);
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                loadMore();
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                refresh();
                Log.i("下拉刷新--", adapter.getData().size() + "");
            }
        });
        getDiscountList();
    }

    @Override
    public MyDiscountPresenter obtainPresenter() {
        return new MyDiscountPresenter();
    }

    @Override
    public void registerListener() {
        ivNavigationLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void refresh() {
        currentPage = 1;
        getDiscountList();

    }

    private void loadMore() {
        currentPage = currentPage + 1;
        getDiscountList();
    }

    private void getDiscountList() {
        mPresenter.getTicketDiscountList(this, currentPage, 99, this);
    }

    /**
     * 分页获取数据结果
     */
    @Override
    public void getTicketDiscountList(List<Discount> discounts) {
        refreshLayout.finishRefresh();
        refreshLayout.finishLoadMore();
        if (currentPage == 1) {
            adapter.getData().clear();
        }
        if (discounts != null && discounts.size() > 0) {
            adapter.addData(discounts);
        }
        RefreshNoDataUtil.refreshNoData(adapter.getData(), recyclerView, llNoData);
    }
}
