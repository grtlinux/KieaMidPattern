package org.tain;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.tain.utils.CurrentInfo;
import org.tain.utils.Flag;
import org.tain.working.Chun;
import org.tain.working.Mid;
import org.tain.working.WordMean;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class KieaMid02Application implements CommandLineRunner {

	public static void main(String[] args) {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get(), LocalDateTime.now());
		SpringApplication.run(KieaMid02Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
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
	
	@Autowired
	private Mid mid;
	
	private void job01() {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) this.mid.loading();
		if (Flag.flag) this.mid.getPage();
	}

	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private Chun chun;
	
	private void job02() {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
		
		if (!Flag.flag) this.chun.loading();
		if (!Flag.flag) this.chun.getPage();
	}

	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private WordMean wordMean;
	
	private void job03() {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
		
		if (!Flag.flag) this.wordMean.loading();
	}

	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
	private void job04() {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
	}

	private void job05() {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
	}

	private void job06() {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
	}

	private void job07() {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
	}

	private void job08() {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
	}

	private void job09() {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
	}

	private void job10() {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
	}
}
