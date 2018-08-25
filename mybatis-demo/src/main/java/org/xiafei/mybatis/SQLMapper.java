package org.xiafei.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.xiafei.mybatis.bean.Cat;

@Mapper
public interface SQLMapper {

    @Select("select count(*) from t1")
     int query();


    @Update("update test_1 set name='xxx' where id=#{id}")
    int update(@Param("id") Integer id);

    @Update("update test_1 set name='xxx' where id=#{age}")
    int updateCat(Cat cat);
}
