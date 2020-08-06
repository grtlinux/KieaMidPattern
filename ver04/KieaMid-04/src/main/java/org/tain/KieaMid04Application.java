package org.tain;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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

	@Override
	public void run(String... args) throws Exception {
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) job01();
		if (Flag.flag) job02();
		if (Flag.flag) job03();
		if (Flag.flag) job04();
		if (Flag.flag) job05();
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
		if (Flag.flag) this.boardWorking.fetching();
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
}
