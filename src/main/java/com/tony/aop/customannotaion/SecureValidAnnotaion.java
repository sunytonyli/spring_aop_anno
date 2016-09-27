package com.tony.aop.customannotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author songyu.li@yeepay.com
 * @createDatetime 2016年3月17日 上午11:34:30
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SecureValidAnnotaion {

	String desc() default "权限认证...";

}
