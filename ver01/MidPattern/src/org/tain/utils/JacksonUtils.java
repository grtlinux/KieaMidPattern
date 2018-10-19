package org.tain.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class JacksonUtils {

	private static final boolean flag;
	private static final Logger log;
	
	static {
		flag = true;
		log = LoggerFactory.getLogger(JacksonUtils.class);
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	public static JSONObject getJsonObject(String strJson) {
		return new JSONObject(strJson);
	}
	
	public static String getStrFromJsonObject(JSONObject jsonObject) {
		return getStrFromJsonObject(jsonObject, 0);
	}
	
	public static String getStrFromJsonObject(JSONObject jsonObject, int indent) {
		return jsonObject.toString(indent);
	}
	
	public static JSONArray getJsonArray(String strJson) {
		return new JSONArray(strJson);
	}
	
	public static String getStrFromJsonArray(JSONArray jsonArray) {
		return getStrFromJsonArray(jsonArray, 0);
	}
	
	public static String getStrFromJsonArray(JSONArray jsonArray, int indent) {
		return jsonArray.toString(indent);
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) throws Exception {
		if (flag) log.info("INFO: >>>>> {}", ClassUtils.getFileLine());
		
		if (flag) test01(args);
	}
	
	private static void test01(String[] args) throws Exception {
		if (flag) log.info("INFO: >>>>> {}", ClassUtils.getFileLine());
		
		if (flag) {
			String strJson = "{ 'id': 123, 'name': 'Kiea', 'age': 30, 'addr': 'Seoul' }";
			JSONObject jsonObject = new JSONObject(strJson);
			String strJsonObject = jsonObject.toString(2);
			if (flag) System.out.println(">>>>> " + strJsonObject);
			
			Long id = jsonObject.has("id") ? jsonObject.getLong("id") : null;
			String name = jsonObject.has("name") ? jsonObject.getString("name") : null;
			Integer age = jsonObject.has("age") ? jsonObject.getInt("age") : null;
			String addr = jsonObject.has("addr") ? jsonObject.getString("addr") : null;
			String content = jsonObject.has("content") ? jsonObject.getString("content") : null;
			if (flag) System.out.printf(">>>>> [%s] [%s] [%s] [%s] [%s]%n", id, name, age, addr, content);
		}
	}
}
