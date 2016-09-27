package com.tony.aop.aspect;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.tony.aop.util.ErrorCodeEnum;
import com.tony.aop.util.State;

/**
 * @author songyu.li@yeepay.com
 * @createDatetime 2016年3月17日 上午11:04:05
 */

@Aspect
@Component
@Order(2)
public class SecureValid {

	private static final Logger logger = Logger.getLogger(SecureValid.class); 

	@Pointcut("@annotation(com.tony.aop.customannotaion.SecureValidAnnotaion)")
	public void valid(){
		logger.info("这是一个基于注解的切入点");
	}
	
	@Before("valid()")
	public void beforeAction(JoinPoint joinPoint) {
		
		logger.info("=======开始权限认证=======");

		logger.info("*******logBefore() is running!******");
		logger.info("logBefore() ==" + joinPoint.getSignature().getName());
		logger.info("*******logBefore() End *********");
	}
	
	@Around("valid()")
	public Object aroundAction(ProceedingJoinPoint joinPoint){
		
		logger.info("logAround() is running!");
		logger.info("logAround() ==" + joinPoint.getSignature().getName());
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
			
		logger.info("Around before is running!");
		//joinPoint.proceed(); //continue on the intercepted method
		State state = new State();
		state.setCode(ErrorCodeEnum.SECURE_VALID_FAILURE.code);
		state.setMessage(ErrorCodeEnum.SECURE_VALID_FAILURE.message);
		return state;
	}
}
