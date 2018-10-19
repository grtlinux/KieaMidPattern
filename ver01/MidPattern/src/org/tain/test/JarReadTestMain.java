package org.tain.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JarReadTestMain {

	private static final boolean flag;
	
	static {
		flag = true;
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) throws Exception {
		
		if (flag) test01(args);
		if (flag) test02(args);
	}
	
	private static void test01(String[] args) throws Exception {
		String fileName = "/data/03.MidPattern.txt";
		
		if (flag) {
			File file = new File(fileName);
			if (file.exists()) {
				if (flag) System.out.printf(">>>>> [%s] file exists.%n", file.getAbsoluteFile());
			} else {
				if (flag) System.out.printf(">>>>> [%s] file doesn't exists.%n", file.getAbsoluteFile());
			}
		}
		
		if (flag) {
			try {
				FileInputStream fileInputStream = new FileInputStream(fileName);
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					if (flag) System.out.println(">>>>> " + line);
				}
				fileInputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		if (flag) {
			try {
				//InputStream inputStream = new Object() {}.getClass().getEnclosingClass().getResourceAsStream("/data/03.MidPattern.txt");
				InputStream inputStream = JarReadTestMain.class.getResourceAsStream(fileName);
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					if (flag) System.out.println(">>>>> " + line);
				}
				inputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void test02(String[] args) throws Exception {
		//ClassPathResource resource = new ClassPathResource("03.MidPattern.txt");
	}
}
