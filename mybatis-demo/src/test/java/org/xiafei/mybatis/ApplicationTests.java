package org.xiafei.mybatis;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.xiafei.mybatis.bean.Cat;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 夏飞
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Resource
    private SQLMapper SQLMapper;
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    public void testFindQccr() {
        jdbcTemplate.queryForList("show tables", String.class).forEach((tableName) -> {
                            System.out.println("start "+tableName);
            jdbcTemplate.queryForList("SELECT column_name from information_schema.columns WHERE   TABLE_NAME = '" + tableName + "'", String.class).forEach((columnName) -> {
                String sql="select %s from %s where %s like '%s'";
                List<Map<String, Object>>  list=jdbcTemplate.queryForList(String.format(sql, columnName, tableName, columnName,"%qccr%"));
                if(list.size()>0){
                    String value=String.valueOf(list.get(0).get(columnName));
                    System.out.println(tableName+"."+columnName+" "+list.size()+"条,eg:"+value );
                }
            });
        });
    }

    @Test
    public void testQuery() {
        System.out.println(SQLMapper.query());
    }

    @Test
    public void testUpdate() {
        System.out.println(SQLMapper.update(3));
    }

    @Test
    public void testUpdateObject() {
        Cat cat = new Cat();
        cat.setAge(1);
        cat.setName("花花");
        System.out.println(SQLMapper.updateCat(cat));
    }

    @Test
    public void testJdbcTemplate2() {

        Object o = namedParameterJdbcTemplate.queryForList("select * from sh_order where store_id=:storeId limit 10", ImmutableMap.<String, Object>of("storeId", "1645"));
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void testJdbcTemplate() {
        List<Map<String, Object>> table = jdbcTemplate.queryForList("select * from stadium limit 10");
        System.out.println(JSON.toJSONString(table));
    }
}
