package org.tain.object.board;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardObject {

	private Long id;
	
	private String title;
	
	private String subTitle;
	
	private String content;
	
	private String userId;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdDate;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp updatedDate;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date jobDate;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date workDate;
	
	@Builder
	public BoardObject(
			Long id,
			String title,
			String subTitle,
			String content,
			String userId,
			LocalDateTime createdDate,
			Timestamp updatedDate,
			Date jobDate,
			Date workDate
			) {
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.content = content;
		this.userId = userId;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.jobDate = jobDate;
		this.workDate = workDate;
	}
}
