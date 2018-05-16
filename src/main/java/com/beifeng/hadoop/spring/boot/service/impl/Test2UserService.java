/*
 * 项目名：beifeng-spring-boot-demo
 * 文件名：Test1UserService.java
 * 版权：Copyright (c) 2014-2015 Beijing BiYouWoShi Tech. Co. Ltd. All Rights Reserved.
 * 描述：
 * 修改人：yanglin
 * 修改时间：2018年5月7日 下午3:36:25
 * 修改内容：
 * 版本编号：1.0
 */
package com.beifeng.hadoop.spring.boot.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.hadoop.spring.boot.dao.test2.User2Dao;

/**
 * Test1UserService
 *	
 * @Description 功能详细描述 
 * @author yanglin
 * @version 1.0,2018年5月7日
 * @see
 * @since
 */
@Service
public class Test2UserService {
    
    @Autowired
    private User2Dao user2Dao;
    
    @Transactional
    public void insertUser(String name,Integer age) {
        user2Dao.insertUser(name, age);
    }
}
