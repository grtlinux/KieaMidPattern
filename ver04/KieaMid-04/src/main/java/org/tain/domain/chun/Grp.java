package org.tain.domain.chun;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "no")
@JsonIgnoreProperties(value = {
		""
		, "create_date"
		, "update_date"
		, "job_date"
		, "work_date"
		})
public class Grp {

	@Id
	private Integer no;
	
	private String name;
	
	@JsonIgnore
	//@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	//@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@CreationTimestamp
	@Column(name = "create_date")
	private LocalDateTime createDate;
	
	@JsonIgnore
	//@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	@UpdateTimestamp
	@Column(name = "update_date")
	private Timestamp updateDate;
	
	@JsonIgnore
	//@Temporal(TemporalType.TIMESTAMP)
	//@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	@UpdateTimestamp
	@Column(name = "job_date")
	private Date jobDate;

	@Builder
	public Grp(
			Integer no,
			String name
			) {
		this.no = no;
		this.name = name;
	}
}
