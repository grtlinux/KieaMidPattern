package org.tain.object.board;

import org.tain.utils.TimestampEntity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class BoardObject extends TimestampEntity {

	private Long id;
	
	private String title;
	
	private String subTitle;
	
	private String content;
	
	private String userId;
	
	@Builder
	public BoardObject(
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
