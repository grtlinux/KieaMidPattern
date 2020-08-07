package org.tain.working.chun;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

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
import org.tain.utils.JsonPrint;

import com.fasterxml.jackson.core.type.TypeReference;

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
	
	@Value("${file.from.chun}")
	private String fileFromChun;
	
	@Value("${file.to.chun}")
	private String fileToChun;
	
	public void loading() {
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) {
			// text -> table
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(this.fileFromChun));
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
	
	@Value("${file.to.grp}")
	private String fileToGrp;
	
	@Value("${file.to.sent}")
	private String fileToSent;
	
	@Value("${file.to.tip}")
	private String fileToTip;
	
	public void saveJsonFile() {
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) {
			// grp to json file
			List<Grp> lstGrp = this.grpRepository.findAll();
			JsonPrint.getInstance().savePrettyJson(new File(this.fileToGrp), lstGrp);
		}
		
		if (Flag.flag) {
			// sent to json file
			// TODO: include sub tables, to grp(no)
			List<Sent> lstSent = this.sentRepository.findAll();
			JsonPrint.getInstance().savePrettyJson(new File(this.fileToSent), lstSent);
		}
		
		if (Flag.flag) {
			// tip to json file
			// TODO: include sub tables, to sent(no)
			List<Tip> lstTip = this.tipRepository.findAll();
			JsonPrint.getInstance().savePrettyJson(new File(this.fileToTip), lstTip);
		}
		
		if (!Flag.flag) System.exit(0);
	}
	
	public void loadFromJsonFile() {
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get());
		
		if (!Flag.flag) {
			// grp to json file
			try {
				List<Grp> lstGrp = JsonPrint.getInstance().getObjectMapper()
						.readValue(new File(this.fileToGrp), new TypeReference<List<Grp>>() {});
				this.grpRepository.deleteAll();
				this.grpRepository.saveAll(lstGrp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (Flag.flag) {
			// sent to json file
		}
		
		if (Flag.flag) {
			// tip to json file
		}
		
		if (!Flag.flag) System.exit(0);
	}
}
