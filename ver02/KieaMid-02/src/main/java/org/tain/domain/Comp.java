package org.tain.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.tain.utils.CurrentInfo;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
@NoArgsConstructor
@Slf4j
public class Comp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String code;
	
	private int idx;
	
	private String stmtKr;
	
	private String stmtEn;
	
	@Builder
	public Comp(
			String code,
			int idx,
			String stmtKr,
			String stmtEn
			) {
		this.code = code;
		this.idx = idx;
		this.stmtKr = stmtKr;
		this.stmtEn = stmtEn;
	}
	
	////////////////////////////////////////////////////////////////////////
	
	public String toJson() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (Exception e) {
			log.info("ERROR[{}]: {}", CurrentInfo.get(), e.getMessage());
		}
		return "{}";
	}
	
	public String toPrettyJson() {
		try {
			return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (Exception e) {
			log.info("ERROR[{}]: {}", CurrentInfo.get(), e.getMessage());
		}
		return "{}";
	}
}