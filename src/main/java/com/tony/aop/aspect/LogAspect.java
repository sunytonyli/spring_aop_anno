package com.tony.aop.aspect;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * @author songyu.li@yeepay.com
 * @createDatetime 2016年3月16日 下午6:44:55
 * @Aspect 该注解标示该类为切面类 
 * @Component 注入依赖
 * 
 * 使用AOP的步骤
 * 1声明一个切面，切面必须是在IOC容器中，所以必须添加@component注解，而且还说明是一个切面，所以还要添加@Aspect注解
 * 2定义通知：通知有五种，分别是前置通知、后置通知、返回通知、异常通知、环绕通知，根据业务需求定义所需的通知
 * 3在通知里说明通知时由那个类的那个方法执行
 * 4在Spring的配置文件自动扫描<context:component-scan>和配置AspectJ
 * 配置AspectJ是当我们调用一个目标方法时，而这个目标方法跟我注解声明的方法相匹配的时候，那么AOP框架应该自动的为那个方法所在的那个类生成一个代理对象，
 * 在我目标方法执行之前先来执行切面的对应的方法
 */

@Aspect
@Component
@Order(1)
public class LogAspect {

	private static final Logger logger = Logger.getLogger(LogAspect.class); 
	
	@Pointcut("@annotation(com.tony.aop.customannotaion.AutoPrintLog)")
	public void printLog(){
		logger.info("这是一个基于注解的切入点");
	}
	
	@Before("printLog()")
	public void beforeAction(JoinPoint joinPoint){
		
		logger.info("=======这是日志切入点入口=======");
		
		Object[] parames = joinPoint.getArgs();//获取目标方法体参数
		String signature = joinPoint.getSignature().toString();//获取目标方法签名
		
		//int index = -1;
		//index = Arrays.asList(parames).indexOf("ss"); //查找参数值所在的数组位置(数组下标)
		//parames[index] = "PP"; //将"ss" 修改为 "PP"
		//joinPoint.proceed(parames); //将修改后的数组传入
		
		RequestAttributes reqAttr = RequestContextHolder.getRequestAttributes();
		HttpServletRequest req = ((ServletRequestAttributes) reqAttr).getRequest();
		Enumeration<?> paramNames = req.getParameterNames();
		while(paramNames.hasMoreElements()){  
		    String name=(String)paramNames.nextElement();  
		    String value=req.getParameter(name);  
		    System.out.println(name + "=" + value);  
		}  
		
		logger.info("*******logBefore() is running!******");
		logger.info("logBefore() ==" + joinPoint.getSignature().getName() + "===" + req.getParameter("userId"));
		logger.info("*******logBefore() End *********");
	}
}
