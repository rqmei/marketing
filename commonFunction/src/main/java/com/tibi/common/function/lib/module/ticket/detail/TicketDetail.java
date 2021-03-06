package com.tibi.common.function.lib.module.ticket.detail;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

import lib.android.tb.common.util.StringUtils;


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
                                this.discountRuleDetailJoin = this.discountRuleDetailJoin + jsonArray.getString(i);
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
    private String ticketStartTime; // ???????????????????????????
    private String ticketEndTime; // ???????????????????????????
    private int state; // ?????????0????????????1:?????????2????????????3:?????????10????????????
    private int ticketValidTimeType; // ?????????????????????0:????????????1?????????????????????1:???????????????
    private String useConditionTypeName; // ?????????????????????????????????(??????????????????
    private int ticketValidCount; // ???????????????????????????????????????????????????
    private String ticketValidUnit; // ??????????????????????????????????????????????????????year???month???day???hours???
    private String description;
    private DiscountUseConditionRule discountUseConditionRule;
    private String startTime; // ??????????????????
    private String endTime; // ??????????????????
    private String discountRuleDetailJoin; // ????????????????????????

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

        private int conditionType; // ???????????????????????????0????????????,1????????????
        private String description;// ??????
        private int isDelete;// ???????????????0??????,1?????????
        private String payEndTime;// ??????????????????
        private String payStartTime;// ????????????????????????
        private int ticketCount;//????????????
        private String ticketName;//?????????
        private String ticketTypeCode;// ???????????????????????????
        private String ticketTypeName;// ???????????????
        private int totalAmount;//?????????????????????

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
     * ????????????
     *
     * @return
     */
    public String getTicketUseTime(int isGain) {
        String timeStr = "??????";
        if (isGain == 1 || ticketValidTimeType == 2 || !discountTypeCode.equals("discount_ticket")) {
            if (!StringUtils.isEmpty(ticketStartTime)) {
                timeStr = "???" + StringUtils.parse(ticketStartTime, "yyyy.MM.dd");
                if (!StringUtils.isEmpty(ticketEndTime)) {
                    timeStr = timeStr + "???" + StringUtils.parse(ticketEndTime, "yyyy.MM.dd") + "??????";
                }
            } else if(!StringUtils.isEmpty(startTime)){
                timeStr = "???" + StringUtils.parse(startTime, "yyyy.MM.dd");
                if (!StringUtils.isEmpty(endTime)) {
                    timeStr = timeStr + "???" + StringUtils.parse(endTime, "yyyy.MM.dd") + "??????";
                }
            }
        } else {
            if (ticketValidTimeType == 0) {
                timeStr = "??????";
            } else if (ticketValidTimeType == 1) {
                timeStr = "?????????"+ticketValidCount + formatterTicketValidUnit()+"??????";
            }
        }
        return timeStr;
    }

    /**
     *
     * @return year???month???day???hours
     */
    private String formatterTicketValidUnit() {
        if (ticketValidUnit.equals("year")) {
            return "???";
        } else if (ticketValidUnit.equals("month")) {
            return "??????";
        } else if (ticketValidUnit.equals("day")) {
            return "???";
        } else if (ticketValidUnit.equals("hours")) {
            return "??????";
        }
        return "";
    }
    /**
     * ?????????0????????????1:?????????2????????????3:?????????10????????????
     *
     * @return
     */
    public String getStateStr() {
        if (state == 0) {
            return "??????";
        } else if (state == 1) {
            return "??????";
        } else if (state == 2) {
            return "??????";
        } else if (state == 3) {
            return "??????";
        } else if (state == 10) {
            return "??????";
        }
        return "-";
    }


    /**
     * ????????????
     *
     * @return
     */
    public String getConditionTypeName() {
        if (discountUseConditionRule != null && discountUseConditionRule.getConditionType() == 1) {
            return "??????????????????????????????";
        }
        return "?????????????????????";
    }

    /**
     * ????????????
     */
    public String getTicketTypeName() {
        String ticketTypeName = "";
        if (discountUseConditionRule != null) {
            ticketTypeName = discountUseConditionRule.getTicketTypeName();
        }
        return ticketTypeName;
    }

    /**
     * ????????????
     */
    public String getTicketName() {
        String ticketName = "";
        if (discountUseConditionRule != null) {
            ticketName = discountUseConditionRule.getTicketName();
        }
        return ticketName;
    }


    /**
     * ??????????????????
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
                payTime = payTime + "???" + StringUtils.parse(payEndTime, "yyyy.MM.dd");
            }
        }
        return payTime;
    }


    /**
     * ????????????
     */
    public String getTicketCount() {
        int ticketCount = 0;
        if (discountUseConditionRule != null) {
            ticketCount = discountUseConditionRule.getTicketCount();
        }
        return ticketCount == 0 ? "" : String.valueOf(ticketCount);
    }


    /**
     * ???????????????
     */
    public String getTotalAmount() {
        int totalAmount = 0;
        if (discountUseConditionRule != null) {
            totalAmount = discountUseConditionRule.getTotalAmount();
        }
        return totalAmount == 0 ? "" : String.valueOf(totalAmount / 100.00)+"???";
    }
}
