package org.tain.test;

import org.json.JSONObject;
import org.tain.utils.ClassUtils;

public class JacksonTestMain {

	private static final boolean flag;
	
	static {
		flag = true;
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtils.getClassInfo());
		
		if (flag) test01(args);
	}
	
	private static void test01(String[] args) throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtils.getClassInfo());
		
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
