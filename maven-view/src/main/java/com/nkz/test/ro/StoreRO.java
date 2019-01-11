package com.nkz.test.ro;

import java.util.List;
import java.util.Map;

public class StoreRO extends BaseRO {

    private int score;
    private ProductRO[] productArray;
    private String[] productName;
    private List<ProductRO> productList;
    private OrderStatus orderStatus;
    private Map<String,Integer> simpleMap;
    private Map<String,ProductRO> objectMap;

    public Map<String, Integer> getSimpleMap() {
        return simpleMap;
    }

    public void setSimpleMap(Map<String, Integer> simpleMap) {
        this.simpleMap = simpleMap;
    }

    public Map<String, ProductRO> getObjectMap() {
        return objectMap;
    }

    public void setObjectMap(Map<String, ProductRO> objectMap) {
        this.objectMap = objectMap;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ProductRO[] getProductArray() {
        return productArray;
    }

    public void setProductArray(ProductRO[] productArray) {
        this.productArray = productArray;
    }

    public String[] getProductName() {
        return productName;
    }

    public void setProductName(String[] productName) {
        this.productName = productName;
    }

    public List<ProductRO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductRO> productList) {
        this.productList = productList;
    }
}
