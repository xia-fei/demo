package com.example.demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SqlBoot {
    private final JdbcTemplate jdbcTemplate;

    public SqlBoot(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void startOrderDetail() throws InterruptedException {
        List<Long> list=jdbcTemplate.queryForList("select id from sh_order_detail where settlement_time>'2019-01-07' ",Long.class);
        for (Long id:list){
            int i=jdbcTemplate.update("update sh_order_detail set update_time=date_add(update_time,interval 1 second) where id=? ",id);
            Thread.sleep(200);
            System.out.println(String.format("i = %d  id=%d ",i,id));
        }
    }

    public void startOrder() throws InterruptedException {
        List<Long> list=jdbcTemplate.queryForList("select id from sh_order where id>813778 ",Long.class);
        for (Long id:list){
            int i=jdbcTemplate.update("update sh_order set update_time=date_add(update_time,interval 1 second) where id=? ",id);
            Thread.sleep(200);
            System.out.println(String.format("i = %d  id=%d ",i,id));
        }
    }


    public void start() throws InterruptedException {
        List<Long> list=jdbcTemplate.queryForList("select id from sh_commission_detail where cal_time>'2018-10-01' and store_id!=1626950 ",Long.class);
        for (Long id:list){
            int i=jdbcTemplate.update("update sh_commission_detail set update_time=date_add(update_time,interval 1 second) where id=? ",id);
            Thread.sleep(300);
            System.out.println(String.format("i = %d  id=%d ",i,id));
        }
    }


    public void start1() throws InterruptedException {

        List<Long> list=jdbcTemplate.queryForList("select id from sh_user_times_card where update_time>'2018-10-01' and store_id=1626950 ",Long.class);
        for (Long id:list){
            int i=jdbcTemplate.update("update sh_user_times_card set update_time=date_add(update_time,interval 1 second) where id=? ",id);
            Thread.sleep(300);
            System.out.println(String.format("i = %d  id=%d ",i,id));
        }

    }



    public void start2() throws InterruptedException {
        List<Long> list=jdbcTemplate.queryForList("select id from sh_vip_card_bill where update_time>'2018-10-01' and store_id=1626950 ",Long.class);
        for (Long id:list){
            int i=jdbcTemplate.update("update sh_vip_card_bill set update_time=date_add(update_time,interval 1 second) where id=? ",id);
            Thread.sleep(300);
            System.out.println(String.format("i = %d  id=%d ",i,id));
        }
    }
}
