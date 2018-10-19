package org.tain.utils;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArgsUtils {

	private static final boolean flag;
	private static final Logger log;
	
	private static JSONObject jsonParams;

	static {
		flag = true;
		log = LoggerFactory.getLogger(new Object(){}.getClass().getEnclosingClass());
		jsonParams = new JSONObject();
	}

	///////////////////////////////////////////////////////////////////////////

	public static void setParams(String[] args) throws Exception {
		JSONArray jsonArray = null;
		
		for (String arg : args) {
			if (arg.charAt(0) == '-') {
				if (arg.length() < 2) {
					throw new IllegalArgumentException("Error at argument " + arg);
				}
				jsonArray = new JSONArray();
				jsonParams.put(arg, jsonArray);
			} else if (jsonArray != null) {
				jsonArray.put(arg);
			} else {
				throw new IllegalArgumentException("Illegal parameter usage.");
			}
		}
	}
	
	public static boolean hasKey(String key) {
		if (jsonParams.has(key))
			return true;
		else
			return false;
	}

	public static Map<String, Object> toMap() {
		return jsonParams.toMap();
	}
	
	public static void remove(String key) {
		jsonParams.remove(key);
	}
	
	public static JSONArray getValues(String key) {
		if (hasKey(key))
			return jsonParams.getJSONArray(key);
		
		return null;
	}
	
	public static String getValue(String key, int idx) throws Exception {
		if (!hasKey(key))
			return null;
		
		JSONArray jsonArray = getValues(key);
		int size = jsonArray.length();
		if (idx < 0 || size <= idx)
			throw new IllegalArgumentException("Illegal index : " + idx);
		
		return String.valueOf(jsonArray.get(idx));
	}
	
	public static String getValue(String key, String defValue) throws Exception {
		String ret;
		try {
			ret = getValue(key, 0);
			if (ret == null)
				ret = defValue;
		} catch (Exception e) {
			ret = defValue;
		}
		
		return ret;
	}
	
	public static String toString(int indent) {
		return jsonParams.toString(indent);
	}
	
	///////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) throws Exception {
		if (flag) log.info("INFO: >>>>> {}", ClassUtils.getFileLine());
		
		if (flag) test01(args);
	}
	
	private static void test01(String[] args) throws Exception {
		if (flag) log.info("INFO: >>>>> {}", ClassUtils.getFileLine());
		
		if (flag) {
			if (flag) {
				args = new String[] {
						"-basedir", "./",
						"-datafile", "03.MidPattern.txt",

						"-range", "001", "050",
						"-range", "050", "100",
						"-range", "100", "150",
						"-range", "150", "200",

						"-range", "100", "200",    // 2
						//"-range", "001", "100",    // 1
						//"-range", "001", "200",    // 0

						"--shuffle",
						"--auto", "1",
						"-exam", "1",
				};
			}

			ArgsUtils.setParams(args);
			if (flag) log.info("INFO: >>>>> {}", ArgsUtils.toString(2));
			
			if (flag) {
				args = new String[] {
						"-range", "001", "200",    // 2
						"-basedir", "basedir/basedir",
						"--shuffle", "false",
						"--auto", "1",
						"-exam", "1",
						"-time", "TimeOut",
				};
			}
			ArgsUtils.setParams(args);
			if (flag) log.info("INFO: >>>>> {}", ArgsUtils.toString(2));
		}
	}
}
