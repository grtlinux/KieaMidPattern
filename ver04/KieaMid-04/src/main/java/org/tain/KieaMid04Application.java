package org.tain;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
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
import org.tain.working.board.BoardWorking;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class KieaMid04Application implements CommandLineRunner {

	public static void main(String[] args) {
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get(), LocalDateTime.now());
		SpringApplication.run(KieaMid04Application.class, args);
	}

	@PostConstruct
	public void start() {
		if (!Flag.flag) {
			TimeZone.setDefault(TimeZone.getTimeZone("UTC+9"));
			//TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
			//TimeZone.setDefault(TimeZone.getTimeZone("GMT+09:00"));
		}
	}
	
	@Override
	public void run(String... args) throws Exception {
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) job01();
		if (Flag.flag) job02();
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
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get());
		
		Map<String,Object> map = new HashMap<>();
		map.put("name", "Kiea 강석");
		map.put("date", LocalDateTime.now());
		map.put("message", "Hello, world!!!");
		
		JsonPrint.getInstance().printPrettyJson(map);
	}

	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private BoardWorking boardWorking;
	
	private void job02() {
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) this.boardWorking.loading();
		if (!Flag.flag) this.boardWorking.fetching();
		if (!Flag.flag) this.boardWorking.testBoardInfoSome();
		if (!Flag.flag) this.boardWorking.saveJsonFile();
		if (!Flag.flag) this.boardWorking.loadJsonFile();
	}

	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
	private void job03() {
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get());
	}

	private void job04() {
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get());
	}

	private void job05() {
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get());
	}
	
	private void job06() {
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get());
	}

	private void job07() {
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get());
	}

	private void job08() {
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get());
	}
	
	private void job09() {
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get());
	}

	private void job10() {
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get());
	}
}
