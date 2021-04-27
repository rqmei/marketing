package com.tibi.common.function.lib.module.discount.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tibi.common.function.lib.R;
import com.tibi.common.function.lib.R2;

import lib.android.tb.common.base.activity.BaseActivity;
import lib.android.tb.common.base.status.StateUtils;
import com.tibi.common.function.lib.module.discount.Discount;
import com.tibi.common.function.lib.view.dialog.DialogManager;

import androidx.core.content.ContextCompat;
import butterknife.BindView;
import lib.android.tb.common.util.StringUtils;
import lib.android.tb.common.view.ShapeTextView;

/**
 * 领卷中心-详情
 */
public class DiscountDetailActivity extends BaseActivity<DiscountDetailPresenter> implements IDiscountDetailView, View.OnClickListener {
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
    DialogManager dialogManager = new DialogManager(this, getSupportFragmentManager());
    // 0：我的优惠 1：历史优惠
    int type = 0;

    @Override
    public int getLayoutResId() {
        return R.layout.ticket_detail;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        // 单独修改状态栏颜色值
        StateUtils.transparencyBar(this);
        // 设置状态栏字体颜色，true:代表黑色，false代表白色
        StateUtils.setLightStatusBar(this, false);
        stvUse.setText("立即使用");
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        discountId = getIntent().getStringExtra("discountId");
        type = getIntent().getIntExtra("type", 0);
        getTicketDetail();
    }

    @Override
    public DiscountDetailPresenter obtainPresenter() {
        return new DiscountDetailPresenter();
    }

    @Override
    public void registerListener() {
        ivNavigationLeft.setOnClickListener(this);
    }

    private void getTicketDetail() {
        mPresenter.getTicketDiscountDetail(this, discountId, this);
    }

    @Override
    public void getDiscountDetailResult(Discount discount) {
        if (discount != null) {
            tvTicketTypeName.setText(discount.getDiscountName());
            tvTicketState.setText(discount.getStateStr());
            tvUseTime.setText(discount.getTicketUseTime());
            tvDiscount.setText("优惠规则：" + discount.getDiscountRuleDetailJoin());
            tvScene.setText("使用场景：" + discount.getUseConditionTypeName());
            tvExplain.setText("说明：" + discount.getDescription());

            tvConsume.setText("消费条件：" + discount.getConditionTypeName());

            // 商品类型
            String ticketTypeName = discount.getTicketTypeName();
            if (StringUtils.isEmpty(ticketTypeName)) {
                tvCommodityType.setVisibility(View.GONE);
            } else {
                tvCommodityType.setVisibility(View.VISIBLE);
                tvCommodityType.setText("商品类型：" + ticketTypeName);
            }

            // 商品名称
            String ticketName = discount.getTicketName();
            if (StringUtils.isEmpty(ticketName)) {
                tvCommodityName.setVisibility(View.GONE);
            } else {
                tvCommodityName.setVisibility(View.VISIBLE);
                tvCommodityName.setText("商品名称：" + ticketName);
            }

            // 购买日期范围
            String payTime = discount.getPayTime();
            if (StringUtils.isEmpty(payTime)) {
                tvBuyTime.setVisibility(View.GONE);
            } else {
                tvBuyTime.setVisibility(View.VISIBLE);
                tvBuyTime.setText("购买日期范围：" + payTime);
            }

            // 购买数量
            String ticketCount = discount.getTicketCount();
            if (StringUtils.isEmpty(ticketCount)) {
                tvBuyCount.setVisibility(View.GONE);
            } else {
                tvBuyCount.setVisibility(View.VISIBLE);
                tvBuyCount.setText("购买数量：" + ticketCount);
            }

            // 购买总金额
            String totalAmount = discount.getTotalAmount();
            if (StringUtils.isEmpty(totalAmount)) {
                tvBuyAmount.setVisibility(View.GONE);
            } else {
                tvBuyAmount.setVisibility(View.VISIBLE);
                tvBuyAmount.setText("购买总金额：" + totalAmount);
            }
            if (discount.getState() == 1 && type == 0) {
                stvUse.setOnClickListener(this);
                stvUse.setDefaultColor(ContextCompat.getColor(this, R.color.c1));
            } else {
                stvUse.setDefaultColor(ContextCompat.getColor(this, R.color.G3));
            }

        }

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.iv_navigation_left) {
            finish();

        } else if (i == R.id.stv_use) {
            if (dialogManager != null) {
                dialogManager.showOneBtnDialog("当前优惠券暂时无法使用", "确定");
            }

        }
    }
}
