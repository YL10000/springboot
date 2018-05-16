package com.beifeng.hadoop.spring.boot.service.impl.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.hadoop.spring.boot.dao.CasUserMapper;
import com.beifeng.hadoop.spring.boot.modal.CasUser;

@Service
public class UserMyBatisService {
    
    @Autowired
    CasUserMapper casUserMapper;
    
    public CasUser findUserById(Integer id) {
        return casUserMapper.selectByPrimaryKey(id);
    }

}
