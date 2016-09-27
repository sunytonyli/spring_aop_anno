package com.tony.aop.genurl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.codec.digest.DigestUtils;

import sun.misc.BASE64Encoder;

import com.tony.aop.po.PdsOrder;
import com.tony.aop.util.AesUtil;
import com.tony.aop.util.ApiUtils;
import com.tony.aop.util.Constants;
import com.tony.aop.util.EncrypMD5;
import com.tony.aop.util.RequestBean;

/**
 * @author songyu.li@yeepay.com
 * @createDatetime 2016年3月20日 上午2:57:05
 */

public class GenUrl {

	public static void main(String[] args) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("pageSize", "3");
		params.put("status", "IRP");
		params.put("page", "1");
		params.put("timestamp", String.valueOf(System.currentTimeMillis()));
		params.put("version", "2.0.1");
		params.put("securetKey", "DtCdHXzvh1AUEHFd/Lflejr5tNJm1qQ0ZGzul0722hPM02HNBKCwK4zN8MDZzYtw");
	     
	    String sign = ApiUtils.signTopRequest(params, Constants.SIGN_METHOD_SECRET, Constants.SIGN_METHOD_HMAC);
	    		

	  /*  System.out.println("http://localhost:8080/mapi/api/mobile/project/list.json?sign=" + sign + "&"
	                           + generateQueryString(params, true));
	    
	    System.out.println("http://localhost:8080/mapi/api/mobile/home/project.json?sign=" + sign + "&" +
	    		generateQueryString(params, true));
	    
	    loginUrl();*/
	    //register();
	    //loginUrl();
	   // investorList();
	   // upGrade();
	   //edmProjectList();
	    //resetSecuretKey();
	   // verSignV3();
	    //pdsSign();
	    initDevice();
	    /*  PdsOrder pds = new PdsOrder();
	    pds.setOutOrderNo("100022");
	    pds.setPTDealerID("203022");
	    pds.setSign("b3ac9aca63b317f83fb8d6d69d3cc281");
	    pds.setTradeDate("2016-04-18");
	    
	    Map<String,String> map = new HashMap<String, String>();
	    map.put("OutOrderNo", "100022");
	    map.put("PTDealerID", "203022");
	    map.put("Sign", "b3ac9aca63b317f83fb8d6d69d3cc281");
	    map.put("TradeDate", "2016-04-18");
*/
	   
	   // JsonConfig config = new JsonConfig();  
        //config.setIgnoreDefaultExcludes(true);
	   // System.out.println(JSONObject.fromObject("{\"PTDealerID\":\"203022\",\"OutOrderNo\":\"100022\",\"TradeDate\":\"2016-04-18\",\"Sign\":\"b3ac9aca63b317f83fb8d6d69d3cc281\"}"));
	  /*  System.out.println(JSONObject.fromObject(map));
	    JSONObject json = RequestBean.sentPostJson("http://210.74.1.46:8040/PDSService/QueryTradeByOrderNo", 
	    JSONObject.fromObject(map));
	    System.out.println(json.toString());
	    System.out.println(JSONObject.fromObject(json.get("Detail").toString()));
	    System.out.println(Integer.parseInt("00001"));*/
	    
