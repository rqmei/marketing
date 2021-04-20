package com.tibi.common.function.lib.module.discount;

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
import com.tibi.common.function.lib.base.User;
import com.tibi.common.function.lib.constant.SpConstant;
import com.tibi.common.function.lib.module.ticket.Ticket;
import com.tibi.common.function.lib.module.ticket.TicketAdapter;
import com.tibi.common.function.lib.util.RefreshNoDataUtil;
import com.tibi.common.function.lib.util.UIHelper;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import lib.android.timingbar.com.base.activity.BaseActivity;
import lib.android.timingbar.com.base.util.Sputil;

/**
 * 我的优惠
 */
public class MyDiscountActivity extends BaseActivity<MyDiscountPresenter> implements IMyDiscountView, View.OnClickListener {
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
    @BindView(R2.id.ll_list)
    LinearLayout llList;
    @BindView(R2.id.tv_discount_history)
    TextView tvDiscountHistory;
    String userId = "", productCode = "";
    int currentPage = 1;
    MyDiscountAdapter adapter;
    List<Discount> tickets = new ArrayList<>();

    @Override
    public int getLayoutResId() {
        return R.layout.my_discount;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        tvNavigationTitle.setText("我的优惠");
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        userId = getIntent().getStringExtra("userId");
        productCode = getIntent().getStringExtra("productCode");
        User user = new User(userId, productCode);
        Sputil.saveDeviceData(this, SpConstant.USER_DATA, user);
        adapter = new MyDiscountAdapter(this, 0, R.layout.ticket_item, tickets,
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
        ivNavigationLeft.setOnClickListener(this);
        tvDiscountHistory.setOnClickListener(this);

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

        mPresenter.getTicketDiscountList(this, currentPage, 1, this);
    }

    /**
     * 分页获取数据结果
     *
     * @param discountList
     */
    @Override
    public void getTicketDiscountList(List<Discount> discountList) {
        refreshLayout.finishRefresh();
        refreshLayout.finishLoadMore();
        if (currentPage == 1) {
            adapter.getData().clear();
        }
        if (discountList != null && discountList.size() > 0) {
            adapter.addData(discountList);
        }
        RefreshNoDataUtil.refreshNoData(adapter.getData(), recyclerView, llNoData);
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.iv_navigation_left) {
            finish();
        } else if (i == R.id.tv_discount_history) {
            UIHelper.toHistoryDiscountDetail(this);
        }
    }
}
