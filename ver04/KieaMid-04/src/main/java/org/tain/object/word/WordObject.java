package org.tain.object.word;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WordObject {

	private Integer idx;
	
	private String word;
	
	private String mean;
	
	@Builder
	public WordObject(
			Integer idx,
			String word,
			String mean
			) {
		this.idx = idx;
		this.word = word;
		this.mean = mean;
	}
}
