package com.tibi.common.function.lib.module.discount;

import com.tibi.common.function.lib.util.StringUtils;

import java.util.List;

public class Discount {

    /**
     * id : 213
     * operationRecordId : 272890339924676608
     * discountId : 271140879262072832
     * ticketId : 272890339706572800
     * enableTime : 2021-04-15 15:35:09
     * ticketValidTimeType : 1
     * startTime : 2021-04-14 00:00:00
     * endTime : 2099-12-31 23:59:59
     * ticketStartTime : 2021-04-14 00:00:00
     * ticketEndTime : 2099-12-31 23:59:59
     * ticketValidCount : 0
     * ticketValidUnit : month
     * discountName : 满减1555
     * receiveCount : null
     * receiveTypeCode : 10
     * receiveTypeName : 自主获取
     * receiveUrl : http://www.baidu.com
     * discountTypeCode : full_reduce
     * discountTypeName : 满减
     * discountClazzCode : full_reduce
     * discountClazzName : 满减
     * operationId : 61
     * state : 1
     * lockState : 0
     * holdType : 20
     * holdName : 新家伙三啊
     * holdOrgId : 10226
     * holdOrgName : 开发企业123-本部
     * holdUserId : 934543
     * holdRealName : 新家伙三啊
     * holdCardNo : 110101199003072359
     * originCode : 8801010101
     * tradeName : null
     * productCode :
     * productName :
     * useOperationTime : 2021-04-19 14:49:39
     * useUserId : 934543
     * useRealName : 新家伙三啊
     * useCardNo : 110101199003072359
     * description :
     * discountDescription :
     * createTime : 2021-04-19 14:49:39
     * createUserId :
     * createUser :
     * discountManageDto : {"id":89,"discountId":"271140879262072832","discountName":"满减1555","discountTypeCode":"full_reduce","discountTypeName":"满减","discountClazzCode":"full_reduce","discountClazzName":"满减","enableTime":"2021-04-15 15:35:09","validTimeType":1,"startTime":"2021-04-14 00:00:00","endTime":"2099-12-31 23:59:59","ticketValidTimeType":1,"ticketStartTime":"2021-04-14 00:00:00","ticketEndTime":"2099-12-31 23:59:59","ticketValidCount":0,"ticketValidUnit":"month","state":3,"receiveTypeCode":"20,10","receiveTypeName":"系统发放,自主获取","receiveUrl":"http://www.baidu.com","receiveStartTime":"2021-04-15 00:00:00","receiveEndTime":"2021-04-30 23:59:59","receiveCount":10,"receiveTotalCount":100,"sendTotalCount":null,"packDiscountId":null,"discountIds":"","addDiscountIds":"","useConditionTypeCode":"marketing_ticket_study","useConditionTypeName":"购买学习券","addType":0,"discountSingleAmount":0,"discountTotalAmount":0,"saveIndex":3,"description":"","createTime":"2021-04-14 18:57:55","createUserId":"141794986442055680","createUser":"柏伟","updateTime":"2021-04-15 15:35:09","updateUserId":"141794986442055680","updateUser":"柏伟","discountRuleDetailList":[{"id":293,"discountId":"271140879262072832","conditionUnitCode":"condition_unit_type_yuan","conditionUnitName":"元","conditionAmount":1000,"discountName":null,"conditionValueUnit":"unit_amount","conditionValue":"100","conditionValueUnitCode":"condition_unit_type_yuan","conditionValueUnitName":"元","ticketClazzCode":"","ticketClazzName":"","ticketTypeCode":null,"ticketTypeName":null,"description":"","createTime":"2021-04-15 15:35:03","createUserId":"141794986442055680","createUser":"柏伟","updateTime":"2021-04-15 15:35:04","updateUserId":"141794986442055680","updateUser":"柏伟"}],"discountReceiveRule":{"id":308,"discountId":"271140879262072832","ruleType":"receive_type","productCode":"prod_antubang","productName":"安途帮","platformNames":"","platformJson":"","orgIds":"10225,10226","originCodes":"8801010100,8801010101","identityCodes":"system_org_indentity_admin,system_org_indentity_student","identityNames":"管理员,学员","dutyJson":null,"conditionType":0,"ticketTypeName":"","ticketTypeCode":"","ticketName":"","payStartTime":null,"payEndTime":null,"ticketCount":0,"totalAmount":0,"orgTypeCodes":"org_type_company","orgTypeName":"企业","description":"","createTime":"2021-04-15 15:35:03","createUserId":"141794986442055680","createUser":"柏伟","updateTime":"2021-04-15 15:35:04","updateUserId":"141794986442055680","updateUser":"柏伟","isDelete":0,"extJsonObj":null,"orgList":[{"id":298,"discountId":"271140879262072832","discountRuleId":"271452217701634048","orgId":10225,"orgName":"开发企业123","originCode":"8801010100","orgTypeCodes":null,"orgTypeName":null,"description":"","extJson":null},{"id":299,"discountId":"271140879262072832","discountRuleId":"271452217701634048","orgId":10226,"orgName":"开发企业123-本部","originCode":"8801010101","orgTypeCodes":null,"orgTypeName":null,"description":"","extJson":null}],"dutyList":null},"discountUseTypeRule":{"id":309,"discountId":"271140879262072832","ruleType":"use_type","productCode":"prod_antubang","productName":"安途帮","platformNames":"","platformJson":"","orgIds":"10225,10226","originCodes":"8801010100,8801010101","identityCodes":"system_org_indentity_admin,system_org_indentity_student","identityNames":"管理员,学员","dutyJson":null,"conditionType":0,"ticketTypeName":"","ticketTypeCode":"","ticketName":"","payStartTime":null,"payEndTime":null,"ticketCount":0,"totalAmount":0,"orgTypeCodes":"org_type_company","orgTypeName":"企业","description":"","createTime":"2021-04-15 15:35:03","createUserId":"141794986442055680","createUser":"柏伟","updateTime":"2021-04-15 15:35:04","updateUserId":"141794986442055680","updateUser":"柏伟","isDelete":0,"extJsonObj":null,"orgList":[{"id":300,"discountId":"271140879262072832","discountRuleId":"271452217701634049","orgId":10225,"orgName":"开发企业123","originCode":"8801010100","orgTypeCodes":null,"orgTypeName":null,"description":"","extJson":null},{"id":301,"discountId":"271140879262072832","discountRuleId":"271452217701634049","orgId":10226,"orgName":"开发企业123-本部","originCode":"8801010101","orgTypeCodes":null,"orgTypeName":null,"description":"","extJson":null}],"dutyList":null},"discountUseConditionRule":{"id":310,"discountId":"271140879262072832","ruleType":"use_condition","productCode":"","productName":"","platformNames":"","platformJson":"","orgIds":"","originCodes":"","identityCodes":null,"identityNames":null,"dutyJson":null,"conditionType":0,"ticketTypeName":"","ticketTypeCode":"","ticketName":"","payStartTime":null,"payEndTime":null,"ticketCount":0,"totalAmount":0,"orgTypeCodes":null,"orgTypeName":null,"description":"","createTime":"2021-04-15 15:35:03","createUserId":"141794986442055680","createUser":"柏伟","updateTime":"2021-04-15 15:35:04","updateUserId":"141794986442055680","updateUser":"柏伟","isDelete":0,"extJsonObj":null,"orgList":null,"dutyList":null},"discountManageBagList":null,"discountManageOverlayList":null,"discountRuleDetailJoin":["满10.00元减1.00元;"]}
     * orderId : null
     * orderManageDto : null
     */

