package org.tain.working;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.domain.chun.Grp;
import org.tain.domain.chun.Sentence;
import org.tain.domain.chun.Tip;
import org.tain.repository.chun.GrpRepository;
import org.tain.repository.chun.SentenceRepository;
import org.tain.repository.chun.TipRepository;
import org.tain.utils.CurrentInfo;
import org.tain.utils.Flag;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Chun {

	@Autowired
	private GrpRepository grpRepositor;
	
	@Autowired
	private SentenceRepository sentenceRepository;
	
	@Autowired
	private TipRepository tipRepository;
	
	public void loading() {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) {
			// text -> table
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader("src/main/resources/json/org_1000.txt"));
				String line = null;
				Integer grpNo = -1;
				Grp grp = null;
				Integer sentNo = -1;
				String sentEn = null;
				Sentence sentence = null;
				while ((line = br.readLine()) != null) {
					line = line.trim();
					if ("".equals(line))
						continue;
					
					if (!Flag.flag) System.out.println(">>>>> " + line);
					
					String division = line.substring(0, 2);
					if ("--".equals(division)) {
						line = line.replaceAll("-----", "").trim();
						if (Character.isDigit(line.charAt(0))) {
							// grp
							if (!Flag.flag) System.out.println("Grp ===== " + line);
							String[] items = line.split("\\.");
							grpNo = Integer.parseInt(items[0].trim());
							grp = this.grpRepositor.save(Grp.builder()
									.no(grpNo)
									.name(items[1].trim())
									.build());
						} else {
							// tip
							if (!Flag.flag) System.out.println("Tip ===== " + line);
							this.tipRepository.save(Tip.builder()
									.content(line)
									.sentence(sentence)
									.build());
						}
					} else {
						if (!Flag.flag) System.out.println("Sentence >>>>> " + line);
						if (Character.isDigit(line.charAt(0))) {
							String[] items = line.split("\\.");
							sentNo = Integer.parseInt(items[0].trim());
							sentEn = items[1].trim();
						} else {
							sentence = this.sentenceRepository.save(Sentence.builder()
									.no(sentNo)
									.sentEn(sentEn)
									.sentKr(line)
									.grp(grp)
									.build());
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (br != null) try { br.close(); } catch (Exception e) {}
			}
		}
	}
	
	public void getPage() {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) {
			// getPage
			this.sentenceRepository.getAll().forEach(entity -> {
				System.out.println(">>>>> " + Arrays.asList(entity));
			});
		}
	}
	
	public void saving() {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) {
			// table -> jsonFile
		}
	}
}
