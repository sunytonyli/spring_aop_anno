package com.tony.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author songyu.li@yeepay.com
 * @createDatetime 2016年5月4日 下午4:39:10
 */

@Aspect
@Component
public class RetryAspect {

	private static Logger logger = LoggerFactory.getLogger(RetryAspect.class);
	
	@Pointcut("execution(* com.tony.aop.service.AnnoService.retry*(..))")
    public void retryServiceMethods() {
        logger.info("重试日志Aspect");
    }
	
	@Before("retryServiceMethods()")
	public void beforeAction(JoinPoint joinPoint){
		logger.info("RetryAspect 开始============");
	}
}
