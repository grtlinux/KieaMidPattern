package org.tain.working.chun;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.tain.domain.chun.Grp;
import org.tain.domain.chun.Sent;
import org.tain.domain.chun.Tip;
import org.tain.repository.chun.GrpRepository;
import org.tain.repository.chun.SentRepository;
import org.tain.repository.chun.TipRepository;
import org.tain.utils.CurrentInfo;
import org.tain.utils.Flag;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ChunWorking {

	@Autowired
	private GrpRepository grpRepository;
	
	@Autowired
	private SentRepository sentRepository;
	
	@Autowired
	private TipRepository tipRepository;
	
	@Value("${file.origin-json.chun}")
	private String fileOriginJsonChun;
	
	public void loading() {
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) {
			// text -> table
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(this.fileOriginJsonChun));
				String line = null;
				
				Grp grp = null;
				Sent sent = null;
				
				Integer grpNo = -1;
				Integer sentNo = -1;
				String sentEn = null;
				
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
							grp = this.grpRepository.save(Grp.builder()
									.no(grpNo)
									.name(items[1].trim())
									.build());
						} else {
							// tip
							if (!Flag.flag) System.out.println("Tip ===== " + line);
							this.tipRepository.save(Tip.builder()
									.content(line)
									.sent(sent)
									.build());
						}
					} else {
						if (!Flag.flag) System.out.println("Sentence >>>>> " + line);
						if (Character.isDigit(line.charAt(0))) {
							String[] items = line.split("\\.");
							sentNo = Integer.parseInt(items[0].trim());
							sentEn = items[1].trim();
						} else {
							sent = this.sentRepository.save(Sent.builder()
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
}
