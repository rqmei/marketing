package com.tibi.common.function.lib.module.ticket.detail;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

import lib.android.timingbar.com.util.StringUtils;

public class TicketDetail implements Serializable {
    public TicketDetail(String str) {
        if (!StringUtils.isEmpty(str)) {
            try {
                JSONObject jsonObject = new JSONObject(str);
                if (jsonObject.optBoolean("success")) {
                    JSONObject data = jsonObject.optJSONObject("data");
                    if (data != null) {
                        this.discountName = data.optString("discountName");
                        this.discountTypeName = data.optString("discountTypeName");
                        this.ticketStartTime = data.optString("ticketStartTime");
                        this.ticketEndTime = data.optString("ticketEndTime");
                        this.ticketValidTimeType = data.optInt("ticketValidTimeType");
                        this.ticketValidCount = data.optInt("ticketValidCount");
                        this.ticketValidUnit = data.optString("ticketValidUnit");
                        this.startTime = data.optString("startTime");
                        this.endTime = data.optString("endTime");
                        this.discountTypeCode = data.optString("discountTypeCode");
                        this.state = data.optInt("state");
                        this.useConditionTypeName = data.optString("useConditionTypeName");
                        JSONArray jsonArray = data.optJSONArray("discountRuleDetailJoin");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            if (i == 0) {
                                this.discountRuleDetailJoin = jsonArray.getString(i);
                            } else {
                                this.discountRuleDetailJoin = this.discountRuleDetailJoin + "," + jsonArray.getString(i);
                            }
                        }
                        this.description = data.optString("description");
                        JSONObject jsonObject1 = data.optJSONObject("discountUseConditionRule");
                        if (jsonObject1 != null) {
                            this.discountUseConditionRule = new DiscountUseConditionRule(jsonObject1);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
    private String discountTypeCode;
    private String discountName;
    private String discountTypeName;
    private String ticketStartTime; // 优惠券有效开始时间
    private String ticketEndTime; // 优惠券有效结束时间
    private int state; // 状态（0：无效，1:草稿，2：停用，3:启用，10：过期）
    private int ticketValidTimeType; // 券有效期类型（0:不限制，1：获取后失效，1:周期有效）
    private String useConditionTypeName; // 使用场景名称（来自参数(购买学习券）
    private int ticketValidCount; // 优惠券有效条件个数（比如，多少天）
    private String ticketValidUnit; // 优惠券有效条件单位（年，月，天，时，year，month，day，hours）
    private String description;
    private DiscountUseConditionRule discountUseConditionRule;
    private String startTime; // 有效开始时间
    private String endTime; // 有效结束时间
    private String discountRuleDetailJoin; // 优惠详情优惠拼装

    public String getDiscountName() {
        return discountName;
    }

    public String getDiscountTypeName() {
        return discountTypeName;
    }

    public int getState() {
        return state;
    }


    public String getUseConditionTypeName() {
        return useConditionTypeName;
    }


    public String getDescription() {
        return StringUtils.isEmpty(description) ? "-" : description;
    }


    public String getDiscountRuleDetailJoin() {
        return discountRuleDetailJoin.toString();
    }


    public static class DiscountUseConditionRule implements Serializable {
        public DiscountUseConditionRule(JSONObject jsonObject) {
            this.conditionType = jsonObject.optInt("conditionType");
            this.isDelete = jsonObject.optInt("isDelete");
            this.payEndTime = jsonObject.optString("payEndTime");
            this.payStartTime = jsonObject.optString("payStartTime");
            this.ticketName = jsonObject.optString("ticketName");
            this.ticketTypeCode = jsonObject.optString("ticketTypeCode");
            this.description = jsonObject.optString("description");
            this.ticketTypeName = jsonObject.optString("ticketTypeName");
            this.ticketCount = jsonObject.optInt("ticketCount");
            this.totalAmount = jsonObject.optInt("totalAmount");
        }

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
     * 使用时间
     *
     * @return
     */
    public String getTicketUseTime(int isGain) {
        String timeStr = "不限";
        if (isGain == 1 || ticketValidTimeType == 2 || !discountTypeCode.equals("discount_ticket")) {
            if (!StringUtils.isEmpty(ticketStartTime)) {
                timeStr = "限" + StringUtils.parse(ticketStartTime, "yyyy.MM.dd");
                if (!StringUtils.isEmpty(ticketEndTime)) {
                    timeStr = timeStr + "至" + StringUtils.parse(ticketEndTime, "yyyy.MM.dd") + "使用";
                }
            } else if(!StringUtils.isEmpty(startTime)){
                timeStr = "限" + StringUtils.parse(startTime, "yyyy.MM.dd");
                if (!StringUtils.isEmpty(endTime)) {
                    timeStr = timeStr + "至" + StringUtils.parse(endTime, "yyyy.MM.dd") + "使用";
                }
            }
        } else {
            if (ticketValidTimeType == 0) {
                timeStr = "不限";
            } else if (ticketValidTimeType == 1) {
                timeStr = "领取后"+ticketValidCount + formatterTicketValidUnit()+"失效";
            }
        }
        return timeStr;
    }

    /**
     *
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
            return "停用";
        } else if (state == 3) {
            return "启用";
        } else if (state == 10) {
            return "过期";
        }
        return "-";
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
        return totalAmount == 0 ? "" : String.valueOf(totalAmount / 100.00)+"元";
    }
}
