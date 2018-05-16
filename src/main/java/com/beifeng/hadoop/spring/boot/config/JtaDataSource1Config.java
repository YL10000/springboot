/*
 * 项目名：beifeng-spring-boot-demo
 * 文件名：DataSource1Config.java
 * 版权：Copyright (c) 2014-2015 Beijing BiYouWoShi Tech. Co. Ltd. All Rights Reserved.
 * 描述：
 * 修改人：yanglin
 * 修改时间：2018年5月7日 下午3:04:38
 * 修改内容：
 * 版本编号：1.0
 */
package com.beifeng.hadoop.spring.boot.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;

/**
 * DataSource1Config
 *	
 * @Description 第一个数据库的配置信息
 * @author yanglin
 * @version 1.0,2018年5月7日
 * @see
 * @since
 */
@Configuration//注册到spring boot容器中
@MapperScan(basePackages="com.beifeng.hadoop.spring.boot.dao.jta.test1",sqlSessionFactoryRef="jtaTest1SqlSessionFactory")
public class JtaDataSource1Config {

    @Bean(name="jtaTest1DataSource")
    @Primary
    public DataSource testDataSource(DB1Config db1Config){
        MysqlXADataSource dataSource=new MysqlXADataSource();
        dataSource.setUrl(db1Config.getUrl());
        dataSource.setUser(db1Config.getUsername());
        dataSource.setPassword(db1Config.getPassword());
        dataSource.setPinGlobalTxToPhysicalConnection(true);
        
        AtomikosDataSourceBean atomikosDataSource=new AtomikosDataSourceBean();
        atomikosDataSource.setXaDataSource(dataSource);
        atomikosDataSource.setUniqueResourceName("jtaTest1DataSource");
        atomikosDataSource.setTestQuery(db1Config.getTestQuery());
        return atomikosDataSource;
    }
    
    @Bean(name="jtaTest1SqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("jtaTest1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }
    
    @Bean(name="jtaTest1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("jtaTest1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
