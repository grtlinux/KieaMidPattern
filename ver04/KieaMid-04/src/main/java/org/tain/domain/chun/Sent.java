package org.tain.domain.chun;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Sent {

	@Id
	private Integer no;
	
	private String sentEn;
	
	private String sentKr;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "grp_no")
	@JsonIgnore
	private Grp grp;
	
	@JsonIgnore
	//@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	//@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@JsonIgnore
	//@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	@UpdateTimestamp
	private Timestamp updatedDate;
	
	@JsonIgnore
	//@Temporal(TemporalType.TIMESTAMP)
	//@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	@UpdateTimestamp
	private Date jobDate;
	
	@Builder
	public Sent(
			Integer no,
			String sentEn,
			String sentKr,
			Grp grp
			) {
		this.no = no;
		this.sentEn = sentEn;
		this.sentKr = sentKr;
		this.grp = grp;
	}
}
