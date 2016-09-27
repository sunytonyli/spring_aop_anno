package com.tony.aop.customannotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author songyu.li@yeepay.com
 * @createDatetime 2016年3月16日 下午6:19:10
 * 自定义注解
 * @Target 用于描述注解的使用范围(即：被描述的注解可以用在什么地方)
 * @Retention 用于描述注解的生命周期(即：被描述的注解在什么范围内有效)
 * @Inherited (是否继承注解)比如有一个类A，在他上面有一个标记annotation，那么A的子类B是否不用再次标记annotation就可以继承得到呢，答案是肯定的
 * 参考:http://www.cnblogs.com/shipengzhi/articles/2716004.html
 */

/**
 * 
 * ElementType.METHOD 用于描述方法
 * RetentionPolicy.RUNTIME 在运行时有效(即运行时保留)
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface AutoPrintLog {

	String desc() default "访问日志记录...";
	
}
