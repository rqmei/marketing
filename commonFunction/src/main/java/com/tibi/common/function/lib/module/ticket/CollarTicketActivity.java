package com.tibi.common.function.lib.module.ticket;

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
import lib.android.timingbar.com.base.activity.BaseActivity;
import com.tibi.common.function.lib.constant.SpConstant;
import com.tibi.common.function.lib.util.RefreshNoDataUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import lib.android.timingbar.com.util.Sputil;

/**
 * 领卷中心
 */
public class CollarTicketActivity extends BaseActivity<TicketPresenter> implements ICollarTicketView {
    @BindView(R2.id.iv_navigation_left)
    ImageView ivNavigationLeft;
    @BindView(R2.id.tv_navigation_title)
    TextView tvNavigationTitle;
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
    TicketAdapter adapter;
    List<Ticket> tickets = new ArrayList<>();
    String userId = "", productCode = "";


    @Override
    public int getLayoutResId() {
        return R.layout.collar_ticket;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        tvNavigationTitle.setText("领券中心");
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        initData();
    }

    @Override
    public TicketPresenter obtainPresenter() {
        return new TicketPresenter();
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

    private void initData() {
        userId = getIntent().getStringExtra("userId");
        productCode = getIntent().getStringExtra("productCode");
        User user = new User(userId, productCode);
        Sputil.saveDeviceData(this, SpConstant.USER_DATA, user);
        adapter = new TicketAdapter(this, R.layout.ticket_item, tickets, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        // 是否启用越界回弹
        refreshLayout.setEnableOverScrollBounce(false);
        refreshLayout.setEnableLoadMore(false);
        refreshLayout.setEnableRefresh(true);
        // 启用嵌套滚动
        refreshLayout.setEnableNestedScroll(true);
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {

            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                refresh();
                Log.i("下拉刷新--", adapter.getData().size() + "");
            }
        });

        refresh();
    }

    /**
     * 下拉刷新
     */
    public void refresh() {

        mPresenter.getTicketShopList(CollarTicketActivity.this, userId, productCode, this);
    }

    @Override
    public void getTicketShopListResult(List<Ticket> ticketList) {
        refreshLayout.finishRefresh();
        RefreshNoDataUtil.refreshNoData(ticketList, recyclerView, llNoData);
        if (ticketList != null && ticketList.size() > 0) {
            tickets = ticketList;
            adapter.getData().clear();
            adapter.addData(tickets);
        }
    }

    @Override
    public void putTicketApply(Ticket ticket,int position) {
        TicketApplyParams ticketApplyParams = new TicketApplyParams();
        ticketApplyParams.setUserId(userId);
        ticketApplyParams.setProductCode(productCode);
        ticketApplyParams.setDiscountId(ticket.getDiscountId());
        ticketApplyParams.setHoldType(20);
        mPresenter.putTicketApply(this, ticketApplyParams, position, this);
    }

    @Override
    public void ticketApplySuccess(int position) {
        if(adapter.getItemCount() > position){
            Ticket ticket = adapter.getItem(position);
            ticket.setIsGain(1);
            adapter.setData(position,ticket);
        }
    }

}