    private int id;
    private String operationRecordId;
    private String discountId;
    private String ticketId;
    private String enableTime;
    private int ticketValidTimeType;
    private String startTime;
    private String endTime;
    private String ticketStartTime;
    private String ticketEndTime;
    private int ticketValidCount;
    private String ticketValidUnit;
    private String discountName;
    private Object receiveCount;
    private String receiveTypeCode;
    private String receiveTypeName;
    private String receiveUrl;
    private String discountTypeCode;
    private String discountTypeName;
    private String discountClazzCode;
    private String discountClazzName;
    private String operationId;
    private int state;
    private int lockState;
    private int holdType;
    private String holdName;
    private int holdOrgId;
    private String holdOrgName;
    private String holdUserId;
    private String holdRealName;
    private String holdCardNo;
    private String originCode;
    private Object tradeName;
    private String productCode;
    private String productName;
    private String useOperationTime;
    private String useUserId;
    private String useRealName;
    private String useCardNo;
    private String description;
    private String discountDescription;
    private String createTime;
    private String createUserId;
    private String createUser;
    private DiscountManageDtoBean discountManageDto;
    private Object orderId;
    private Object orderManageDto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperationRecordId() {
        return operationRecordId;
    }

    public void setOperationRecordId(String operationRecordId) {
        this.operationRecordId = operationRecordId;
    }

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getEnableTime() {
        return enableTime;
    }

    public void setEnableTime(String enableTime) {
        this.enableTime = enableTime;
    }

    public int getTicketValidTimeType() {
        return ticketValidTimeType;
    }

