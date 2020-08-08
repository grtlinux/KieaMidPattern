package org.tain;

import java.time.LocalDateTime;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.tain.utils.CurrentInfo;
import org.tain.utils.Flag;
import org.tain.utils.JsonPrint;
import org.tain.utils.Sample;
import org.tain.working.BoardWorking;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class KieaMid05Application implements CommandLineRunner {

	public static void main(String[] args) {
		log.info("KANG-20200808 >>>>> {} {}", CurrentInfo.get(), LocalDateTime.now());
		SpringApplication.run(KieaMid05Application.class, args);
	}

	@PostConstruct
	public void start() {
		if (Flag.flag) {
			TimeZone.setDefault(TimeZone.getTimeZone("UTC+9"));
			//TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
			//TimeZone.setDefault(TimeZone.getTimeZone("GMT+09:00"));
		}
	}
	
	@Override
	public void run(String... args) throws Exception {
		log.info("KANG-20200808 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) job01();  // Test
		if (Flag.flag) job02();  // Board
		if (Flag.flag) job03();
		if (Flag.flag) job04();
		if (Flag.flag) job05();
		if (Flag.flag) job06();
		if (Flag.flag) job07();
		if (Flag.flag) job08();
		if (Flag.flag) job09();
		if (Flag.flag) job10();
	}

	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
	private void job01() {
		log.info("KANG-20200808 >>>>> {} {}", CurrentInfo.get());
		JsonPrint.getInstance().printPrettyJson(Sample.getMap());
	}

	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private BoardWorking boardWorking;
	
	private void job02() {
		log.info("KANG-20200808 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) this.boardWorking.loading();
	}

	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
	private void job03() {
		log.info("KANG-20200808 >>>>> {} {}", CurrentInfo.get());
	}

	private void job04() {
		log.info("KANG-20200808 >>>>> {} {}", CurrentInfo.get());
	}

	private void job05() {
		log.info("KANG-20200808 >>>>> {} {}", CurrentInfo.get());
	}

	private void job06() {
		log.info("KANG-20200808 >>>>> {} {}", CurrentInfo.get());
	}

	private void job07() {
		log.info("KANG-20200808 >>>>> {} {}", CurrentInfo.get());
	}

	private void job08() {
		log.info("KANG-20200808 >>>>> {} {}", CurrentInfo.get());
	}

	private void job09() {
		log.info("KANG-20200808 >>>>> {} {}", CurrentInfo.get());
	}

	private void job10() {
		log.info("KANG-20200808 >>>>> {} {}", CurrentInfo.get());
	}
}
