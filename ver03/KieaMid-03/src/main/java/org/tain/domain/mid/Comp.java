package org.tain.domain.mid;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.tain.utils.CurrentInfo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

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
	private Long id;
	
	private int idx;
	
	private String code;
	
	private String stmtKr;
	
	private String stmtEn;
	
	@ManyToOne
	private Division division;
	
	//@JsonIgnore
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	//@JsonIgnore
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	@UpdateTimestamp
	private Timestamp updatedDate;
	
	//@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	@UpdateTimestamp
	private Date jobDate;

	@Builder
	public Comp(
			Long id,
			int idx,
			String code,
			String stmtKr,
			String stmtEn,
			Division division
			) {
		this.id = id;
		this.code = code;
		this.idx = idx;
		this.stmtKr = stmtKr;
		this.stmtEn = stmtEn;
		this.division = division;
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