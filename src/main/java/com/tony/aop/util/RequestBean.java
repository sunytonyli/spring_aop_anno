package com.tony.aop.util;

import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 数据请求
 * @author Tony
 * @createDatime 2015-2-18 上午8:36:07
 */

public class RequestBean {

	private static final Logger logger = LoggerFactory.getLogger(RequestBean.class);
	
	/**
	 * post 请求
	 * @param requestUri
	 * @param jsonObj
	 * @return
	 * @throws IOException
	 */
	public static JSONObject sentPostJson(String requestUrl, JSONObject jsonObj) throws IOException {
		//请求URL
		String encoding = "UTF-8";
		HttpPost httpPost = new HttpPost(requestUrl);
		StringEntity postEntity = new StringEntity(jsonObj.toString(), encoding);
		postEntity.setContentType("application/json;charset=utf-8");
		httpPost.setEntity(postEntity);
		//发送请求
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpPost);
		} catch (ClientProtocolException e) {
			logger.error("协议错误 requetUri:{}", requestUrl);
		} catch (IOException e) {
			logger.error("网络异常 requetUri:{}", requestUrl);
		}
		
		if(response == null){
			return new JSONObject();
		}
		
		//响应内容
		String responseBody = "";
		try {
			//获取响应码  
			//System.out.println(response.getStatusLine());
			//获取响应内容 
		    HttpEntity entity = response.getEntity();
		    responseBody = EntityUtils.toString(response.getEntity(), encoding);
		    EntityUtils.consume(entity);
		} catch (ParseException e) {
			logger.error("ParseException requetUri:{}", requestUrl);
		} catch (IOException e) {
			logger.error("IOException requetUri:{}", requestUrl);
		} finally {
		    response.close();
		}
		return JSONObject.fromObject(responseBody);
	}
	
	/**
	 * get 请求
	 * @param requestUri
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static JSONObject sentGet(String requestUrl) throws ClientProtocolException, IOException{
		//请求URL
		String encoding = "UTF-8";
		HttpGet httpGet = new HttpGet(requestUrl);
		//发送请求
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = httpclient.execute(httpGet);
		
		//响应内容
		String responseBody = "";
		try {
		    HttpEntity entity = response.getEntity();
		    responseBody = EntityUtils.toString(response.getEntity(), encoding);
		    EntityUtils.consume(entity);
		} finally {
			response.close();
		}
		return JSONObject.fromObject(responseBody);
	}
	
	public static JSONObject getHeadJSONObject(JSONObject jsonobj){
		JSONObject jsonObject = jsonobj.getJSONObject("head");
		return jsonObject;
	}
	
	public static JSONObject getBodyJSONObject(JSONObject jsonobj){
		JSONObject jsonObject = jsonobj.getJSONObject("body");
		return jsonObject;
	}
	
	public static JSONArray getBodyJSONArrat(JSONObject jsonobj){
		JSONArray jsonArray = jsonobj.getJSONArray("body");
		return jsonArray;
	}
	
	public static JSONObject headJSONObject(int succ , int flag){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", succ);
		jsonObject.put("flag", flag);
		return jsonObject;
	}
	
}
