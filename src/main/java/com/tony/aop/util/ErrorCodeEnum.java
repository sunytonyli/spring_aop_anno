package com.tony.aop.util;

/**
 * @author songyu.li@yeepay.com
 * @createDatetime 2016年3月17日 下午5:39:35
 */

public enum ErrorCodeEnum {

	SIGIN_CHECK_FAILURE(-101, "签名错误"), SECURE_VALID_FAILURE(403, "无权限");
	
	public int code;
    public String message;

    ErrorCodeEnum(int code, String message){
        this.code = code;
        this.message = message;
    }
}
