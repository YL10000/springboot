package com.beifeng.hadoop.spring.boot.dao;

import com.beifeng.hadoop.spring.boot.modal.CasUser;

public interface CasUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CasUser record);

    int insertSelective(CasUser record);

    CasUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CasUser record);

    int updateByPrimaryKey(CasUser record);
}