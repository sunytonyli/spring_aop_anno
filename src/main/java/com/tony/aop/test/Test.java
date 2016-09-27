package com.tony.aop.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

import com.tony.aop.genurl.DesUtil;
import com.tony.aop.util.Constants;
import com.tony.aop.util.StringUtils;


/**
 * @author songyu.li@yeepay.com
 * @createDatetime 2016年3月22日 下午4:04:52
 */

public class Test {

	public static void main(String[] args) throws IOException {
		
//		byte userNmae[] = Base64.encodeBase64("13693190388".getBytes());
//		byte password[] = Base64.encodeBase64("123456".getBytes());
//		byte idNo[] = Base64.encodeBase64("130824198611024012".getBytes());
//		
//		System.out.println(new String(userNmae) + "==" + new String(password) + "==" + new String(idNo));
//		System.out.println(new String(Base64.decodeBase64("MTExMTEx".getBytes())));
//		
//			String ss = "GucmOG+BRfPdfxYOHjdAAnll+6xd+3flHrNPOBg2YHBJthKLIXuA5cXeg8z4sLE5";
//			//String ssUtf8 = StringUtils.getUtf8EscapedString(ss);
//			String str = new String(Base64.encodeBase64(StringUtils.compress(ss)));
//			byte[] deco = Base64.decodeBase64(str.getBytes());
//			System.out.println("压缩前===" + ss);
//			System.out.println("压缩后===" + str);
//			System.out.println("解压后===" + StringUtils.decompress(deco));
			
			
	/*	String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		//String securetKey = uuid.substring(0,8) + uuid.substring(uuid.length() - 8) + "_" + System.currentTimeMillis();
		String securetKey = uuid.substring(0,18) + "_" + System.currentTimeMillis();
		System.out.println(uuid.substring(0,7));
		System.out.println(uuid.substring(uuid.length() - 7));
		
			String key = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20).toUpperCase() + "_" + System.currentTimeMillis();
			for(int i=0; i<20; i++){
				//System.out.println(UUID.randomUUID().toString());
				System.out.println(DesUtil.encryptMode(securetKey, Constants.DES_ALGORITHM_DESEDE, Constants.DES_KEY));
				System.out.println(DesUtil.encryptMode("muDmj7HaVUnAQCoSjcr5WZ70B1YebNe", Constants.DES_ALGORITHM_DESEDE, Constants.DES_KEY));

			
			}*/
		
		String version = "2.2.0.upgrade";
		System.out.println(version.contains("upgrade"));
		
		System.out.println(System.currentTimeMillis());
		
		System.out.println(Long.parseLong("000000095200"));
		
	}

}
