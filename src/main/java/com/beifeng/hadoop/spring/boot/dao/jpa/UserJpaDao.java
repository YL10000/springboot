package com.beifeng.hadoop.spring.boot.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beifeng.hadoop.spring.boot.modal.User;

public interface UserJpaDao extends JpaRepository<User, Integer> {

}
