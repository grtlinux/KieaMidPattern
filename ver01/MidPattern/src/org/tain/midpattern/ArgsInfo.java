package org.tain.midpattern;

import org.tain.utils.ArgsUtils;
import org.tain.utils.ResourcesUtils;

public class ArgsInfo {
	
	private static final boolean flag;
	
	private static final String args;
	
	private static final String DEFAULT_BASEDIR = "C:/hanwha/GIT/git/MidPattern/Shuffle01/";
	private static final String DEFAULT_DATAFILE = "03.MidPattern.txt";
	private static final long DEFAULT_WAIT_TIME = 5000;
	private static final int DEFAULT_CNT_EXAM = 10;
	
	public static String baseDir;
	public static String dataFile;
	public static int begRange;
	public static int endRange;
	public static boolean flgShuffle;
	public static boolean flgAuto;
	public static boolean flgExam;
	public static long waitTime = DEFAULT_WAIT_TIME;
	public static int cntExam = DEFAULT_CNT_EXAM;
	
	static {
		flag = true;
		
		args = ResourcesUtils.getString("org.tain.midpattern.args");
		
		try {
			String[] arrArgs = args.split("\\s");
			ArgsUtils.setParams(arrArgs);
			
			baseDir = ArgsUtils.getValue("-basedir", DEFAULT_BASEDIR);
			dataFile = ArgsUtils.getValue("-datafile", DEFAULT_DATAFILE);
			begRange = Integer.valueOf(ArgsUtils.getValue("-range", 0)) - 1;
			endRange = Integer.valueOf(ArgsUtils.getValue("-range", 1));
			flgShuffle = ArgsUtils.hasKey("-shuffle");
			flgAuto = ArgsUtils.hasKey("-auto");
			if (flgAuto)
				waitTime = Long.valueOf(ArgsUtils.getValue("-auto", 0)) * 1000;
			flgExam = ArgsUtils.hasKey("-exam");
			if (flgExam)
				cntExam = Integer.valueOf(ArgsUtils.getValue("-exam", 0));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	public static void setArgs(String[] args) {
		try {
			ArgsUtils.setParams(args);
			
			baseDir = ArgsUtils.getValue("-basedir", DEFAULT_BASEDIR);
			dataFile = ArgsUtils.getValue("-datafile", DEFAULT_DATAFILE);
			begRange = Integer.valueOf(ArgsUtils.getValue("-range", 0)) - 1;
			endRange = Integer.valueOf(ArgsUtils.getValue("-range", 1));
			flgShuffle = ArgsUtils.hasKey("-shuffle");
			flgAuto = ArgsUtils.hasKey("-auto");
			if (flgAuto)
				waitTime = Long.valueOf(ArgsUtils.getValue("-auto", 0)) * 1000;
			flgExam = ArgsUtils.hasKey("-exam");
			if (flgExam)
				cntExam = Integer.valueOf(ArgsUtils.getValue("-exam", 0));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public static void printInfo() {
		if (flag) {
			System.out.println(">>>>> ArgsInfo.baseDir    = " + ArgsInfo.baseDir);
			System.out.println(">>>>> ArgsInfo.dataFile   = " + ArgsInfo.dataFile);
			System.out.println(">>>>> ArgsInfo.begRange   = " + ArgsInfo.begRange);
			System.out.println(">>>>> ArgsInfo.endRange   = " + ArgsInfo.endRange);
			System.out.println(">>>>> ArgsInfo.flgShuffle = " + ArgsInfo.flgShuffle);
			System.out.println(">>>>> ArgsInfo.flgAuto    = " + ArgsInfo.flgAuto);
			System.out.println(">>>>> ArgsInfo.waitTime   = " + ArgsInfo.waitTime);
			System.out.println(">>>>> ArgsInfo.flgExam    = " + ArgsInfo.flgExam);
			System.out.println(">>>>> ArgsInfo.cntExam    = " + ArgsInfo.cntExam);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) throws Exception {
		
		if (flag) {
			args = new String[] {
					"-range", "123", "155",
			};
		}
		ArgsInfo.setArgs(args);
		
		ArgsInfo.printInfo();
	}
}
