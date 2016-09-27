package com.tony.aop.util;

import java.util.TimeZone;

/**
 * 公用常量类
 * @author songyu.li@yeepay.com
 * @createDatetime 2016年3月18日 下午2:42:27
 */

public abstract class Constants {

	   public static final TimeZone TOP_TIMEZONE = TimeZone.getTimeZone("GMT+8");

	    /**
	     * TOP默认时间格式 *
	     */
	    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	    /**
	     * UTF-8字符集 *
	     */
	    public static final String CHARSET_UTF8 = "UTF-8";

	    /**
	     * GBK字符集 *
	     */
	    public static final String CHARSET_GBK = "GBK";

	    /**
	     * TOP JSON 应格式
	     */
	    public static final String FORMAT_JSON = "json";
	    /**
	     * TOP XML 应格式
	     */
	    public static final String FORMAT_XML = "xml";
	    
	    /**
	     * 签名方式
	     */
	    public static final String SIGN_METHOD_MD5 = "md5";

	    public static final String SIGN_METHOD_HMAC = "hmac";

	    public static final String SIGN_METHOD_SECRET = "S2V5MDk0YjE4NTU4OWY4NDJhY2FhOWM4ODk5YmQyMzFiNTA";

	    
	    public static final String DES_KEY = "$apr1$69cKbVhx$vd2W9zllq";
	    
	    public static final String DES_ALGORITHM_DES = "DES";
	    
	    public static final String DES_ALGORITHM_DESEDE = "DESede";

	    public static final String DES_ALGORITHM_BLOWFISH = "Blowfish";
}
