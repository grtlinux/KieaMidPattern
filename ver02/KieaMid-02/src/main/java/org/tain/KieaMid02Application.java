package org.tain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.tain.domain.Comp;
import org.tain.domain.Division;
import org.tain.repository.CompRepository;
import org.tain.repository.DivisionRepository;
import org.tain.utils.CurrentInfo;
import org.tain.utils.Flag;

import com.fasterxml.jackson.databind.ObjectMapper;

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

	@Autowired
	private DivisionRepository divisionRepository;
	
	@Autowired
	private CompRepository compRepository;
	
	private void job01() {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) {
			// text -> table
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader("src/main/resources/json/org_mid.txt"));
				String line = null;
				String code = null;
				int idx = -1;
				List<Comp> lstComp = new ArrayList<>();
				while ((line = br.readLine()) != null) {
					if (!Flag.flag) System.out.println(">>>>> " + line);
					switch (line.charAt(0)) {
					case ' ':
					case '\t':
						// makeComp(line, idx);
						int quotient = idx / 4;
						int remainder = idx % 4;
						if (quotient == 0) {
							Comp comp = Comp.builder()
									.code(code)
									.idx(remainder)
									.stmtKr(line.trim())
									.build();
							lstComp.add(comp);
						} else {
							lstComp.get(remainder).setStmtEn(line.trim());
						}
						idx ++;
						break;
					default:
						//makeDivision(line);
						code = line.substring(0, 3);
						String[] stmt = line.substring(4).split(":");
						String title = stmt[0].trim();
						String content = stmt[1].trim();
						Division division = Division.builder()
								.code(code)
								.title(title)
								.content(content)
								.build();
						
						if (Flag.flag) System.out.println("Division: >>>>> " + division.toPrettyJson());
						if (Flag.flag) System.out.println("Comp: >>>>> " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(lstComp));
						
						this.divisionRepository.save(division);
						lstComp.forEach(entity -> {
							this.compRepository.save(entity);
						});
						
						idx = 0;
						lstComp.clear();
						break;
					}
				}
				lstComp.forEach(entity -> {
					this.compRepository.save(entity);
				});
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (br != null) try { br.close(); } catch (Exception e) {}
			}
		}
		
		if (Flag.flag) {
			// table -> jsonFile
		}
	}

	private void job02() {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
	}

	private void job03() {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
	}

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
