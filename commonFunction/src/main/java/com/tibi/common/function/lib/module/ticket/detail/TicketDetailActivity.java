package com.tibi.common.function.lib.module.ticket.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tibi.common.function.lib.R;
import com.tibi.common.function.lib.R2;
import com.tibi.common.function.lib.base.User;
import com.tibi.common.function.lib.constant.SpConstant;
import com.tibi.common.function.lib.module.ticket.TicketApplyParams;
import com.tibi.common.function.lib.module.ticket.TicketPresenter;
import com.tibi.common.function.lib.util.StringUtils;


import butterknife.BindView;
import lib.android.timingbar.com.base.activity.BaseActivity;
import lib.android.timingbar.com.base.util.Sputil;
import lib.android.timingbar.com.view.ShapeTextView;

/**
 * 领卷中心-详情
 */
public class TicketDetailActivity extends BaseActivity<TicketPresenter> implements ITicketDetailView {
    String discountId = "";
    @BindView(R2.id.iv_navigation_left)
    ImageView ivNavigationLeft;
    @BindView(R2.id.tv_navigation_title)
    TextView tvNavigationTitle;
    @BindView(R2.id.tv_ticket_type_name)
    TextView tvTicketTypeName;
    @BindView(R2.id.tv_ticket_state)
    TextView tvTicketState;
    @BindView(R2.id.tv_use_time)
    TextView tvUseTime;
    @BindView(R2.id.stv_use)
    ShapeTextView stvUse;
    @BindView(R2.id.tv_discount)
    TextView tvDiscount;
    @BindView(R2.id.tv_scene)
    TextView tvScene;
    @BindView(R2.id.tv_consume)
    TextView tvConsume;
    @BindView(R2.id.tv_commodity_type)
    TextView tvCommodityType;
    @BindView(R2.id.tv_commodity_name)
    TextView tvCommodityName;
    @BindView(R2.id.tv_buy_time)
    TextView tvBuyTime;
    @BindView(R2.id.tv_buy_count)
    TextView tvBuyCount;
    @BindView(R2.id.tv_buy_amount)
    TextView tvBuyAmount;
    @BindView(R2.id.tv_explain)
    TextView tvExplain;

    @Override
    public int getLayoutResId() {
        return R.layout.ticket_detail;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        discountId = getIntent().getStringExtra("discountId");
        getTicketDetail();
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

    private void getTicketDetail() {
        mPresenter.getTicketShopDetail(this, discountId, this);
    }

    @Override
    public void getTicketDetailResult(TicketDetail ticket) {
        if (ticket != null) {
            if (ticket.getState() == 3) {
                stvUse.setBackgroundColor(R.color.c1);
            } else {
                stvUse.setBackgroundColor(R.color.G4);
            }

            tvTicketTypeName.setText(ticket.getDiscountTypeName());
            tvTicketState.setText(ticket.getStateStr());
            tvUseTime.setText(ticket.getTicketUseTime());
            tvDiscount.setText("优惠规则：" + ticket.getDiscountRuleDetailJoin());
            tvScene.setText("使用场景：" + ticket.getUseConditionTypeName());
            tvExplain.setText("说明：" + ticket.getDescription());

            tvConsume.setText("消费条件：" + ticket.getConditionTypeName());

            // 商品类型
            String ticketTypeName = ticket.getTicketTypeName();
            if (StringUtils.isEmpty(ticketTypeName)) {
                tvCommodityType.setVisibility(View.GONE);
            } else {
                tvCommodityType.setVisibility(View.VISIBLE);
                tvCommodityType.setText("商品类型：" + ticketTypeName);
            }

            // 商品名称
            String ticketName = ticket.getTicketName();
            if (StringUtils.isEmpty(ticketName)) {
                tvCommodityName.setVisibility(View.GONE);
            } else {
                tvCommodityName.setVisibility(View.VISIBLE);
                tvCommodityName.setText("商品名称：" + ticketName);
            }

            // 购买日期范围
            String payTime = ticket.getPayTime();
            if (StringUtils.isEmpty(payTime)) {
                tvBuyTime.setVisibility(View.GONE);
            } else {
                tvBuyTime.setVisibility(View.VISIBLE);
                tvBuyTime.setText("购买日期范围：" + payTime);
            }

            // 购买数量
            String ticketCount = ticket.getTicketCount();
            if (StringUtils.isEmpty(ticketCount)) {
                tvBuyCount.setVisibility(View.GONE);
            } else {
                tvBuyCount.setVisibility(View.VISIBLE);
                tvBuyCount.setText("购买数量：" + ticketCount);
            }

            // 购买总金额
            String totalAmount = ticket.getTotalAmount();
            if (StringUtils.isEmpty(totalAmount)) {
                tvBuyAmount.setVisibility(View.GONE);
            } else {
                tvBuyAmount.setVisibility(View.VISIBLE);
                tvBuyAmount.setText("购买总金额：" + totalAmount);
            }
            stvUse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    putTicketApply();
                }
            });

        }

    }

    /**
     * 立即领取
     */
    public void putTicketApply() {
        TicketApplyParams ticketApplyParams = new TicketApplyParams();
        User user =  Sputil.getDeviceData(this,SpConstant.USER_DATA);
        if (user != null) {
            ticketApplyParams.setUserId(user.getUserId());
            ticketApplyParams.setProductCode(user.getProductCode());
        }
        ticketApplyParams.setDiscountId(discountId);
        ticketApplyParams.setHoldType(20);
        mPresenter.putTicketApply(TicketDetailActivity.this, ticketApplyParams, TicketDetailActivity.this);
    }

    @Override
    public void ticketApplySuccess() {
        getTicketDetail();
    }
}
