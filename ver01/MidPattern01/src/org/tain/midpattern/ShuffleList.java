package org.tain.midpattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tain.utils.ClassUtils;

public class ShuffleList {

	private static final boolean flag;
	private static final Logger log;
	
	private String dataFileName;
	
	static {
		flag = true;
		log = LoggerFactory.getLogger(new Object(){}.getClass().getEnclosingClass());
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	public ShuffleList() {
		this.dataFileName = ArgsInfo.baseDir + ArgsInfo.dataFile;
	}
	
	public void process() throws Exception {
		List<Pattern> listAll = null;
		List<Pattern> list = null;

		// scanner
		Scanner scanner = new Scanner(System.in);

		if (flag) {
			// listAll
			System.out.printf("##### data file : [%s] [%s]%n", ArgsInfo.baseDir, ArgsInfo.dataFile);

			listAll = getListAll();
		}

		if (flag) {
			// list
			ArgsInfo.endRange = Math.min(ArgsInfo.endRange, listAll.size());

			System.out.printf("##### range (%d ~ %d)%n", ArgsInfo.begRange + 1, ArgsInfo.endRange);

			list = listAll.subList(ArgsInfo.begRange, ArgsInfo.endRange);

			if (!flag) {
				// confirm print
				System.out.println("##### print list sequence");
				for (Pattern pattern : list) {
					System.out.printf(">>>>>>>>>> %s%n", pattern);
				}
			}
		}

		if (flag) {
			// shuffle
			if (ArgsInfo.flgShuffle) {
				long randShuffle = new Date().getTime();

				System.out.printf("##### shuffle list. randShuffle = %d%n", randShuffle);

				Collections.shuffle(list, new Random(randShuffle));
			}
		}

		if (flag) {
			// question
			System.out.printf("##### QUESTION %n");

			for (Pattern pattern : list) {

				System.out.printf("%n%s) %-40s (%s) ...."
						, pattern.getSeq()
						, pattern.getPattern()
						, pattern.getMeaning()
						);

				if (ArgsInfo.flgAuto) {
					try { Thread.sleep(ArgsInfo.waitTime); } catch (InterruptedException e) {}
					System.out.println();
				} else {
					scanner.nextLine();
				}

				if (ArgsInfo.flgExam) {
					List<String> examples = pattern.getExamples();
					for (int i=0; i < ArgsInfo.cntExam && i < examples.size(); i++) {
						System.out.printf("\t\t\t(%d) %s%n", i, examples.get(i));
					}
				}
			}
		}

		scanner.close();
	}
	
	private List<Pattern> getListAll() throws Exception {
		List<Pattern> listAll = new ArrayList<Pattern>();

		InputStream inputStream = null;
		
		if (flag) {
			// check system or jar
			File file = new File(this.dataFileName);
			if (file.exists()) {
				// system file
				inputStream = new FileInputStream(this.dataFileName);
			} else {
				// jar file
				//inputStream = this.getClass().getResourceAsStream(this.dataFileName);
				inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(this.dataFileName);
			}
		}
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
		String line;
		Pattern pattern;

		while ((line = bufferedReader.readLine()) != null) {
			if (!flag) System.out.println(">>>>> " + line);

			try {
				pattern = new Pattern(line);
			} catch (Exception e) {
				continue;
			}

			if (!flag) System.out.println(">>>>> " + pattern);

			listAll.add(pattern);
		}

		bufferedReader.close();

		return listAll;
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) throws Exception {
		if (flag) log.info("INFO: >>>>> {}", ClassUtils.getFileLine());
		
		if (flag) run01(args);
		if (!flag) test02(args);
	}
	
	private static void run01(String[] args) throws Exception {
		if (flag) log.info("INFO: >>>>> {}", ClassUtils.getFileLine());
		
		if (flag) new ShuffleList().process();
	}
	
	private static void test02(String[] args) throws Exception {
		if (flag) log.info("INFO: >>>>> {}", ClassUtils.getFileLine());
		
		if (flag) {
			InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("data/03.MidPattern.txt");
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			String line;
			Pattern pattern;

			while ((line = bufferedReader.readLine()) != null) {
				if (flag) System.out.println(">>>>> line: " + line);

				try {
					pattern = new Pattern(line);
				} catch (Exception e) {
					continue;
				}

				if (flag) System.out.println(">>>>> pattern: " + pattern);
			}
			
			bufferedReader.close();
			inputStream.close();
		}
	}
}
