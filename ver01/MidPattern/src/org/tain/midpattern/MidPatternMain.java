package org.tain.midpattern;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tain.utils.ClassUtils;
import org.tain.utils.ResourcesUtils;

public class MidPatternMain {

	private static final boolean flag;
	private static final Logger log;
	
	static {
		flag = true;
		log = LoggerFactory.getLogger(new Object(){}.getClass().getEnclosingClass());
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	
	///////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) throws Exception {
		if (flag) log.info("INFO: >>>>> {}", ClassUtils.getFileLine());
		
		if (!flag) {
			args = new String[] {
					"-range", "123", "155",
			};
		}
		
		if (flag) new ResourcesUtils();
		if (flag) ArgsInfo.setArgs(args);
		if (flag) ArgsInfo.printInfo();
		
		if (flag) test01(args);
	}
	
	private static void test01(String[] args) throws Exception {
		if (flag) log.info("INFO: >>>>> {}", ClassUtils.getFileLine());
		if (flag) log.info("INFO: >>>>> {}, args = {}", ClassUtils.getFileLine(), Arrays.asList(args));
		
		if (flag) new ShuffleList().process();
	}
}
