package org.tain;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.tain.utils.CurrentInfo;
import org.tain.utils.Flag;
import org.tain.utils.JsonPrint;
import org.tain.utils.LnsTimeZone;
import org.tain.utils.Sample;
import org.tain.working.board.BoardWorking;
import org.tain.working.mid.MidWorking;
import org.tain.working.word.WordWorking;

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
		log.info("KANG-20200808 >>>>> {} {}", CurrentInfo.get());
		
		// TO application.yml: spring.jpa.properties.hibernate.jdbc.time_zone: UTC+9
		if (Flag.flag) LnsTimeZone.setTimeZone("UTC+9");
	}
	
	@Override
	public void run(String... args) throws Exception {
		log.info("KANG-20200808 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) job01();  // Test
		if (Flag.flag) job02();  // Board
		if (Flag.flag) job03();  // Word
		if (Flag.flag) job04();  // Mid
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

	@Autowired
	private WordWorking wordWorking;
	
	private void job03() {
		log.info("KANG-20200808 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) this.wordWorking.loading();
		if (Flag.flag) this.wordWorking.saveJsonFile();
		if (!Flag.flag) this.wordWorking.loadingFromJsonFile();
	}

	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private MidWorking midWorking;
	
	private void job04() {
		log.info("KANG-20200808 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) this.midWorking.loading();
		if (!Flag.flag) this.midWorking.getAll();
		if (Flag.flag) this.midWorking.saveJsonFile();
		if (Flag.flag) this.midWorking.getById();
	}

	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
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
