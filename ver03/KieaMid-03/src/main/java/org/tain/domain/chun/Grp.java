package org.tain.domain.chun;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Grp {

	@Id
	private Integer no;
	
	private String name;
	
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
	public Grp(
			Integer no,
			String name
			) {
		this.no = no;
		this.name = name;
	}
	
	/////////////////////////////////////////////////////////////
	
	public String toJson() {
		try {
			return this.getObjectMapper().writeValueAsString(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{}";
	}
	
	public String toPrettyJson() {
		try {
			return this.getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{}";
	}
	
	private ObjectMapper getObjectMapper() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper;
	}
}
