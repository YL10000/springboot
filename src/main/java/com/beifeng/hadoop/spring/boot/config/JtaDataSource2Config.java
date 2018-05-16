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
@MapperScan(basePackages="com.beifeng.hadoop.spring.boot.dao.jta.test2",sqlSessionFactoryRef="jtaTest2SqlSessionFactory")
public class JtaDataSource2Config {

    @Bean(name="jtaTest2DataSource")
    public DataSource testDataSource(DB2Config db2Config){
        MysqlXADataSource dataSource=new MysqlXADataSource();
        dataSource.setUrl(db2Config.getUrl());
        dataSource.setUser(db2Config.getUsername());
        dataSource.setPassword(db2Config.getPassword());
        dataSource.setPinGlobalTxToPhysicalConnection(true);
        
        AtomikosDataSourceBean atomikosDataSource=new AtomikosDataSourceBean();
        atomikosDataSource.setXaDataSource(dataSource);
        atomikosDataSource.setUniqueResourceName("jtaTest2DataSource");
        atomikosDataSource.setTestQuery(db2Config.getTestQuery());
        return atomikosDataSource;
    }
    
    @Bean(name="jtaTest2SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("jtaTest2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }
    
    @Bean(name="jtaTest2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("jtaTest2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
