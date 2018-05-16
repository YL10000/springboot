/*
 * 项目名：beifeng-spring-boot-demo
 * 文件名：WebLogAspect.java
 * 版权：Copyright (c) 2014-2015 Beijing BiYouWoShi Tech. Co. Ltd. All Rights Reserved.
 * 描述：
 * 修改人：yanglin
 * 修改时间：2018年5月7日 下午5:07:29
 * 修改内容：
 * 版本编号：1.0
 */
package com.beifeng.hadoop.spring.boot.aop;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * WebLogAspect
 *	
 * @Description aop实现统一的日志管理
 * @author yanglin
 * @version 1.0,2018年5月7日
 * @see
 * @since
 */
@Aspect
@Component
public class WebLogAspect {

    private Logger logger=LoggerFactory.getLogger(WebLogAspect.class);
    
    private Long startTime;
    
    @Pointcut("execution(public * com.beifeng.hadoop.spring.boot.controller..*.*(..))")
    public void webLog() {
        
    }
    
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("==============开始请求=============");
        startTime=System.currentTimeMillis(); 
        //接收到请求，记录请求内容
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest=requestAttributes.getRequest();
        logger.info("url:   "+httpServletRequest.getRequestURL());
        logger.info("http_method:    "+httpServletRequest.getMethod());
        logger.info("ip    "+httpServletRequest.getRemoteAddr());
        Enumeration<String> parameterNames = httpServletRequest.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = (String) parameterNames.nextElement();
            logger.info("parameter:{}->{}",parameterName,httpServletRequest.getParameter(parameterName));
        }
    }
    
    @AfterReturning(returning="ret",pointcut="webLog()")
    public void doAfterReturning(Object ret) {
        //处理完请求，返回内容
        logger.info("响应结果："+ret);
        logger.info("==============开始结束，耗时"+(System.currentTimeMillis()-startTime)+"毫秒=============");
        
    }
}
