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
		if (flag) log.info("INFO: '{}'", ClassUtils.getClassInfo());
		
		if (flag) test01(args);
	}
	
	private static void test01(String[] args) throws Exception {
		if (flag) log.debug("DEBUG: '{}'", ClassUtils.getClassInfo());
		
		if (flag) {
			
		}
	}
}
