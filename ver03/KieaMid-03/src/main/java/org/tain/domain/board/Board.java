package org.tain.domain.board;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_board"
	, indexes = {
			@Index(name = "board_idx0", unique = false, columnList = "title"),
			@Index(name = "board_idx1", unique = false, columnList = "user_id"),
	}
)
@SequenceGenerator(name = "board_seq"
	, sequenceName = "board_seq"
	, initialValue = 1
	, allocationSize = 1
)
@Data
@NoArgsConstructor
@JsonIgnoreProperties(value = {})
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title", length = 256)
	private String title;
	
	@Column(name = "sub_title", length = 256)
	private String subTitle;
	
	@Lob
	@Column(name = "content")
	private String content;
	
	@Column(name = "user_id", length = 16)
	private String userId;
	
	
	@Column(name = "create_date")
	//@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	//@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@JsonIgnore
	@Column(name = "update_date")
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	@UpdateTimestamp
	private Timestamp updatedDate;
	
	@JsonIgnore
	@Column(name = "job_date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	@UpdateTimestamp
	private Date jobDate;
	
	@Builder
	public Board(
			String title,
			String subTitle,
			String content,
			String userId
			) {
		this.title = title;
		this.subTitle = subTitle;
		this.content = content;
		this.userId = userId;
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
