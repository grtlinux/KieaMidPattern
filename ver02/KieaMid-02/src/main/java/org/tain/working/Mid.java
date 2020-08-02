package org.tain.working;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.domain.mid.Comp;
import org.tain.domain.mid.Division;
import org.tain.repository.mid.CompRepository;
import org.tain.repository.mid.DivisionRepository;
import org.tain.utils.CurrentInfo;
import org.tain.utils.Flag;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Mid {

	@Autowired
	private DivisionRepository divisionRepository;
	
	@Autowired
	private CompRepository compRepository;
	
	public void loading() {
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
	}
	
	public void saving() {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) {
			// table -> jsonFile
		}
	}
}
