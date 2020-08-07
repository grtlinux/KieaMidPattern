package org.tain.domain.board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.tain.utils.TimestampEntity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Board extends TimestampEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title", length = 256)
	private String title;
	
	@Column(name = "sub_title", length = 256)
	private String subTitle;
	
	@Column(name = "content", length = 10240)
	private String content;
	
	@Column(name = "user_id", length = 16)
	private String userId;
		
	@Builder
	public Board(
			Long id,
			String title,
			String subTitle,
			String content,
			String userId
			) {
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.content = content;
		this.userId = userId;
	}
}
