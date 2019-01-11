package com.nkz.test;

import com.ncarzone.businessunitcenter.ro.product.ProductRO;
import org.junit.Test;
import org.wing.mocker.core.MockData;

public class Main {
    @Test
    public void test2(){
        MockData mockData=new MockData();
        mockData.mock(com.qccr.authoritymanager.ro.AuthUserRO.class);
    }
    @Test
    public void test1(){
        MockData mockData=new MockData();
        mockData.mock(ProductRO.class);
    }
}
