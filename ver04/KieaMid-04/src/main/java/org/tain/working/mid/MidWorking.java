package org.tain.working.mid;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.tain.domain.mid.Comp;
import org.tain.domain.mid.Division;
import org.tain.repository.mid.CompRepository;
import org.tain.repository.mid.DivisionRepository;
import org.tain.utils.CurrentInfo;
import org.tain.utils.Flag;
import org.tain.utils.JsonPrint;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MidWorking {

	@Autowired
	private DivisionRepository divisionRepository;
	
	@Autowired
	private CompRepository compRepository;
	
	@Value("${file.origin-json.mid}")
	private String fileOriginJsonMid;
	
	public void loading() {
		log.info("KANG-20200803 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) {
			BufferedReader br = null;
			String line = null;
			try {
				br = new BufferedReader(new FileReader(this.fileOriginJsonMid));
				
				String code = null;
				Division division = null;
				
				List<Comp> lstComp = new ArrayList<>();
				int idx = -1;
				Long compId = 0L;
				
				while ((line = br.readLine()) != null) {
					if (!Flag.flag) System.out.println(">>>>> " + line);
					switch (line.charAt(0)) {
					case ' ':
					case '\t':
						// comp
						int quotient = idx / 4;
						int remainder = idx % 4;
						if (quotient == 0) {
							lstComp.add(Comp.builder()
									.id(++ compId)
									.code(code)
									.idx(remainder)
									.stmtKr(line.trim())
									.division(division)
									.build());
						} else {
							lstComp.get(remainder).setStmtEn(line.trim());
						}
						idx ++;
						break;
					default:
						// save comp
						if (!Flag.flag) System.out.println("Comp: >>>>> " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(lstComp));
						lstComp.forEach(entity -> {
							this.compRepository.save(entity);
						});
						idx = 0;
						lstComp.clear();
						
						// save division
						code = line.substring(0, 3);
						String[] items = line.substring(4).split(":");
						String title = items[0].trim();
						String content = items[1].trim();
						division = this.divisionRepository.save(Division.builder()
								.code(code)
								.title(title)
								.content(content)
								.build());
						if (!Flag.flag) System.out.println("Division: >>>>> " + JsonPrint.getInstance().toPrettyJson(division));
						break;
					}
				}
				if (!Flag.flag) System.out.println("Comp: >>>>> " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(lstComp));
				lstComp.forEach(entity -> {
					this.compRepository.save(entity);
				});
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (br != null) try { br.close(); } catch (Exception e) {}
			}
		}
	}
}
