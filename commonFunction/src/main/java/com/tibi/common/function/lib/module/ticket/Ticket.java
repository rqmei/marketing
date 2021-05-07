package com.tibi.common.function.lib.module.ticket;


import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import lib.android.tb.common.util.StringUtils;


public class Ticket implements Serializable {
    private int id;
    private String discountId;
    private String discountName;
    private String discountTypeCode;
    private String discountTypeName;
    private String discountClazzCode;
    private String discountClazzName;
    private String enableTime; // 启用时间
    private int validTimeType; // 有效期类型（0：不限制，1:限制）
    private String startTime; // 有效开始时间
    private String endTime; // 有效结束时间
    private int ticketValidTimeType; // 券有效期类型（0:不限制，1：获取后失效，1:周期有效）
    private String ticketStartTime; // 优惠券有效开始时间
    private String ticketEndTime; // 优惠券有效结束时间
    private int ticketValidCount; // 优惠券有效条件个数（比如，多少天）
    private String ticketValidUnit; // 优惠券有效条件单位（年，月，天，时，year，month，day，hours）
    private int state; // 状态（0：无效，1:草稿，2：停用，3:启用，10：过期）
    private String receiveTypeCode; // 获取方式（10：自主领取,20：系统发放）
    private String receiveTypeName;
    private String receiveUrl; // 获取地址
    private String receiveStartTime; // 获取有效开始时间
    private String receiveEndTime; // 获取有效结束时间
    private int receiveCount; // 每人可获取数量
    private int receiveTotalCount; // 限制总数量
    private String discountIds; // 礼包优惠id集合（礼包类型用到）
    private String addDiscountIds; // 叠加优惠id集合（叠加类型用到）
    private String useConditionTypeCode; // 获取方式（10：自主领取,20：系统发放）
    private String useConditionTypeName; // 使用场景名称（来自参数(购买学习券）
    private int addType; // 优惠叠加（0：不允许叠加,10：按照默认规则叠加，20：自主选择叠加）
    private int discountSingleAmount; // 单次优惠阈值（单位分）
    private int discountTotalAmount; // 总优惠阈值（单位分，0表示不限制）
    private int saveIndex; // 保存步骤
    private int sendTotalCount; //总共发放了多少张
    private String description;
    private String createTime;
    private String createUserId;
    private String createUser;
    private String updateTime; // 更新时间
    private String updateUserId; // 更新人id（user表的user_id）
    private String updateUser;
    private DiscountUseConditionRule discountUseConditionRule;
    private String[] discountRuleDetailJoin; // 优惠详情优惠拼装
    private int isGain; // 是否已经领取（0否 1 是）

    public int getId() {
        return id;
    }

    public String getDiscountId() {
        return discountId;
    }

    public String getDiscountName() {
        return discountName;
    }

    public String getDiscountTypeCode() {
        return discountTypeCode;
    }

    public String getDiscountTypeName() {
        return discountTypeName;
    }

    public String getDiscountClazzCode() {
        return discountClazzCode;
    }

    public String getDiscountClazzName() {
        return discountClazzName;
    }

    public String getEnableTime() {
        return enableTime;
    }

