package com.beifeng.hadoop.spring.boot.dao.test1;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface User1Dao {

    @Insert("insert into user values (null,#{name},#{age})")
    public void insertUser(@Param("name")String name,@Param("age")Integer age) ;
}