    public void setTicketValidTimeType(int ticketValidTimeType) {
        this.ticketValidTimeType = ticketValidTimeType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTicketStartTime() {
        return ticketStartTime;
    }

    public void setTicketStartTime(String ticketStartTime) {
        this.ticketStartTime = ticketStartTime;
    }

    public String getTicketEndTime() {
        return ticketEndTime;
    }

    public void setTicketEndTime(String ticketEndTime) {
        this.ticketEndTime = ticketEndTime;
    }

    public int getTicketValidCount() {
        return ticketValidCount;
    }

    public void setTicketValidCount(int ticketValidCount) {
        this.ticketValidCount = ticketValidCount;
    }

    public String getTicketValidUnit() {
        return ticketValidUnit;
    }

    public void setTicketValidUnit(String ticketValidUnit) {
        this.ticketValidUnit = ticketValidUnit;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public Object getReceiveCount() {
        return receiveCount;
    }

    public void setReceiveCount(Object receiveCount) {
        this.receiveCount = receiveCount;
    }

    public String getReceiveTypeCode() {
        return receiveTypeCode;
    }

    public void setReceiveTypeCode(String receiveTypeCode) {
        this.receiveTypeCode = receiveTypeCode;
    }

    public String getReceiveTypeName() {
        return receiveTypeName;
    }

    public void setReceiveTypeName(String receiveTypeName) {
        this.receiveTypeName = receiveTypeName;
    }

    public String getReceiveUrl() {
        return receiveUrl;
    }

    public void setReceiveUrl(String receiveUrl) {
        this.receiveUrl = receiveUrl;
    }

    public String getDiscountTypeCode() {
        return discountTypeCode;
    }

    public void setDiscountTypeCode(String discountTypeCode) {
        this.discountTypeCode = discountTypeCode;
    }

    public String getDiscountTypeName() {
        return discountTypeName;
    }

    public void setDiscountTypeName(String discountTypeName) {
        this.discountTypeName = discountTypeName;
    }

    public String getDiscountClazzCode() {
        return discountClazzCode;
    }

    public void setDiscountClazzCode(String discountClazzCode) {
        this.discountClazzCode = discountClazzCode;
    }

    public String getDiscountClazzName() {
        return discountClazzName;
    }

    public void setDiscountClazzName(String discountClazzName) {
        this.discountClazzName = discountClazzName;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getLockState() {
        return lockState;
    }

    public void setLockState(int lockState) {
        this.lockState = lockState;
    }

    public int getHoldType() {
        return holdType;
    }

    public void setHoldType(int holdType) {
        this.holdType = holdType;
    }

    public String getHoldName() {
        return holdName;
    }

    public void setHoldName(String holdName) {
        this.holdName = holdName;
    }

    public int getHoldOrgId() {
        return holdOrgId;
    }

    public void setHoldOrgId(int holdOrgId) {
        this.holdOrgId = holdOrgId;
    }

    public String getHoldOrgName() {
        return holdOrgName;
    }

    public void setHoldOrgName(String holdOrgName) {
        this.holdOrgName = holdOrgName;
    }

    public String getHoldUserId() {
        return holdUserId;
    }

    public void setHoldUserId(String holdUserId) {
        this.holdUserId = holdUserId;
    }

    public String getHoldRealName() {
        return holdRealName;
    }

    public void setHoldRealName(String holdRealName) {
        this.holdRealName = holdRealName;
    }

    public String getHoldCardNo() {
        return holdCardNo;
    }

    public void setHoldCardNo(String holdCardNo) {
        this.holdCardNo = holdCardNo;
    }

    public String getOriginCode() {
        return originCode;
    }

    public void setOriginCode(String originCode) {
        this.originCode = originCode;
    }

    public Object getTradeName() {
        return tradeName;
    }

    public void setTradeName(Object tradeName) {
        this.tradeName = tradeName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUseOperationTime() {
        return useOperationTime;
    }

    public void setUseOperationTime(String useOperationTime) {
        this.useOperationTime = useOperationTime;
    }

    public String getUseUserId() {
        return useUserId;
    }

    public void setUseUserId(String useUserId) {
        this.useUserId = useUserId;
    }

    public String getUseRealName() {
        return useRealName;
    }

    public void setUseRealName(String useRealName) {
        this.useRealName = useRealName;
    }

    public String getUseCardNo() {
        return useCardNo;
    }

    public void setUseCardNo(String useCardNo) {
        this.useCardNo = useCardNo;
    }

    public String getDescription() {
        return StringUtils.isEmpty(description) ? "-" :description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscountDescription() {
        return discountDescription;
    }

    public void setDiscountDescription(String discountDescription) {
        this.discountDescription = discountDescription;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public DiscountManageDtoBean getDiscountManageDto() {
        return discountManageDto;
    }

    public void setDiscountManageDto(DiscountManageDtoBean discountManageDto) {
        this.discountManageDto = discountManageDto;
    }

    public Object getOrderId() {
        return orderId;
    }

    public void setOrderId(Object orderId) {
        this.orderId = orderId;
    }

    public Object getOrderManageDto() {
        return orderManageDto;
    }

    public void setOrderManageDto(Object orderManageDto) {
        this.orderManageDto = orderManageDto;
    }

    public static class DiscountManageDtoBean {
        /**
         * id : 89
         * discountId : 271140879262072832
         * discountName : 满减1555
         * discountTypeCode : full_reduce
         * discountTypeName : 满减
         * discountClazzCode : full_reduce
         * discountClazzName : 满减
         * enableTime : 2021-04-15 15:35:09
         * validTimeType : 1
         * startTime : 2021-04-14 00:00:00
         * endTime : 2099-12-31 23:59:59
         * ticketValidTimeType : 1
         * ticketStartTime : 2021-04-14 00:00:00
         * ticketEndTime : 2099-12-31 23:59:59
         * ticketValidCount : 0
         * ticketValidUnit : month
         * state : 3
         * receiveTypeCode : 20,10
         * receiveTypeName : 系统发放,自主获取
         * receiveUrl : http://www.baidu.com
         * receiveStartTime : 2021-04-15 00:00:00
         * receiveEndTime : 2021-04-30 23:59:59
         * receiveCount : 10
         * receiveTotalCount : 100
         * sendTotalCount : null
         * packDiscountId : null
         * discountIds :
         * addDiscountIds :
         * useConditionTypeCode : marketing_ticket_study
         * useConditionTypeName : 购买学习券
         * addType : 0
         * discountSingleAmount : 0
         * discountTotalAmount : 0
         * saveIndex : 3
         * description :
         * createTime : 2021-04-14 18:57:55
         * createUserId : 141794986442055680
         * createUser : 柏伟
         * updateTime : 2021-04-15 15:35:09
         * updateUserId : 141794986442055680
         * updateUser : 柏伟
         * discountRuleDetailList : [{"id":293,"discountId":"271140879262072832","conditionUnitCode":"condition_unit_type_yuan","conditionUnitName":"元","conditionAmount":1000,"discountName":null,"conditionValueUnit":"unit_amount","conditionValue":"100","conditionValueUnitCode":"condition_unit_type_yuan","conditionValueUnitName":"元","ticketClazzCode":"","ticketClazzName":"","ticketTypeCode":null,"ticketTypeName":null,"description":"","createTime":"2021-04-15 15:35:03","createUserId":"141794986442055680","createUser":"柏伟","updateTime":"2021-04-15 15:35:04","updateUserId":"141794986442055680","updateUser":"柏伟"}]
         * discountReceiveRule : {"id":308,"discountId":"271140879262072832","ruleType":"receive_type","productCode":"prod_antubang","productName":"安途帮","platformNames":"","platformJson":"","orgIds":"10225,10226","originCodes":"8801010100,8801010101","identityCodes":"system_org_indentity_admin,system_org_indentity_student","identityNames":"管理员,学员","dutyJson":null,"conditionType":0,"ticketTypeName":"","ticketTypeCode":"","ticketName":"","payStartTime":null,"payEndTime":null,"ticketCount":0,"totalAmount":0,"orgTypeCodes":"org_type_company","orgTypeName":"企业","description":"","createTime":"2021-04-15 15:35:03","createUserId":"141794986442055680","createUser":"柏伟","updateTime":"2021-04-15 15:35:04","updateUserId":"141794986442055680","updateUser":"柏伟","isDelete":0,"extJsonObj":null,"orgList":[{"id":298,"discountId":"271140879262072832","discountRuleId":"271452217701634048","orgId":10225,"orgName":"开发企业123","originCode":"8801010100","orgTypeCodes":null,"orgTypeName":null,"description":"","extJson":null},{"id":299,"discountId":"271140879262072832","discountRuleId":"271452217701634048","orgId":10226,"orgName":"开发企业123-本部","originCode":"8801010101","orgTypeCodes":null,"orgTypeName":null,"description":"","extJson":null}],"dutyList":null}
         * discountUseTypeRule : {"id":309,"discountId":"271140879262072832","ruleType":"use_type","productCode":"prod_antubang","productName":"安途帮","platformNames":"","platformJson":"","orgIds":"10225,10226","originCodes":"8801010100,8801010101","identityCodes":"system_org_indentity_admin,system_org_indentity_student","identityNames":"管理员,学员","dutyJson":null,"conditionType":0,"ticketTypeName":"","ticketTypeCode":"","ticketName":"","payStartTime":null,"payEndTime":null,"ticketCount":0,"totalAmount":0,"orgTypeCodes":"org_type_company","orgTypeName":"企业","description":"","createTime":"2021-04-15 15:35:03","createUserId":"141794986442055680","createUser":"柏伟","updateTime":"2021-04-15 15:35:04","updateUserId":"141794986442055680","updateUser":"柏伟","isDelete":0,"extJsonObj":null,"orgList":[{"id":300,"discountId":"271140879262072832","discountRuleId":"271452217701634049","orgId":10225,"orgName":"开发企业123","originCode":"8801010100","orgTypeCodes":null,"orgTypeName":null,"description":"","extJson":null},{"id":301,"discountId":"271140879262072832","discountRuleId":"271452217701634049","orgId":10226,"orgName":"开发企业123-本部","originCode":"8801010101","orgTypeCodes":null,"orgTypeName":null,"description":"","extJson":null}],"dutyList":null}
         * discountUseConditionRule : {"id":310,"discountId":"271140879262072832","ruleType":"use_condition","productCode":"","productName":"","platformNames":"","platformJson":"","orgIds":"","originCodes":"","identityCodes":null,"identityNames":null,"dutyJson":null,"conditionType":0,"ticketTypeName":"","ticketTypeCode":"","ticketName":"","payStartTime":null,"payEndTime":null,"ticketCount":0,"totalAmount":0,"orgTypeCodes":null,"orgTypeName":null,"description":"","createTime":"2021-04-15 15:35:03","createUserId":"141794986442055680","createUser":"柏伟","updateTime":"2021-04-15 15:35:04","updateUserId":"141794986442055680","updateUser":"柏伟","isDelete":0,"extJsonObj":null,"orgList":null,"dutyList":null}
         * discountManageBagList : null
         * discountManageOverlayList : null
         * discountRuleDetailJoin : ["满10.00元减1.00元;"]
         */

        private int id;
        private String discountId;
        private String discountName;
        private String discountTypeCode;
        private String discountTypeName;
        private String discountClazzCode;
        private String discountClazzName;
        private String enableTime;
        private int validTimeType;
        private String startTime;
        private String endTime;
        private int ticketValidTimeType;
        private String ticketStartTime;
        private String ticketEndTime;
        private int ticketValidCount;
        private String ticketValidUnit;
        private int state;
        private String receiveTypeCode;
        private String receiveTypeName;
        private String receiveUrl;
        private String receiveStartTime;
        private String receiveEndTime;
        private int receiveCount;
        private int receiveTotalCount;
        private Object sendTotalCount;
        private Object packDiscountId;
        private String discountIds;
        private String addDiscountIds;
        private String useConditionTypeCode;
        private String useConditionTypeName;
        private int addType;
        private int discountSingleAmount;
        private int discountTotalAmount;
        private int saveIndex;
        private String description;
        private String createTime;
        private String createUserId;
        private String createUser;
        private String updateTime;
        private String updateUserId;
        private String updateUser;
        private DiscountReceiveRuleBean discountReceiveRule;
        private DiscountUseTypeRuleBean discountUseTypeRule;
        private DiscountUseConditionRuleBean discountUseConditionRule;
        private Object discountManageBagList;
        private Object discountManageOverlayList;
        private List<DiscountRuleDetailListBean> discountRuleDetailList;
        private List<String> discountRuleDetailJoin;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDiscountId() {
            return discountId;
        }

        public void setDiscountId(String discountId) {
            this.discountId = discountId;
        }

        public String getDiscountName() {
            return discountName;
        }

        public void setDiscountName(String discountName) {
            this.discountName = discountName;
        }

        public String getDiscountTypeCode() {
            return discountTypeCode;
        }

        public void setDiscountTypeCode(String discountTypeCode) {
            this.discountTypeCode = discountTypeCode;
        }

        public String getDiscountTypeName() {
            return discountTypeName;
        }

        public void setDiscountTypeName(String discountTypeName) {
            this.discountTypeName = discountTypeName;
        }

        public String getDiscountClazzCode() {
            return discountClazzCode;
        }

        public void setDiscountClazzCode(String discountClazzCode) {
            this.discountClazzCode = discountClazzCode;
        }

        public String getDiscountClazzName() {
            return discountClazzName;
        }

        public void setDiscountClazzName(String discountClazzName) {
            this.discountClazzName = discountClazzName;
        }

        public String getEnableTime() {
            return enableTime;
        }

        public void setEnableTime(String enableTime) {
            this.enableTime = enableTime;
        }

        public int getValidTimeType() {
            return validTimeType;
        }

        public void setValidTimeType(int validTimeType) {
            this.validTimeType = validTimeType;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public int getTicketValidTimeType() {
            return ticketValidTimeType;
        }

        public void setTicketValidTimeType(int ticketValidTimeType) {
            this.ticketValidTimeType = ticketValidTimeType;
        }

        public String getTicketStartTime() {
            return ticketStartTime;
        }

        public void setTicketStartTime(String ticketStartTime) {
            this.ticketStartTime = ticketStartTime;
        }

        public String getTicketEndTime() {
            return ticketEndTime;
        }

        public void setTicketEndTime(String ticketEndTime) {
            this.ticketEndTime = ticketEndTime;
        }

        public int getTicketValidCount() {
            return ticketValidCount;
        }

        public void setTicketValidCount(int ticketValidCount) {
            this.ticketValidCount = ticketValidCount;
        }

        public String getTicketValidUnit() {
            return ticketValidUnit;
        }

        public void setTicketValidUnit(String ticketValidUnit) {
            this.ticketValidUnit = ticketValidUnit;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getReceiveTypeCode() {
            return receiveTypeCode;
        }

        public void setReceiveTypeCode(String receiveTypeCode) {
            this.receiveTypeCode = receiveTypeCode;
        }

        public String getReceiveTypeName() {
            return receiveTypeName;
        }

        public void setReceiveTypeName(String receiveTypeName) {
            this.receiveTypeName = receiveTypeName;
        }

        public String getReceiveUrl() {
            return receiveUrl;
        }

        public void setReceiveUrl(String receiveUrl) {
            this.receiveUrl = receiveUrl;
        }

        public String getReceiveStartTime() {
            return receiveStartTime;
        }

        public void setReceiveStartTime(String receiveStartTime) {
            this.receiveStartTime = receiveStartTime;
        }

        public String getReceiveEndTime() {
            return receiveEndTime;
        }

        public void setReceiveEndTime(String receiveEndTime) {
            this.receiveEndTime = receiveEndTime;
        }

        public int getReceiveCount() {
            return receiveCount;
        }

        public void setReceiveCount(int receiveCount) {
            this.receiveCount = receiveCount;
        }

        public int getReceiveTotalCount() {
            return receiveTotalCount;
        }

        public void setReceiveTotalCount(int receiveTotalCount) {
            this.receiveTotalCount = receiveTotalCount;
        }

        public Object getSendTotalCount() {
            return sendTotalCount;
        }

        public void setSendTotalCount(Object sendTotalCount) {
            this.sendTotalCount = sendTotalCount;
        }

        public Object getPackDiscountId() {
            return packDiscountId;
        }

        public void setPackDiscountId(Object packDiscountId) {
            this.packDiscountId = packDiscountId;
        }

        public String getDiscountIds() {
            return discountIds;
        }

        public void setDiscountIds(String discountIds) {
            this.discountIds = discountIds;
        }

        public String getAddDiscountIds() {
            return addDiscountIds;
        }

        public void setAddDiscountIds(String addDiscountIds) {
            this.addDiscountIds = addDiscountIds;
        }

        public String getUseConditionTypeCode() {
            return useConditionTypeCode;
        }

        public void setUseConditionTypeCode(String useConditionTypeCode) {
            this.useConditionTypeCode = useConditionTypeCode;
        }

        public String getUseConditionTypeName() {
            return useConditionTypeName;
        }

        public void setUseConditionTypeName(String useConditionTypeName) {
            this.useConditionTypeName = useConditionTypeName;
        }

        public int getAddType() {
            return addType;
        }

        public void setAddType(int addType) {
            this.addType = addType;
        }

        public int getDiscountSingleAmount() {
            return discountSingleAmount;
        }

        public void setDiscountSingleAmount(int discountSingleAmount) {
            this.discountSingleAmount = discountSingleAmount;
        }

        public int getDiscountTotalAmount() {
            return discountTotalAmount;
        }

        public void setDiscountTotalAmount(int discountTotalAmount) {
            this.discountTotalAmount = discountTotalAmount;
        }

        public int getSaveIndex() {
            return saveIndex;
        }

        public void setSaveIndex(int saveIndex) {
            this.saveIndex = saveIndex;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(String createUserId) {
            this.createUserId = createUserId;
        }

        public String getCreateUser() {
            return createUser;
        }

        public void setCreateUser(String createUser) {
            this.createUser = createUser;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getUpdateUserId() {
            return updateUserId;
        }

        public void setUpdateUserId(String updateUserId) {
            this.updateUserId = updateUserId;
        }

        public String getUpdateUser() {
            return updateUser;
        }

        public void setUpdateUser(String updateUser) {
            this.updateUser = updateUser;
        }

        public DiscountReceiveRuleBean getDiscountReceiveRule() {
            return discountReceiveRule;
        }

        public void setDiscountReceiveRule(DiscountReceiveRuleBean discountReceiveRule) {
            this.discountReceiveRule = discountReceiveRule;
        }

        public DiscountUseTypeRuleBean getDiscountUseTypeRule() {
            return discountUseTypeRule;
        }

        public void setDiscountUseTypeRule(DiscountUseTypeRuleBean discountUseTypeRule) {
            this.discountUseTypeRule = discountUseTypeRule;
        }

        public DiscountUseConditionRuleBean getDiscountUseConditionRule() {
            return discountUseConditionRule;
        }

        public void setDiscountUseConditionRule(DiscountUseConditionRuleBean discountUseConditionRule) {
            this.discountUseConditionRule = discountUseConditionRule;
        }

        public Object getDiscountManageBagList() {
            return discountManageBagList;
        }

        public void setDiscountManageBagList(Object discountManageBagList) {
            this.discountManageBagList = discountManageBagList;
        }

        public Object getDiscountManageOverlayList() {
            return discountManageOverlayList;
        }

        public void setDiscountManageOverlayList(Object discountManageOverlayList) {
            this.discountManageOverlayList = discountManageOverlayList;
        }

        public List<DiscountRuleDetailListBean> getDiscountRuleDetailList() {
            return discountRuleDetailList;
        }

        public void setDiscountRuleDetailList(List<DiscountRuleDetailListBean> discountRuleDetailList) {
            this.discountRuleDetailList = discountRuleDetailList;
        }

        public List<String> getDiscountRuleDetailJoin() {
            return discountRuleDetailJoin;
        }

        public void setDiscountRuleDetailJoin(List<String> discountRuleDetailJoin) {
            this.discountRuleDetailJoin = discountRuleDetailJoin;
        }

        public static class DiscountReceiveRuleBean {
            /**
             * id : 308
             * discountId : 271140879262072832
             * ruleType : receive_type
             * productCode : prod_antubang
             * productName : 安途帮
             * platformNames :
             * platformJson :
             * orgIds : 10225,10226
             * originCodes : 8801010100,8801010101
             * identityCodes : system_org_indentity_admin,system_org_indentity_student
             * identityNames : 管理员,学员
             * dutyJson : null
             * conditionType : 0
             * ticketTypeName :
             * ticketTypeCode :
             * ticketName :
             * payStartTime : null
             * payEndTime : null
             * ticketCount : 0
             * totalAmount : 0
             * orgTypeCodes : org_type_company
             * orgTypeName : 企业
             * description :
             * createTime : 2021-04-15 15:35:03
             * createUserId : 141794986442055680
             * createUser : 柏伟
             * updateTime : 2021-04-15 15:35:04
             * updateUserId : 141794986442055680
             * updateUser : 柏伟
             * isDelete : 0
             * extJsonObj : null
             * orgList : [{"id":298,"discountId":"271140879262072832","discountRuleId":"271452217701634048","orgId":10225,"orgName":"开发企业123","originCode":"8801010100","orgTypeCodes":null,"orgTypeName":null,"description":"","extJson":null},{"id":299,"discountId":"271140879262072832","discountRuleId":"271452217701634048","orgId":10226,"orgName":"开发企业123-本部","originCode":"8801010101","orgTypeCodes":null,"orgTypeName":null,"description":"","extJson":null}]
             * dutyList : null
             */

            private int id;
            private String discountId;
            private String ruleType;
            private String productCode;
            private String productName;
            private String platformNames;
            private String platformJson;
            private String orgIds;
            private String originCodes;
            private String identityCodes;
            private String identityNames;
            private Object dutyJson;
            private int conditionType;
            private String ticketTypeName;
            private String ticketTypeCode;
            private String ticketName;
            private Object payStartTime;
            private Object payEndTime;
            private int ticketCount;
            private int totalAmount;
            private String orgTypeCodes;
            private String orgTypeName;
            private String description;
            private String createTime;
            private String createUserId;
            private String createUser;
            private String updateTime;
            private String updateUserId;
            private String updateUser;
            private int isDelete;
            private Object extJsonObj;
            private Object dutyList;
            private List<OrgListBean> orgList;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDiscountId() {
                return discountId;
            }

            public void setDiscountId(String discountId) {
                this.discountId = discountId;
            }

            public String getRuleType() {
                return ruleType;
            }

            public void setRuleType(String ruleType) {
                this.ruleType = ruleType;
            }

            public String getProductCode() {
                return productCode;
            }

            public void setProductCode(String productCode) {
                this.productCode = productCode;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getPlatformNames() {
                return platformNames;
            }

            public void setPlatformNames(String platformNames) {
                this.platformNames = platformNames;
            }

            public String getPlatformJson() {
                return platformJson;
            }

            public void setPlatformJson(String platformJson) {
                this.platformJson = platformJson;
            }

            public String getOrgIds() {
                return orgIds;
            }

            public void setOrgIds(String orgIds) {
                this.orgIds = orgIds;
            }

            public String getOriginCodes() {
                return originCodes;
            }

            public void setOriginCodes(String originCodes) {
                this.originCodes = originCodes;
            }

            public String getIdentityCodes() {
                return identityCodes;
            }

            public void setIdentityCodes(String identityCodes) {
                this.identityCodes = identityCodes;
            }

            public String getIdentityNames() {
                return identityNames;
            }

            public void setIdentityNames(String identityNames) {
                this.identityNames = identityNames;
            }

            public Object getDutyJson() {
                return dutyJson;
            }

            public void setDutyJson(Object dutyJson) {
                this.dutyJson = dutyJson;
            }

            public int getConditionType() {
                return conditionType;
            }

            public void setConditionType(int conditionType) {
                this.conditionType = conditionType;
            }

            public String getTicketTypeName() {
                return ticketTypeName;
            }

            public void setTicketTypeName(String ticketTypeName) {
                this.ticketTypeName = ticketTypeName;
            }

            public String getTicketTypeCode() {
                return ticketTypeCode;
            }

            public void setTicketTypeCode(String ticketTypeCode) {
                this.ticketTypeCode = ticketTypeCode;
            }

            public String getTicketName() {
                return ticketName;
            }

            public void setTicketName(String ticketName) {
                this.ticketName = ticketName;
            }

            public Object getPayStartTime() {
                return payStartTime;
            }

            public void setPayStartTime(Object payStartTime) {
                this.payStartTime = payStartTime;
            }

            public Object getPayEndTime() {
                return payEndTime;
            }

            public void setPayEndTime(Object payEndTime) {
                this.payEndTime = payEndTime;
            }

            public int getTicketCount() {
                return ticketCount;
            }

            public void setTicketCount(int ticketCount) {
                this.ticketCount = ticketCount;
            }

            public int getTotalAmount() {
                return totalAmount;
            }

            public void setTotalAmount(int totalAmount) {
                this.totalAmount = totalAmount;
            }

            public String getOrgTypeCodes() {
                return orgTypeCodes;
            }

            public void setOrgTypeCodes(String orgTypeCodes) {
                this.orgTypeCodes = orgTypeCodes;
            }

            public String getOrgTypeName() {
                return orgTypeName;
            }

            public void setOrgTypeName(String orgTypeName) {
                this.orgTypeName = orgTypeName;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getCreateUserId() {
                return createUserId;
            }

            public void setCreateUserId(String createUserId) {
                this.createUserId = createUserId;
            }

            public String getCreateUser() {
                return createUser;
            }

            public void setCreateUser(String createUser) {
                this.createUser = createUser;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getUpdateUserId() {
                return updateUserId;
            }

            public void setUpdateUserId(String updateUserId) {
                this.updateUserId = updateUserId;
            }

            public String getUpdateUser() {
                return updateUser;
            }

            public void setUpdateUser(String updateUser) {
                this.updateUser = updateUser;
            }

            public int getIsDelete() {
                return isDelete;
            }

            public void setIsDelete(int isDelete) {
                this.isDelete = isDelete;
            }

            public Object getExtJsonObj() {
                return extJsonObj;
            }

            public void setExtJsonObj(Object extJsonObj) {
                this.extJsonObj = extJsonObj;
            }

            public Object getDutyList() {
                return dutyList;
            }

            public void setDutyList(Object dutyList) {
                this.dutyList = dutyList;
            }

            public List<OrgListBean> getOrgList() {
                return orgList;
            }

            public void setOrgList(List<OrgListBean> orgList) {
                this.orgList = orgList;
            }

            public static class OrgListBean {
                /**
                 * id : 298
                 * discountId : 271140879262072832
                 * discountRuleId : 271452217701634048
                 * orgId : 10225
                 * orgName : 开发企业123
                 * originCode : 8801010100
                 * orgTypeCodes : null
                 * orgTypeName : null
                 * description :
                 * extJson : null
                 */

                private int id;
                private String discountId;
                private String discountRuleId;
                private int orgId;
                private String orgName;
                private String originCode;
                private Object orgTypeCodes;
                private Object orgTypeName;
                private String description;
                private Object extJson;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getDiscountId() {
                    return discountId;
                }

                public void setDiscountId(String discountId) {
                    this.discountId = discountId;
                }

                public String getDiscountRuleId() {
                    return discountRuleId;
                }

                public void setDiscountRuleId(String discountRuleId) {
                    this.discountRuleId = discountRuleId;
                }

                public int getOrgId() {
                    return orgId;
                }

                public void setOrgId(int orgId) {
                    this.orgId = orgId;
                }

                public String getOrgName() {
                    return orgName;
                }

                public void setOrgName(String orgName) {
                    this.orgName = orgName;
                }

                public String getOriginCode() {
                    return originCode;
                }

                public void setOriginCode(String originCode) {
                    this.originCode = originCode;
                }

                public Object getOrgTypeCodes() {
                    return orgTypeCodes;
                }

                public void setOrgTypeCodes(Object orgTypeCodes) {
                    this.orgTypeCodes = orgTypeCodes;
                }

                public Object getOrgTypeName() {
                    return orgTypeName;
                }

                public void setOrgTypeName(Object orgTypeName) {
                    this.orgTypeName = orgTypeName;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public Object getExtJson() {
                    return extJson;
                }

                public void setExtJson(Object extJson) {
                    this.extJson = extJson;
                }
            }
        }

        public static class DiscountUseTypeRuleBean {
            /**
             * id : 309
             * discountId : 271140879262072832
             * ruleType : use_type
             * productCode : prod_antubang
             * productName : 安途帮
             * platformNames :
             * platformJson :
             * orgIds : 10225,10226
             * originCodes : 8801010100,8801010101
             * identityCodes : system_org_indentity_admin,system_org_indentity_student
             * identityNames : 管理员,学员
             * dutyJson : null
             * conditionType : 0
             * ticketTypeName :
             * ticketTypeCode :
             * ticketName :
             * payStartTime : null
             * payEndTime : null
             * ticketCount : 0
             * totalAmount : 0
             * orgTypeCodes : org_type_company
             * orgTypeName : 企业
             * description :
             * createTime : 2021-04-15 15:35:03
             * createUserId : 141794986442055680
             * createUser : 柏伟
             * updateTime : 2021-04-15 15:35:04
             * updateUserId : 141794986442055680
             * updateUser : 柏伟
             * isDelete : 0
             * extJsonObj : null
             * orgList : [{"id":300,"discountId":"271140879262072832","discountRuleId":"271452217701634049","orgId":10225,"orgName":"开发企业123","originCode":"8801010100","orgTypeCodes":null,"orgTypeName":null,"description":"","extJson":null},{"id":301,"discountId":"271140879262072832","discountRuleId":"271452217701634049","orgId":10226,"orgName":"开发企业123-本部","originCode":"8801010101","orgTypeCodes":null,"orgTypeName":null,"description":"","extJson":null}]
             * dutyList : null
             */

            private int id;
            private String discountId;
            private String ruleType;
            private String productCode;
            private String productName;
            private String platformNames;
            private String platformJson;
            private String orgIds;
            private String originCodes;
            private String identityCodes;
            private String identityNames;
            private Object dutyJson;
            private int conditionType;
            private String ticketTypeName;
            private String ticketTypeCode;
            private String ticketName;
            private Object payStartTime;
            private Object payEndTime;
            private int ticketCount;
            private int totalAmount;
            private String orgTypeCodes;
            private String orgTypeName;
            private String description;
            private String createTime;
            private String createUserId;
            private String createUser;
            private String updateTime;
            private String updateUserId;
            private String updateUser;
            private int isDelete;
            private Object extJsonObj;
            private Object dutyList;
            private List<OrgListBeanX> orgList;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDiscountId() {
                return discountId;
            }

            public void setDiscountId(String discountId) {
                this.discountId = discountId;
            }

            public String getRuleType() {
                return ruleType;
            }

            public void setRuleType(String ruleType) {
                this.ruleType = ruleType;
            }

            public String getProductCode() {
                return productCode;
            }

            public void setProductCode(String productCode) {
                this.productCode = productCode;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getPlatformNames() {
                return platformNames;
            }

            public void setPlatformNames(String platformNames) {
                this.platformNames = platformNames;
            }

            public String getPlatformJson() {
                return platformJson;
            }

            public void setPlatformJson(String platformJson) {
                this.platformJson = platformJson;
            }

            public String getOrgIds() {
                return orgIds;
            }

            public void setOrgIds(String orgIds) {
                this.orgIds = orgIds;
            }

            public String getOriginCodes() {
                return originCodes;
            }

            public void setOriginCodes(String originCodes) {
                this.originCodes = originCodes;
            }

            public String getIdentityCodes() {
                return identityCodes;
            }

            public void setIdentityCodes(String identityCodes) {
                this.identityCodes = identityCodes;
            }

            public String getIdentityNames() {
                return identityNames;
            }

            public void setIdentityNames(String identityNames) {
                this.identityNames = identityNames;
            }

            public Object getDutyJson() {
                return dutyJson;
            }

            public void setDutyJson(Object dutyJson) {
                this.dutyJson = dutyJson;
            }

            public int getConditionType() {
                return conditionType;
            }

            public void setConditionType(int conditionType) {
                this.conditionType = conditionType;
            }

            public String getTicketTypeName() {
                return ticketTypeName;
            }

            public void setTicketTypeName(String ticketTypeName) {
                this.ticketTypeName = ticketTypeName;
            }

            public String getTicketTypeCode() {
                return ticketTypeCode;
            }

            public void setTicketTypeCode(String ticketTypeCode) {
                this.ticketTypeCode = ticketTypeCode;
            }

            public String getTicketName() {
                return ticketName;
            }

            public void setTicketName(String ticketName) {
                this.ticketName = ticketName;
            }

            public Object getPayStartTime() {
                return payStartTime;
            }

            public void setPayStartTime(Object payStartTime) {
                this.payStartTime = payStartTime;
            }

            public Object getPayEndTime() {
                return payEndTime;
            }

            public void setPayEndTime(Object payEndTime) {
                this.payEndTime = payEndTime;
            }

            public int getTicketCount() {
                return ticketCount;
            }

            public void setTicketCount(int ticketCount) {
                this.ticketCount = ticketCount;
            }

            public int getTotalAmount() {
                return totalAmount;
            }

            public void setTotalAmount(int totalAmount) {
                this.totalAmount = totalAmount;
            }

            public String getOrgTypeCodes() {
                return orgTypeCodes;
            }

            public void setOrgTypeCodes(String orgTypeCodes) {
                this.orgTypeCodes = orgTypeCodes;
            }

            public String getOrgTypeName() {
                return orgTypeName;
            }

            public void setOrgTypeName(String orgTypeName) {
                this.orgTypeName = orgTypeName;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getCreateUserId() {
                return createUserId;
            }

            public void setCreateUserId(String createUserId) {
                this.createUserId = createUserId;
            }

            public String getCreateUser() {
                return createUser;
            }

            public void setCreateUser(String createUser) {
                this.createUser = createUser;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getUpdateUserId() {
                return updateUserId;
            }

            public void setUpdateUserId(String updateUserId) {
                this.updateUserId = updateUserId;
            }

            public String getUpdateUser() {
                return updateUser;
            }

            public void setUpdateUser(String updateUser) {
                this.updateUser = updateUser;
            }

            public int getIsDelete() {
                return isDelete;
            }

            public void setIsDelete(int isDelete) {
                this.isDelete = isDelete;
            }

            public Object getExtJsonObj() {
                return extJsonObj;
            }

            public void setExtJsonObj(Object extJsonObj) {
                this.extJsonObj = extJsonObj;
            }

            public Object getDutyList() {
                return dutyList;
            }

            public void setDutyList(Object dutyList) {
                this.dutyList = dutyList;
            }

            public List<OrgListBeanX> getOrgList() {
                return orgList;
            }

            public void setOrgList(List<OrgListBeanX> orgList) {
                this.orgList = orgList;
            }

            public static class OrgListBeanX {
                /**
                 * id : 300
                 * discountId : 271140879262072832
                 * discountRuleId : 271452217701634049
                 * orgId : 10225
                 * orgName : 开发企业123
                 * originCode : 8801010100
                 * orgTypeCodes : null
                 * orgTypeName : null
                 * description :
                 * extJson : null
                 */

                private int id;
                private String discountId;
                private String discountRuleId;
                private int orgId;
                private String orgName;
                private String originCode;
                private Object orgTypeCodes;
                private Object orgTypeName;
                private String description;
                private Object extJson;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getDiscountId() {
                    return discountId;
                }

                public void setDiscountId(String discountId) {
                    this.discountId = discountId;
                }

                public String getDiscountRuleId() {
                    return discountRuleId;
                }

                public void setDiscountRuleId(String discountRuleId) {
                    this.discountRuleId = discountRuleId;
                }

                public int getOrgId() {
                    return orgId;
                }

                public void setOrgId(int orgId) {
                    this.orgId = orgId;
                }

                public String getOrgName() {
                    return orgName;
                }

                public void setOrgName(String orgName) {
                    this.orgName = orgName;
                }

                public String getOriginCode() {
                    return originCode;
                }

                public void setOriginCode(String originCode) {
                    this.originCode = originCode;
                }

                public Object getOrgTypeCodes() {
                    return orgTypeCodes;
                }

                public void setOrgTypeCodes(Object orgTypeCodes) {
                    this.orgTypeCodes = orgTypeCodes;
                }

                public Object getOrgTypeName() {
                    return orgTypeName;
                }

                public void setOrgTypeName(Object orgTypeName) {
                    this.orgTypeName = orgTypeName;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public Object getExtJson() {
                    return extJson;
                }

                public void setExtJson(Object extJson) {
                    this.extJson = extJson;
                }
            }
        }

        public static class DiscountUseConditionRuleBean {
            /**
             * id : 310
             * discountId : 271140879262072832
             * ruleType : use_condition
             * productCode :
             * productName :
             * platformNames :
             * platformJson :
             * orgIds :
             * originCodes :
             * identityCodes : null
             * identityNames : null
             * dutyJson : null
             * conditionType : 0
             * ticketTypeName :
             * ticketTypeCode :
             * ticketName :
             * payStartTime : null
             * payEndTime : null
             * ticketCount : 0
             * totalAmount : 0
             * orgTypeCodes : null
             * orgTypeName : null
             * description :
             * createTime : 2021-04-15 15:35:03
             * createUserId : 141794986442055680
             * createUser : 柏伟
             * updateTime : 2021-04-15 15:35:04
             * updateUserId : 141794986442055680
             * updateUser : 柏伟
             * isDelete : 0
             * extJsonObj : null
             * orgList : null
             * dutyList : null
             */

            private int id;
            private String discountId;
            private String ruleType;
            private String productCode;
            private String productName;
            private String platformNames;
            private String platformJson;
            private String orgIds;
            private String originCodes;
            private Object identityCodes;
            private Object identityNames;
            private Object dutyJson;
            private int conditionType;
            private String ticketTypeName;
            private String ticketTypeCode;
            private String ticketName;
            private String payStartTime;
            private String payEndTime;
            private int ticketCount;
            private int totalAmount;
            private Object orgTypeCodes;
            private Object orgTypeName;
            private String description;
            private String createTime;
            private String createUserId;
            private String createUser;
            private String updateTime;
            private String updateUserId;
            private String updateUser;
            private int isDelete;
            private Object extJsonObj;
            private Object orgList;
            private Object dutyList;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDiscountId() {
                return discountId;
            }

            public void setDiscountId(String discountId) {
                this.discountId = discountId;
            }

            public String getRuleType() {
                return ruleType;
            }

            public void setRuleType(String ruleType) {
                this.ruleType = ruleType;
            }

            public String getProductCode() {
                return productCode;
            }

            public void setProductCode(String productCode) {
                this.productCode = productCode;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getPlatformNames() {
                return platformNames;
            }

            public void setPlatformNames(String platformNames) {
                this.platformNames = platformNames;
            }

            public String getPlatformJson() {
                return platformJson;
            }

            public void setPlatformJson(String platformJson) {
                this.platformJson = platformJson;
            }

            public String getOrgIds() {
                return orgIds;
            }

            public void setOrgIds(String orgIds) {
                this.orgIds = orgIds;
            }

            public String getOriginCodes() {
                return originCodes;
            }

            public void setOriginCodes(String originCodes) {
                this.originCodes = originCodes;
            }

            public Object getIdentityCodes() {
                return identityCodes;
            }

            public void setIdentityCodes(Object identityCodes) {
                this.identityCodes = identityCodes;
            }

            public Object getIdentityNames() {
                return identityNames;
            }

            public void setIdentityNames(Object identityNames) {
                this.identityNames = identityNames;
            }

            public Object getDutyJson() {
                return dutyJson;
            }

            public void setDutyJson(Object dutyJson) {
                this.dutyJson = dutyJson;
            }

            public int getConditionType() {
                return conditionType;
            }

            public void setConditionType(int conditionType) {
                this.conditionType = conditionType;
            }

            public String getTicketTypeName() {
                return ticketTypeName;
            }

            public void setTicketTypeName(String ticketTypeName) {
                this.ticketTypeName = ticketTypeName;
            }

            public String getTicketTypeCode() {
                return ticketTypeCode;
            }

            public void setTicketTypeCode(String ticketTypeCode) {
                this.ticketTypeCode = ticketTypeCode;
            }

            public String getTicketName() {
                return ticketName;
            }

            public void setTicketName(String ticketName) {
                this.ticketName = ticketName;
            }

            public String getPayStartTime() {
                return payStartTime;
            }

            public void setPayStartTime(String payStartTime) {
                this.payStartTime = payStartTime;
            }

            public String getPayEndTime() {
                return payEndTime;
            }

            public void setPayEndTime(String payEndTime) {
                this.payEndTime = payEndTime;
            }

            public int getTicketCount() {
                return ticketCount;
            }

            public void setTicketCount(int ticketCount) {
                this.ticketCount = ticketCount;
            }

            public int getTotalAmount() {
                return totalAmount;
            }

            public void setTotalAmount(int totalAmount) {
                this.totalAmount = totalAmount;
            }

            public Object getOrgTypeCodes() {
                return orgTypeCodes;
            }

            public void setOrgTypeCodes(Object orgTypeCodes) {
                this.orgTypeCodes = orgTypeCodes;
            }

            public Object getOrgTypeName() {
                return orgTypeName;
            }

            public void setOrgTypeName(Object orgTypeName) {
                this.orgTypeName = orgTypeName;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getCreateUserId() {
                return createUserId;
            }

            public void setCreateUserId(String createUserId) {
                this.createUserId = createUserId;
            }

            public String getCreateUser() {
                return createUser;
            }

            public void setCreateUser(String createUser) {
                this.createUser = createUser;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getUpdateUserId() {
                return updateUserId;
            }

            public void setUpdateUserId(String updateUserId) {
                this.updateUserId = updateUserId;
            }

            public String getUpdateUser() {
                return updateUser;
            }

            public void setUpdateUser(String updateUser) {
                this.updateUser = updateUser;
            }

            public int getIsDelete() {
                return isDelete;
            }

            public void setIsDelete(int isDelete) {
                this.isDelete = isDelete;
            }

            public Object getExtJsonObj() {
                return extJsonObj;
            }

            public void setExtJsonObj(Object extJsonObj) {
                this.extJsonObj = extJsonObj;
            }

            public Object getOrgList() {
                return orgList;
            }

            public void setOrgList(Object orgList) {
                this.orgList = orgList;
            }

            public Object getDutyList() {
                return dutyList;
            }

            public void setDutyList(Object dutyList) {
                this.dutyList = dutyList;
            }
        }

        public static class DiscountRuleDetailListBean {
            /**
             * id : 293
             * discountId : 271140879262072832
             * conditionUnitCode : condition_unit_type_yuan
             * conditionUnitName : 元
             * conditionAmount : 1000
             * discountName : null
             * conditionValueUnit : unit_amount
             * conditionValue : 100
             * conditionValueUnitCode : condition_unit_type_yuan
             * conditionValueUnitName : 元
             * ticketClazzCode :
             * ticketClazzName :
             * ticketTypeCode : null
             * ticketTypeName : null
             * description :
             * createTime : 2021-04-15 15:35:03
             * createUserId : 141794986442055680
             * createUser : 柏伟
             * updateTime : 2021-04-15 15:35:04
             * updateUserId : 141794986442055680
             * updateUser : 柏伟
             */

            private int id;
            private String discountId;
            private String conditionUnitCode;
            private String conditionUnitName;
            private int conditionAmount;
            private Object discountName;
            private String conditionValueUnit;
            private String conditionValue;
            private String conditionValueUnitCode;
            private String conditionValueUnitName;
            private String ticketClazzCode;
            private String ticketClazzName;
            private Object ticketTypeCode;
            private Object ticketTypeName;
            private String description;
            private String createTime;
            private String createUserId;
            private String createUser;
            private String updateTime;
            private String updateUserId;
            private String updateUser;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDiscountId() {
                return discountId;
            }

            public void setDiscountId(String discountId) {
                this.discountId = discountId;
            }

            public String getConditionUnitCode() {
                return conditionUnitCode;
            }

            public void setConditionUnitCode(String conditionUnitCode) {
                this.conditionUnitCode = conditionUnitCode;
            }

            public String getConditionUnitName() {
                return conditionUnitName;
            }

            public void setConditionUnitName(String conditionUnitName) {
                this.conditionUnitName = conditionUnitName;
            }

            public int getConditionAmount() {
                return conditionAmount;
            }

            public void setConditionAmount(int conditionAmount) {
                this.conditionAmount = conditionAmount;
            }

            public Object getDiscountName() {
                return discountName;
            }

            public void setDiscountName(Object discountName) {
                this.discountName = discountName;
            }

            public String getConditionValueUnit() {
                return conditionValueUnit;
            }

            public void setConditionValueUnit(String conditionValueUnit) {
                this.conditionValueUnit = conditionValueUnit;
            }

            public String getConditionValue() {
                return conditionValue;
            }

            public void setConditionValue(String conditionValue) {
                this.conditionValue = conditionValue;
            }

            public String getConditionValueUnitCode() {
                return conditionValueUnitCode;
            }

            public void setConditionValueUnitCode(String conditionValueUnitCode) {
                this.conditionValueUnitCode = conditionValueUnitCode;
            }

            public String getConditionValueUnitName() {
                return conditionValueUnitName;
            }

            public void setConditionValueUnitName(String conditionValueUnitName) {
                this.conditionValueUnitName = conditionValueUnitName;
            }

            public String getTicketClazzCode() {
                return ticketClazzCode;
            }

            public void setTicketClazzCode(String ticketClazzCode) {
                this.ticketClazzCode = ticketClazzCode;
            }

            public String getTicketClazzName() {
                return ticketClazzName;
            }

            public void setTicketClazzName(String ticketClazzName) {
                this.ticketClazzName = ticketClazzName;
            }

            public Object getTicketTypeCode() {
                return ticketTypeCode;
            }

            public void setTicketTypeCode(Object ticketTypeCode) {
                this.ticketTypeCode = ticketTypeCode;
            }

            public Object getTicketTypeName() {
                return ticketTypeName;
            }

            public void setTicketTypeName(Object ticketTypeName) {
                this.ticketTypeName = ticketTypeName;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getCreateUserId() {
                return createUserId;
            }

            public void setCreateUserId(String createUserId) {
                this.createUserId = createUserId;
            }

            public String getCreateUser() {
                return createUser;
            }

            public void setCreateUser(String createUser) {
                this.createUser = createUser;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getUpdateUserId() {
                return updateUserId;
            }

            public void setUpdateUserId(String updateUserId) {
                this.updateUserId = updateUserId;
            }

            public String getUpdateUser() {
                return updateUser;
            }

            public void setUpdateUser(String updateUser) {
                this.updateUser = updateUser;
            }
        }
    }

    /**
     * 使用时间
     *
     * @return
     */
    public String getTicketUseTime() {
        String timeStr = "";
        if (!StringUtils.isEmpty(ticketStartTime)) {
            timeStr = "限" + StringUtils.parse(ticketStartTime, "yyyy.MM.dd");
            if (!StringUtils.isEmpty(ticketEndTime)) {
                timeStr = timeStr + "至" + StringUtils.parse(ticketEndTime, "yyyy.MM.dd") + "使用";
            }
        }
        return timeStr;
    }

    /**
     * 状态（0：无效，1：未使用,2:已使用，3：过期，4：不可用）
     *
     * @return
     */
    public String getStateStr() {
        if (state == 0) {
            return "无效";
        } else if (state == 1) {
            return "未使用";
        } else if (state == 2) {
            return "已使用";
        } else if (state == 3) {
            return "过期";
        } else if (state == 4) {
            return "不可用";
        }
        return "-";
    }

    /**
     * 优惠规则
     */
    public String getDiscountRuleDetailJoin() {
        String str = "-";
        if (discountManageDto != null) {
            str = discountManageDto.getDiscountRuleDetailJoin().toString();
        }
        return str;
    }

    /**
     * 使用场景
     * @return
     */
    public String getUseConditionTypeName() {
        String str = "-";
        if (discountManageDto != null) {
            str = discountManageDto.getUseConditionTypeName();
        }
        return str;
    }

    /**
     * 消费条件
     *
     * @return
     */
    public String getConditionTypeName() {
        if (discountManageDto != null && discountManageDto.getDiscountReceiveRule() != null) {
            if (discountManageDto.getDiscountReceiveRule().getConditionType() == 1) {
                return "此优惠有以下消费条件";
            } else {
                return "无消费条件限制";
            }
        }
        return "-";
    }

    /**
     * 商品类型
     */
    public String getTicketTypeName() {
        String ticketTypeName = "";
        if (discountManageDto != null && discountManageDto.discountUseConditionRule != null) {
            ticketTypeName = discountManageDto.discountUseConditionRule.getTicketTypeName();
        }
        return ticketTypeName;
    }

    /**
     * 商品名称
     */
    public String getTicketName() {
        String ticketName = "";
        if (discountManageDto != null && discountManageDto.discountUseConditionRule != null) {
            ticketName = discountManageDto.discountUseConditionRule.getTicketName();
        }
        return ticketName;
    }


    /**
     * 购买日期范围
     */
    public String getPayTime() {
        String payTime = "";
        if (discountManageDto != null && discountManageDto.discountUseConditionRule != null) {
            String payStartTime = discountManageDto.discountUseConditionRule.payStartTime;
            if (!StringUtils.isEmpty(payStartTime)) {
                payTime = StringUtils.parse(payStartTime,"yyyy.MM.dd");
            }
            String payEndTime = discountManageDto.discountUseConditionRule.payEndTime;
            if (!StringUtils.isEmpty(payEndTime)) {
                payTime = payTime + "至" + StringUtils.parse(payEndTime,"yyyy.MM.dd");
            }
        }
        return payTime;
    }


    /**
     * 购买数量
     */
    public String getTicketCount() {
        int ticketCount = 0;
        if (discountManageDto != null && discountManageDto.discountUseConditionRule != null) {
            ticketCount = discountManageDto.discountUseConditionRule.getTicketCount();
        }
        return ticketCount == 0 ? "" : String.valueOf(ticketCount);
    }


    /**
     * 购买总金额
     */
    public String getTotalAmount() {
        int totalAmount = 0;
        if (discountManageDto != null && discountManageDto.discountUseConditionRule != null) {
            totalAmount = discountManageDto.discountUseConditionRule.getTotalAmount();
        }
        return totalAmount == 0 ? "" : String.valueOf(totalAmount/100.00);
    }
}