	   // System.out.println(JSONObject.fromObject("已取消"));
			
	}
	
	
	public static void edmProjectList() throws IOException{
		Map<String, String> params = new HashMap<String, String>();
		params.put("timestamp", String.valueOf(System.currentTimeMillis()));
		params.put("version", "2.2.0.01");
		params.put("client", "IOS");
		String sign = ApiUtils.signTopRequest(params, Constants.SIGN_METHOD_SECRET, Constants.SIGN_METHOD_HMAC);
		    System.out.println("http://localhost:8080/mapi/api/mobile/edm/project/list.json?sign=" + sign + "&"
	                + generateQueryString(params, false));
	}
	
	public static void upGrade() throws IOException{
		Map<String, String> params = new HashMap<String, String>();
		params.put("timestamp", String.valueOf(System.currentTimeMillis()));
		params.put("osVersion", "4.4.2");
		params.put("client", "Android");
		params.put("imei", "357143043265997");
		params.put("userId", "XaOOz9/5MyE=");
		params.put("mac", "60:e7:01:5c:1e:87");
		params.put("udid", "b148931a550fa5b91bf78f55f433ce99");
		params.put("version", "2.3.0");
		String sign = ApiUtils.signTopRequest(params, Constants.SIGN_METHOD_SECRET, Constants.SIGN_METHOD_HMAC);
		    System.out.println("http://localhost:8080/mapi/api/mobile/upgrade.json?sign=" + sign + "&"
	                + generateQueryString(params, false));
	}
	
	public static void initDevice() throws IOException{
		Map<String, String> params = new HashMap<String, String>();
		params.put("timestamp", String.valueOf(System.currentTimeMillis()));
		params.put("version", "2.4.0");
		params.put("client", "Android");
		params.put("userId", "Y7jhgwGRZwc=");
		params.put("osVersion", "4.4.2");
		params.put("appDeviceId", "89b0a0706fa863fb6d319f979861e2bd");
		params.put("imei", "866654024551191");
		params.put("appSecuretKey", "GKGaOanSO2AJdKaRGc6WQS6Z9cnGqZE4MzHRCLJ");
		params.put("MAC", "38:bc:1a:48:49:71");
		String sign = ApiUtils.signTopRequest(params, Constants.SIGN_METHOD_SECRET, Constants.SIGN_METHOD_HMAC);
		    System.out.println("http://localhost:8080/mapi/api/mobile/register/device/post.json?sign=" + sign + "&"
	                + generateQueryString(params, false));
	}
	
	public static void idAuth() throws IOException{
		Map<String, String> params = new HashMap<String, String>();
		params.put("timestamp", String.valueOf(System.currentTimeMillis()));
		params.put("version", "2.2.0.01");
		params.put("client", "IOS");
		params.put("idNo", "110101201304015078");
		params.put("userId", "383748");
		params.put("userName", "周一一");
		params.put("securetKey", "1RFvvV5EpYAH0Wa3PYsIBcQbJ6MdsKEUMRkZK7g8GaWCNTzLwXzhcw==");
		String sign = ApiUtils.signTopRequest(params, Constants.SIGN_METHOD_SECRET, Constants.SIGN_METHOD_HMAC);
		    System.out.println("http://localhost:8080/mapi/api/mobile/investor/idAuth.json?sign=" + sign + "&"
	                + generateQueryString(params, false));
	}
	
	public static void project() throws IOException{
		Map<String, String> params = new HashMap<String, String>();
		params.put("timestamp", String.valueOf(System.currentTimeMillis()));
		params.put("version", "2.2.0");
		params.put("client", "Android");
		String sign = ApiUtils.signTopRequest(params, Constants.SIGN_METHOD_SECRET, Constants.SIGN_METHOD_HMAC);
		    System.out.println("http://localhost:8080/mapi/api/mobile/home/project.json?sign=" + sign + "&"
	                + generateQueryString(params, true));
	}
	
	private static void investorList() throws IOException{
		Map<String, String> params = new HashMap<String, String>();
		params.put("userId", "314349");
		params.put("securetKey", "76m/vgVahVQklB2VPkSfAoS3NZQ+V1V8phJItPNhh6WCNTzLwXzhcw==");
		params.put("timestamp", "1459136685842");
		params.put("version", "2.2.0");
		params.put("client", "IOS");
		//params.put("status", "");
		String sign = ApiUtils.signTopRequest(params, Constants.SIGN_METHOD_SECRET, Constants.SIGN_METHOD_HMAC);
		    System.out.println("http://localhost:8080/mapi/api/mobile/investor/resetSecuretKey.json?sign=" + sign + "&"
	                + generateQueryString(params, true));	
	}

	private static void resetSecuretKey() throws IOException{
		Map<String, String> params = new HashMap<String, String>();
		params.put("userId", "1");
		params.put("securetKey", "CI0U3Zifzb2O/baZU/ZgkMmkXn28KA8+GtSVptKRy7+CNTzLwXzhcw==");
		params.put("timestamp", String.valueOf(System.currentTimeMillis()));
		params.put("version", "2.3.0");
		String sign = ApiUtils.signTopRequest(params, Constants.SIGN_METHOD_SECRET, Constants.SIGN_METHOD_HMAC);
		    System.out.println("http://localhost:8080/mapi/api/mobile/investor/resetSecuretKey.json?sign=" + sign + "&"
	                + generateQueryString(params, false));
	}
	
	
	private static void loginUrl() throws IOException{
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", "uZvNF%2BTJCB5FZuhG6qpl8Q%3D%3D");
		params.put("password", "9O44R1PZLq9O4d7EbxJNfA%3D%3D");
		params.put("timestamp", String.valueOf(System.currentTimeMillis()));
		params.put("version", "2.2.0");

	    String sign = ApiUtils.signTopRequest(params, Constants.SIGN_METHOD_SECRET, Constants.SIGN_METHOD_HMAC);
	    System.out.println("http://localhost:8080/mapi/api/mobile/login/post.json?sign=" + sign + "&"
                + generateQueryString(params, true));
	}
	
	private static void register() throws IOException{
		Map<String, String> params = new HashMap<String, String>();
		params.put("mobile", "d27rgidLKc368zShGCmqlQ%3D%3D");
		params.put("password", "d27rgidLKc368zShGCmqlQ%3D%3D");
		params.put("timestamp", String.valueOf(System.currentTimeMillis()));
		params.put("version", "2.0.1");
		params.put("smsCaptchaCode", "689738");
		params.put("operateOrigin", "Android");
		params.put("recommenderCode", "");

	    String sign = ApiUtils.signTopRequest(params, Constants.SIGN_METHOD_SECRET, Constants.SIGN_METHOD_HMAC);
	    System.out.println("http://localhost:8080/mapi/api/mobile/register/post.json?sign=" + sign + "&"
                + generateQueryString(params, true));
	}
	
	private static void deposit() throws IOException{
		Map<String, String> params = new HashMap<String, String>();
		params.put("depositId", DesUtil.encryptMode("3", Constants.DES_ALGORITHM_DESEDE, Constants.DES_KEY));
		params.put("timestamp", String.valueOf(System.currentTimeMillis()));
		params.put("version", "2.2.1");
		params.put("securetKey", "v4Fsul8T1c8afUq465rttM9Daj4w794Vj3lcUQhWHHDYEZC1aNz698QTEPaNGTVK");

	    String sign = ApiUtils.signTopRequest(params, Constants.SIGN_METHOD_SECRET, Constants.SIGN_METHOD_HMAC);
	    System.out.println("http://localhost:8080/mapi/api/mobile/fastpay/investor/deposit/queryOne.json?sign=" + sign + "&"
                + generateQueryString(params, true));
	}
	
	private static void account() throws IOException{
		Map<String, String> params = new HashMap<String, String>();
		params.put("investorId", "NEhQSK5pVk4=");
		params.put("timestamp", String.valueOf(System.currentTimeMillis()));
		params.put("version", "2.2.0");
		params.put("securetKey", "wov/OPRWOWnDbdTOvXW5rQYRQYFfIcmA9khhhFbavwKCNTzLwXzhcw==");
		params.put("client", "IOS");

	    String sign = ApiUtils.signTopRequest(params, Constants.SIGN_METHOD_SECRET, Constants.SIGN_METHOD_HMAC);
	    System.out.println("http://localhost:8080/mapi/api/mobile/investor/account.json?sign=" + sign + "&"
                + generateQueryString(params, true));
	}
	
	 private static String generateQueryString(Map<String, String> params, boolean needUrlEncode) {
	        if (params == null || params.isEmpty()) {
	            return null;
	        }
	        StringBuffer buffer = new StringBuffer();
	        List<String> keys = new ArrayList<String>(params.keySet());
	        Collections.sort(keys);
	        for (String key : keys) {
	            String value = params.get(key);
	            if (needUrlEncode) {
	                value = getUtf8EscapedString(value);
	            }
	            buffer.append("&").append(key).append("=").append(value);
	        }
	        return buffer.substring(1);
	    }
	 
	 public static String getUtf8EscapedString(String input) {
	        String result = null;
	        try {
	            result = URLEncoder.encode(input, "utf8");
	        } catch (UnsupportedEncodingException e) {
	            return null;
	        }
	        return result;
	 }
	
	/**
	 * API签名
	 * @param signed
	 * @param unsign
	 * @param key
	 * @return
	 */
	public static void  verSignV3(){
		String signatureKey = "eRTqtGGyV9nTYwmUAuu8Y3iEL4XiwBSp";
		String encryptKey = "99Y9STbnnfVk28Mn";
		String content = "<userId>383784</userId>"
				+ "<biddingAmount>1300</biddingAmount>"
				+ "<projectId>4431</projectId>"
				+ "<couponId>0</couponId>";
		
		//String s_content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><request><topic><version>3.0</version><charset>UTF-8</charset><fundChannelId>YPPC</fundChannelId></topic><requestContent><userId>383784</userId><biddingAmount>1300</biddingAmount><projectId>4431</projectId><couponId>0</couponId></requestContent><signature><signatureType>MD5</signatureType><signatureData>67d60e7a8392e4838913a72aafa72b8d</signatureData></signature></request>";
		
		String requestContent = content + "signKey=" + signatureKey;
		String md5String = EncrypMD5.md5(requestContent);
		System.out.println("md5String===\n" + md5String);
		System.out.println("encrypt===\n" + AesUtil.encrypt(content,encryptKey));
		System.out.println("encrypt===\n" + AesUtil.decrypt(content,encryptKey));

	}
	
	public static void pdsSign() throws UnsupportedEncodingException{
		Map<String, String> params = new LinkedHashMap<String, String>();
		params.put("PTDealerID", "203022");
		params.put("OutOrderNo", "3967182526989671");
		params.put("TradeDate", "2016-06-17");
		params.put("Key", "8B47853AC7A7824C");
		
		String sign = DigestUtils.md5Hex(generatePdsQueryString(params, true).getBytes());
		System.out.println(sign);
		
				
	}
	
	 private static String generatePdsQueryString(Map<String, String> params, boolean needUrlEncode) {
	        if (params == null || params.isEmpty()) {
	            return null;
	        }
	        StringBuffer buffer = new StringBuffer();
	        List<String> keys = new ArrayList<String>(params.keySet());
	        for (String key : keys) {
	            String value = params.get(key);
	            System.out.println(value);
	            if (needUrlEncode) {
	                value = getGBKEscapedString(value);
	            }
	            buffer.append(value);
	            //buffer.append(key).append("=").append(value);
	        }
	        return buffer.toString();
	    }
	 
	 public static String getGBKEscapedString(String input) {
	        String result = null;
	        try {
	            result = URLEncoder.encode(input, "GBK");
	        } catch (UnsupportedEncodingException e) {
	            return null;
	        }
	        return result;
	 }
}

