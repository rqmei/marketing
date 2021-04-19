package com.tibi.common.function.lib.base;

import java.io.Serializable;

public class User implements Serializable {
    private String userId;
    private String productCode ;

    public User(String userId, String productCode) {
        this.userId = userId;
        this.productCode = productCode;
    }

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
}
