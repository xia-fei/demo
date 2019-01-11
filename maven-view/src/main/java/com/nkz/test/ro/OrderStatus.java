package com.nkz.test.ro;

public enum OrderStatus {
    OK("下单成功"),FAIL("下单失败");
    private String name;

    OrderStatus(String name) {
        this.name = name;
    }
}
