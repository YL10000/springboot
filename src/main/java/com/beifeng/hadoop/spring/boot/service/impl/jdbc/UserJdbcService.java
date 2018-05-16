package com.beifeng.hadoop.spring.boot.service.impl.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserJdbcService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Object getUser(Integer id){
        String username=jdbcTemplate.queryForObject("select username from cas_user where id = ?", String.class,id);
        return username;
    }
}
