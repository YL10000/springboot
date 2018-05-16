package com.beifeng.hadoop.spring.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.beifeng.hadoop.spring.boot.config.DB1Config;
import com.beifeng.hadoop.spring.boot.config.DB2Config;

/**
 * Hello world! spring boot 启动入口类
 *
 */

@SpringBootApplication
@MapperScan("com.beifeng.hadoop.spring.boot.dao")
@EnableConfigurationProperties(value={DB1Config.class,DB2Config.class})
public class App {
    
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
