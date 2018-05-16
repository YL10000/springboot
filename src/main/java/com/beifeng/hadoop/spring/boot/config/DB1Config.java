/*
 * 项目名：beifeng-spring-boot-demo
 * 文件名：DB1Config.java
 * 版权：Copyright (c) 2014-2015 Beijing BiYouWoShi Tech. Co. Ltd. All Rights Reserved.
 * 描述：
 * 修改人：yanglin
 * 修改时间：2018年5月7日 下午4:06:35
 * 修改内容：
 * 版本编号：1.0
 */
package com.beifeng.hadoop.spring.boot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;

/**
 * DB1Config
 *	
 * @Description 第一个数据源的配置信息
 * @author yanglin
 * @version 1.0,2018年5月7日
 * @see
 * @since
 */
@ConfigurationProperties(prefix="spring.datasource.test1")
@Primary
public class DB1Config {
    
    private String url;
    
    private String username;
    
    private String password;
    
    private String testQuery;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTestQuery() {
        return testQuery;
    }

    public void setTestQuery(String testQuery) {
        this.testQuery = testQuery;
    }
    
    
}
