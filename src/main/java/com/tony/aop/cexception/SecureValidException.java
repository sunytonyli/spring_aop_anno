package com.tony.aop.cexception;

/**
 * @author songyu.li@yeepay.com
 * @createDatetime 2016年3月17日 下午5:34:22
 */

public class SecureValidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5822480790376157763L;

	public SecureValidException(){
		super();
	}
	
	public SecureValidException(String msg){
		super(msg);
	}
}
