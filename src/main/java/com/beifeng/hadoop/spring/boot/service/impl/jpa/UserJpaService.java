package com.beifeng.hadoop.spring.boot.service.impl.jpa;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.hadoop.spring.boot.dao.jpa.UserJpaDao;
import com.beifeng.hadoop.spring.boot.modal.User;

@Service
public class UserJpaService {

    @Autowired
    private UserJpaDao userJpaDao;
    
    @Transactional
    public void insertUser(User user) {
        userJpaDao.save(user);
    }
}
