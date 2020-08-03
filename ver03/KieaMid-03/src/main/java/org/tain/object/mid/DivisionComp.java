package org.tain.object.mid;

import org.tain.utils.CurrentInfo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@Slf4j
public class DivisionComp {

	private String divCode;
	
	private String divTitle;
	
	private String divContent;
	
	private Long compId;
	
	private Integer compIdx;
	
	private String compStmtKr;
	
	private String compStmtEn;
	
	@Builder
	public DivisionComp(
			String divCode,
			String divTitle,
			String divContent,
			Long compId,
			Integer compIdx,
			String compStmtKr,
			String compStmtEn
			) {
		this.divCode = divCode;
		this.divTitle = divTitle;
		this.divContent = divContent;
		this.compId = compId;
		this.compIdx = compIdx;
		this.compStmtKr = compStmtKr;
		this.compStmtEn = compStmtEn;
	}
	
	////////////////////////////////////////////////////////////////////////
	
	public String toJson() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.registerModule(new JavaTimeModule());
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return objectMapper.writeValueAsString(this);
		} catch (Exception e) {
			log.info("ERROR[{}]: {}", CurrentInfo.get(), e.getMessage());
		}
		return "{}";
	}
	
	public String toPrettyJson() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.registerModule(new JavaTimeModule());
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (Exception e) {
			log.info("ERROR[{}]: {}", CurrentInfo.get(), e.getMessage());
		}
		return "{}";
	}
}