    public int getValidTimeType() {
        return validTimeType;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public int getTicketValidTimeType() {
        return ticketValidTimeType;
    }

    public String getTicketStartTime() {
        return ticketStartTime;
    }

    public String getTicketEndTime() {
        return ticketEndTime;
    }

    public int getTicketValidCount() {
        return ticketValidCount;
    }

    public String getTicketValidUnit() {
        return ticketValidUnit;
    }

    public int getState() {
        return state;
    }

    /**
     * 状态（0：无效，1:草稿，2：停用，3:启用，10：过期）
     *
     * @return
     */
    public String getStateStr() {
        if (state == 0) {
            return "无效";
        } else if (state == 1) {
            return "草稿";
        } else if (state == 2) {
            return "已停用";
        } else if (state == 3) {
            return "未使用";
        } else if (state == 10) {
            return "已过期";
        }
        return "-";
    }

    public String getReceiveTypeCode() {
        return receiveTypeCode;
    }

    public String getReceiveTypeName() {
        return receiveTypeName;
    }

    public String getReceiveUrl() {
        return receiveUrl;
    }

    public String getReceiveStartTime() {
        return receiveStartTime;
    }

    public String getReceiveEndTime() {
        return receiveEndTime;
    }

    public int getReceiveCount() {
        return receiveCount;
    }

    public int getReceiveTotalCount() {
        return receiveTotalCount;
    }


    public String getDiscountIds() {
        return discountIds;
    }

    public String getAddDiscountIds() {
        return addDiscountIds;
    }

    public String getUseConditionTypeCode() {
        return useConditionTypeCode;
    }

    public String getUseConditionTypeName() {
        return useConditionTypeName;
    }

    public int getAddType() {
        return addType;
    }

    public int getDiscountSingleAmount() {
        return discountSingleAmount;
    }

    public int getDiscountTotalAmount() {
        return discountTotalAmount;
    }

    public int getSaveIndex() {
        return saveIndex;
    }

    public int getSendTotalCount() {
        return sendTotalCount;
    }

    public String getDescription() {
        return description;
    }


    public String getCreateTime() {
        return createTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public String getUpdateUser() {
        return updateUser;
    }


    public DiscountUseConditionRule getDiscountUseConditionRule() {
        return discountUseConditionRule;
    }


    public String getDiscountRuleDetailJoin() {
        String str = "";
        for (int i = 0; i < discountRuleDetailJoin.length; i++) {
            if (i == 0) {
                str = discountRuleDetailJoin[i];
            } else {
                str = str + discountRuleDetailJoin[i];
            }
        }
        return str;
    }

    public int getIsGain() {
        return isGain;
    }

    public void setIsGain(int isGain) {
        this.isGain = isGain;
    }

    /**
     * 卷使用时间
     *
     * @return
     */
    public String getTicketUseTime() {
        String timeStr = "不限";
        if (isGain == 1 || ticketValidTimeType == 2 || !discountTypeCode.equals("discount_ticket")) {
            if (!StringUtils.isEmpty(ticketStartTime)) {
                timeStr = "限" + StringUtils.parse(ticketStartTime, "yyyy.MM.dd");
                if (!StringUtils.isEmpty(ticketEndTime)) {
                    timeStr = timeStr + "至" + StringUtils.parse(ticketEndTime, "yyyy.MM.dd") + "使用";
                }
            } else if (!StringUtils.isEmpty(startTime)) {
                timeStr = "限" + StringUtils.parse(startTime, "yyyy.MM.dd");
                if (!StringUtils.isEmpty(endTime)) {
                    timeStr = timeStr + "至" + StringUtils.parse(endTime, "yyyy.MM.dd") + "使用";
                }
            }
        } else {
            if (ticketValidTimeType == 0) {
                timeStr = "不限";
            } else if (ticketValidTimeType == 1) {
                timeStr = "领取后" + ticketValidCount + formatterTicketValidUnit() + "失效";
            }
        }
        return timeStr;
    }

    /**
     * @return year，month，day，hours
     */
    private String formatterTicketValidUnit() {
        if (ticketValidUnit.equals("year")) {
            return "年";
        } else if (ticketValidUnit.equals("month")) {
            return "个月";
        } else if (ticketValidUnit.equals("day")) {
            return "天";
        } else if (ticketValidUnit.equals("hours")) {
            return "小时";
        }
        return "";
    }

    public static class DiscountUseConditionRule implements Serializable {
        private int conditionType; // 是否使用消费条件（0：不使用,1：使用）
        private String description;// 描述
        private int isDelete;// 是否删除（0：否,1：是）
        private String payEndTime;// 购买结束时间
        private String payStartTime;// 购买日期开始时间
        private int ticketCount;//购买数量
        private String ticketName;//券名称
        private String ticketTypeCode;// 券类型编码（参数）
        private String ticketTypeName;// 券类型名称
        private int totalAmount;//购买金额（分）

        public int getConditionType() {
            return conditionType;
        }

        public String getDescription() {
            return description;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public String getPayEndTime() {
            return payEndTime;
        }

        public String getPayStartTime() {
            return payStartTime;
        }

        public int getTicketCount() {
            return ticketCount;
        }

        public String getTicketName() {
            return ticketName;
        }

        public String getTicketTypeCode() {
            return ticketTypeCode;
        }

        public String getTicketTypeName() {
            return ticketTypeName;
        }

        public int getTotalAmount() {
            return totalAmount;
        }

    }

    /**
     * 消费条件
     *
     * @return
     */
    public String getConditionTypeName() {
        if (discountUseConditionRule != null && discountUseConditionRule.getConditionType() == 1) {
            return "此优惠有以下消费条件";
        }
        return "无消费条件限制";
    }

    /**
     * 商品类型
     */
    public String getTicketTypeName() {
        String ticketTypeName = "";
        if (discountUseConditionRule != null) {
            ticketTypeName = discountUseConditionRule.getTicketTypeName();
        }
        return ticketTypeName;
    }

    /**
     * 商品名称
     */
    public String getTicketName() {
        String ticketName = "";
        if (discountUseConditionRule != null) {
            ticketName = discountUseConditionRule.getTicketName();
        }
        return ticketName;
    }


    /**
     * 购买日期范围
     */
    public String getPayTime() {
        String payTime = "";
        if (discountUseConditionRule != null) {
            String payStartTime = discountUseConditionRule.getPayStartTime();
            if (!StringUtils.isEmpty(payStartTime)) {
                payTime = StringUtils.parse(payStartTime, "yyyy.MM.dd");
            }
            String payEndTime = discountUseConditionRule.getPayEndTime();
            if (!StringUtils.isEmpty(payEndTime)) {
                payTime = payTime + "至" + StringUtils.parse(payEndTime, "yyyy.MM.dd");
            }
        }
        return payTime;
    }


    /**
     * 购买数量
     */
    public String getTicketCount() {
        int ticketCount = 0;
        if (discountUseConditionRule != null) {
            ticketCount = discountUseConditionRule.getTicketCount();
        }
        return ticketCount == 0 ? "" : String.valueOf(ticketCount);
    }


    /**
     * 购买总金额
     */
    public String getTotalAmount() {
        int totalAmount = 0;
        if (discountUseConditionRule != null) {
            totalAmount = discountUseConditionRule.getTotalAmount();
        }
        return totalAmount == 0 ? "" : String.valueOf(totalAmount / 100.00);
    }
}
