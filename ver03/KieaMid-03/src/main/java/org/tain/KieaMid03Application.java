package org.tain;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.tain.utils.CurrentInfo;
import org.tain.utils.Flag;
import org.tain.working.BoardWorking;
import org.tain.working.ChunWorking;
import org.tain.working.MidWorking;
import org.tain.working.WordWorking;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class KieaMid03Application implements CommandLineRunner {

	public static void main(String[] args) {
		log.info("KANG-20200803 >>>>> {} {}", CurrentInfo.get(), LocalDateTime.now());
		SpringApplication.run(KieaMid03Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("KANG-20200803 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) job01();
		if (Flag.flag) job02();
		if (Flag.flag) job03();
		if (Flag.flag) job04();
		if (Flag.flag) job05();
	}

	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private BoardWorking boardWorking;
	
	private void job01() {
		log.info("KANG-20200803 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) this.boardWorking.loading();
		if (!Flag.flag) this.boardWorking.selecting();
	}

	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private MidWorking midWorking;
	
	private void job02() {
		log.info("KANG-20200803 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) this.midWorking.loading();
		if (!Flag.flag) this.midWorking.getAll();
		if (!Flag.flag) this.midWorking.getPage();
		if (!Flag.flag) this.midWorking.selecting();
	}

	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private ChunWorking chunWorking;
	
	private void job03() {
		log.info("KANG-20200803 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) this.chunWorking.loading();
		if (!Flag.flag) this.chunWorking.getAll();
		if (!Flag.flag) this.chunWorking.getPage();
		if (!Flag.flag) this.chunWorking.selecting();
	}

	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private WordWorking wordWorking;
	
	private void job04() {
		log.info("KANG-20200803 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) this.wordWorking.loading();
		if (Flag.flag) this.wordWorking.getAll();
		if (Flag.flag) this.wordWorking.getPage();
		if (!Flag.flag) this.wordWorking.selecting();
	}

	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
	private void job05() {
		log.info("KANG-20200803 >>>>> {} {}", CurrentInfo.get());
	}
}
