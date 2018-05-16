package com.beifeng.hadoop.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beifeng.hadoop.spring.boot.modal.CasUser;
import com.beifeng.hadoop.spring.boot.modal.User;
import com.beifeng.hadoop.spring.boot.service.impl.Test1JtaUserService;
import com.beifeng.hadoop.spring.boot.service.impl.Test1UserService;
import com.beifeng.hadoop.spring.boot.service.impl.Test2JtaUserService;
import com.beifeng.hadoop.spring.boot.service.impl.Test2UserService;
import com.beifeng.hadoop.spring.boot.service.impl.jdbc.UserJdbcService;
import com.beifeng.hadoop.spring.boot.service.impl.jpa.UserJpaService;
import com.beifeng.hadoop.spring.boot.service.impl.mybatis.UserMyBatisService;

@RestController
public class UserController {
    
    @Autowired
    UserJdbcService  userJdbcService;
    
    @Autowired
    UserJpaService userJpaService;
    
    @Autowired
    UserMyBatisService userMyBatisService;
    
    @Autowired
    Test1UserService test1UserService;
    
    @Autowired
    Test2UserService test2UserService;
    
    @Autowired
    Test1JtaUserService test1JtaUserService;
    
    @Autowired
    Test2JtaUserService test2JtaUserService;
    
    @RequestMapping("getUser")
    public Object getUser(Integer id) {
        return userJdbcService.getUser(id);
    }
    
    @RequestMapping("insertUserJpa")
    public String insertUserJpa() {
        userJpaService.insertUser(new User("tom", "111111", "qqq@qq.com", "15245874851", ""));
        return "SUCCESS";
    }
    
    @RequestMapping("getUserMyBatis")
    public CasUser getUserMyBatis(Integer id) {
        return userMyBatisService.findUserById(id);
    }
    
    @RequestMapping("insertUserTest1")
    public String insertUserTest1(String name,Integer age) {
        test1UserService.insertUser(name, age);
        return "success";
    }
    
    @RequestMapping("insertUserTest2")
    public String insertUserTest2(String name,Integer age) {
        test2UserService.insertUser(name, age);
        return "success";
    }
    
    @RequestMapping("inserJtaUserTest1")
    public String inserJtatUserTest1(String name,Integer age) {
        test1JtaUserService.insertJtaUser(name, age);
        return "success";
    }
    
    @RequestMapping("inserJtaUserTest2")
    public String insertJtaUserTest2(String name,Integer age) {
        test2JtaUserService.insertJtaUser(name, age);
        return "success";
    }

}
