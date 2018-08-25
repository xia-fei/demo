package org.xiafei.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xiafei.mybatis.Application;
import org.xiafei.mybatis.SQLMapper;
import org.xiafei.mybatis.bean.Cat;

import javax.annotation.Resource;

/**
 * @author 夏飞
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Resource
    private SQLMapper SQLMapper;

    @Test
    public void testQuery(){
        System.out.println(SQLMapper.query());
    }

    @Test
    public void testUpdate(){
        System.out.println(SQLMapper.update(3));
    }

    @Test
    public void testUpdateObject(){
        Cat cat=new Cat();
        cat.setAge(1);
        cat.setName("花花");
        System.out.println(SQLMapper.updateCat(cat));
    }
}
