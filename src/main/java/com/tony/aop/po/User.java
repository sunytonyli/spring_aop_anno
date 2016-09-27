package com.tony.aop.po;

import java.io.Serializable;

/**
 * @author songyu.li@yeepay.com
 * @createDatetime 2016年3月17日 上午9:54:06
 */

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5100141260900527773L;

	private Long userId;
	private String userName;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
