package com.tibi.common.function.lib.module.ticket;

import com.tibi.common.function.lib.util.StringUtils;

import java.io.Serializable;
import java.util.List;

public class Ticket implements Serializable {

    /**
     * id : 115
     * discountId : 268201116357464064
     * discountName : yxl满减
     * discountTypeCode : full_reduce
     * discountTypeName : 满减
     * discountClazzCode : full_reduce
     * discountClazzName : 满减
     * enableTime : null
     * validTimeType : null
     * startTime : 2021-04-06 00:00:00
     * endTime : 2021-04-30 23:59:59
     * ticketValidTimeType : 1
     * ticketStartTime : 2021-04-06 00:00:00
     * ticketEndTime : 2021-04-30 23:59:59
     * ticketValidCount : 0
     * ticketValidUnit : day
     * state : 2
     * receiveTypeCode : null
     * receiveTypeName : null
     * receiveUrl : http://www.baidu.com
     * receiveStartTime : null
     * receiveEndTime : null
     * receiveCount : null
     * receiveTotalCount : null
     * sendTotalCount : null
     * packDiscountId : null
     * discountIds : null
     * addDiscountIds : null
     * useConditionTypeCode : null
     * useConditionTypeName : null
     * addType : null
     * discountSingleAmount : null
     * discountTotalAmount : null
     * saveIndex : null
     * description :
     * createTime : 2021-04-06 16:36:06
     * createUserId : 268197515017412608
     * createUser : 杨秀兰
     * updateTime : null
     * updateUserId : null
     * updateUser : null
     * discountRuleDetailList : null
     * discountReceiveRule : null
     * discountUseTypeRule : null
     * discountUseConditionRule : null
     * discountManageBagList : null
     * discountManageOverlayList : null
     * discountRuleDetailJoin : null
     * isGain : null
     */

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
    private String packDiscountId; // 礼包的Id
    private String discountIds; // 礼包优惠id集合（礼包类型用到）
    private String addDiscountIds; // 叠加优惠id集合（叠加类型用到）
    private String useConditionTypeCode; // 获取方式（10：自主领取,20：系统发放）
    private String useConditionTypeName;
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
    private List<DiscountRuleDetailDto> discountRuleDetailList;
    private DiscountReceiveUseRuleDto discountReceiveRule;
    private Object discountUseTypeRule;
    private Object discountUseConditionRule;
    private Object discountManageBagList;
    private Object discountManageOverlayList;
    private String discountRuleDetailJoin; // 优惠详情优惠拼装
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

    public String getPackDiscountId() {
        return packDiscountId;
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

    public List<DiscountRuleDetailDto> getDiscountRuleDetailList() {
        return discountRuleDetailList;
    }

    public DiscountReceiveUseRuleDto getDiscountReceiveRule() {
        return discountReceiveRule;
    }

    public Object getDiscountUseTypeRule() {
        return discountUseTypeRule;
    }

    public Object getDiscountUseConditionRule() {
        return discountUseConditionRule;
    }

    public Object getDiscountManageBagList() {
        return discountManageBagList;
    }

    public Object getDiscountManageOverlayList() {
        return discountManageOverlayList;
    }

    public String getDiscountRuleDetailJoin() {
        return discountRuleDetailJoin;
    }

    public int getIsGain() {
        return isGain;
    }

    public String getTicketTime() {
        String timeStr = "-";
        if (!StringUtils.isEmpty(ticketStartTime)) {
            timeStr = "限" + ticketStartTime;
            if (StringUtils.isEmpty(ticketEndTime)) {
                timeStr = timeStr + "至" + ticketEndTime + "使用";
            }
        }
        return timeStr;
    }

    public static class DiscountRuleDetailDto {
        private int conditionAmount; // 条件金额（单位：分）

        private String conditionUnitCode; // 条件金额单位编码

        private String conditionUnitName;// 条件金额单位名称（元，美元）

        private String conditionValue;// 优惠值（如果是礼包存储json字符串{code，name}）

        private String conditionValueUnit; // 优惠值单位(折扣 unit_discount，金额:unit_amount，券unit_ticket，packs选择的是优惠券礼包)

        private String conditionValueUnitCode;// 优惠金额单位编码

        private String conditionValueUnitName;// 优惠金额单位名称（元，美元）

        private String createTime; // 创建时间

        private String createUser; // 创建人

        private String createUserId; // 创建人id（user表的user_id）

        private String description;// 描述

        private String discountId;//  优惠id

        private String discountName;// 优惠名称

        private int id; //ID
        private String ticketClazzCode; // 券分类编码（参数）

        private String ticketClazzName; //券分类型（学习券，优惠券）

        private String ticketTypeCode; // 券类型（学习券类型，或者优惠券）code

        private String ticketTypeName; // 券类型（学习券类型，或者优惠券）

        private String updateTime;//  更新时间

        private String updateUser;// 更新人

        private String updateUserId;// 更新人id（user表的user_id）
    }

    public static class DiscountReceiveUseRuleDto {
        private int conditionType; // 是否使用消费条件（0：不使用,1：使用）

        private String createTime; // 创建时间

        private String createUser; // 创建人

        private String createUserId; //  创建人id（user表的user_id）

        private String description; // 描述

        private String discountId;//  优惠id

        private String dutyJson; // 岗位json（{duty_coe,duty_name}）

        private int id; // ID
        private String identityCodes;// 身份编码

        private String identityNames; // 身份（多个，逗号分隔

        private int isDelete;//   是否删除（0：否,1：是）

        private String orgIds;//  适用组织id

        List<DiscountReceiveUseRuleOrgDto> orgList; // 使用优惠用户范围:组织集合
        private String orgTypeCodes; // 适用组织类型编码

        private String orgTypeName;//适用组织类型名称

        private String originCodes; //适用组织编码(老系统)

        private String payEndTime;//  购买结束时间

        private String payStartTime; //购买日期开始时间

        private String platformJson;// 客户端（json字符串）

        private String platformNames;//客户端名称-方便前端展示（安卓、ios、PC学员端、管理端）

        private String productCode;// 所属系统/产品/项目(编码)

        private String productName;// 所属系统/产品/项目

        private String ruleType; //  规则类型（获取：receive_type,使用优惠用户范围：use_type，使用优惠条件:use_condition）

        private int ticketCount; // 购买数量

        private String ticketName; // 券名称

        private String ticketTypeCode;//   券类型编码（参数）

        private String ticketTypeName; // 券类型名称

        private int totalAmount;// 购买金额（分）

        private String updateTime; // 更新时间

        private String updateUser; // 更新人

        private String updateUserId; //更新人id（user表的user_id）

        public static class DiscountReceiveUseRuleOrgDto {
            private String description; // 描述

            private String discountId; //   优惠id

            private String discountRuleId;// 优惠规则id

            private String extJson;
            private int id;
            private String orgId; // 适用组织id

            private String orgName;// 组织名称

            private String orgTypeCodes;//  适用组织类型编码

            private String orgTypeName;// 适用组织类型名称

            private String originCode;// 适用组织编码(老系统)
        }
    }
}
