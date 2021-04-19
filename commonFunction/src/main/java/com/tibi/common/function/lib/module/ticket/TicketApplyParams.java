package com.tibi.common.function.lib.module.ticket;

/**
 * 立即领取的入参
 */
public class TicketApplyParams {
    private String userId; // 当前用户user_id
    private String productCode; // 产品Code
    private int holdType; // 持有方类型（10：组织，20：学员）
    private String discountId; // 优惠规则Id

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getHoldType() {
        return holdType;
    }

    public void setHoldType(int holdType) {
        this.holdType = holdType;
    }

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

}
