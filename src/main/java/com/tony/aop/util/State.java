package com.tony.aop.util;

import java.io.Serializable;

/**
 * @author songyu.li@yeepay.com
 * @createDatetime 2015年11月3日 下午7:16:09
 */

public class State implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4676257730517853321L;

	private int code;
	private String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
