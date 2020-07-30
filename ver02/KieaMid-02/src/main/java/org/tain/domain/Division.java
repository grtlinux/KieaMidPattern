package org.tain.domain;

import javax.persistence.Entity;
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
public class Division {

	@Id
	private String code;
	
	private String title;
	
	private String content;
	
	@Builder
	public Division(
			String code,
			String title,
			String content
			) {
		this.code = code;
		this.title = title;
		this.content = content;
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