package org.tain.object.chun;

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
public class GrpSentence {

	private Integer grpNo;
	
	private String grpName;
	
	private Integer sentNo;
	
	private String sentEn;
	
	private String sentKr;
	
	@Builder
	public GrpSentence(
			Integer grpNo,
			String grpName,
			Integer sentNo,
			String sentEn,
			String sentKr
			) {
		this.grpNo = grpNo;
		this.grpName = grpName;
		this.sentNo = sentNo;
		this.sentEn = sentEn;
		this.sentKr = sentKr;
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