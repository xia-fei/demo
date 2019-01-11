package com.nkz.test.ro;

import org.wing.mocker.annotation.MockValue;

public class ProductRO  {
    @MockValue({"精细洗车","普通洗车"})
    private String productName;
    @MockValue({"2500"})
    private Integer productPrice;

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
