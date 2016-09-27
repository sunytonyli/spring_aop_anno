package com.tony.aop.util;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 系统工具类
 * @author songyu.li@yeepay.com
 * @createDatetime 2016年3月18日 下午4:21:44
 */

public class ApiUtils {
	
	public static String signTopRequest(Map<String, String> params, String secret, String signMethod) throws IOException {
	   
		// 第一步：检查参数是否已经排序
	    String[] keys = params.keySet().toArray(new String[0]);
	    Arrays.sort(keys);
	 
	    // 第二步：把所有参数名和参数值串在一起
	    StringBuffer query = new StringBuffer();
	    if (Constants.SIGN_METHOD_MD5.equals(signMethod)) {
	        query.append(secret);
	    }
	    for (String key : keys) {
	        String value = params.get(key);
	        if (StringUtils.areNotEmpty(key, value)) {
	            query.append(key).append(value);
	        }
	    }
	 
	    // 第三步：使用MD5/HMAC加密
	    byte[] bytes;
	    if (Constants.SIGN_METHOD_HMAC.equals(signMethod)) {
	        bytes = encryptHMAC(query.toString(), secret);
	    } else {
	        query.append(secret);
	        bytes = encryptMD5(query.toString());
	    }
	 
	    // 第四步：把二进制转化为大写的十六进制
	    return byte2hex(bytes);
	}
	 
	public static byte[] encryptHMAC(String data, String secret) throws IOException {
	    byte[] bytes = null;
	    try {
	        SecretKey secretKey = new SecretKeySpec(secret.getBytes(Constants.CHARSET_UTF8), "HmacMD5");
	        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
	        mac.init(secretKey);
	        bytes = mac.doFinal(data.getBytes(Constants.CHARSET_UTF8));
	    } catch (GeneralSecurityException gse) {
	        throw new IOException(gse.toString());
	    }
	    return bytes;
	}
	 
	public static byte[] encryptMD5(String data) throws IOException {
		MessageDigest md5 = getMd5MessageDigest();
		return md5.digest(data.getBytes(Constants.CHARSET_UTF8));
	}
	 
	private static MessageDigest getMd5MessageDigest() throws IOException {
		try {
			return MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IOException(e.getMessage());
		}
	}
	
	public static String byte2hex(byte[] bytes) {
	    StringBuffer sign = new StringBuffer();
	    for (int i = 0; i < bytes.length; i++) {
	        String hex = Integer.toHexString(bytes[i] & 0xFF);
	        if (hex.length() == 1) {
	            sign.append("0");
	        }
	        sign.append(hex.toUpperCase());
	    }
	    return sign.toString();
	}
	
}
