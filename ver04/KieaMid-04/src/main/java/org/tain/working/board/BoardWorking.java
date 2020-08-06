package org.tain.working.board;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.tain.domain.board.Board;
import org.tain.object.board.BoardObject;
import org.tain.repository.board.BoardRepository;
import org.tain.utils.CurrentInfo;
import org.tain.utils.Flag;
import org.tain.utils.JsonPrint;

import com.fasterxml.jackson.core.type.TypeReference;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BoardWorking {

	@Autowired
	private BoardRepository boardRepository;
	
	@Value("${file.from.word}")
	private String fileFromWord;
	
	@Value("${file.to.word}")
	private String fileToWord;
	
	public void loading() {
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) {
			IntStream.rangeClosed(1, 200).forEach(index -> {
				Board board = this.boardRepository.save(Board.builder()
						.title("제목-" + index)
						.subTitle("부제목-" + index)
						.content("내용입니다.")
						.userId("kiea")
						.build());
				if (!Flag.flag) JsonPrint.getInstance().printPrettyJson(board);
			});
		}
	}
	
	public void fetching() {
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) {
			this.boardRepository.findAll().forEach(entity -> {
				JsonPrint.getInstance().printPrettyJson(entity);
			});
		}
	}
	
	public void testBoardInfoSome() {
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) {
			this.boardRepository.findBoardInfoSome(100L).forEach(entity -> {
				JsonPrint.getInstance().printPrettyJson(entity);
			});
		}
		
		if (Flag.flag) {
			this.boardRepository.findBoardInfoSome(100L).forEach(entity -> {
				BoardObject boardObject = BoardObject.builder()
						.id(entity.getId())
						.title(entity.getTitle())
						.subTitle(entity.getSubTitle())
						.content(entity.getContent())
						.userId(entity.getUserId())
						.build();
				JsonPrint.getInstance().printPrettyJson(boardObject);
			});
		}
	}
	
	public void saveJsonFile() {
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) {
			List<BoardObject> lst = new ArrayList<>();
			
			this.boardRepository.findAll().forEach(entity -> {
				BoardObject boardObject = BoardObject.builder()
						.id(entity.getId())
						.title(entity.getTitle())
						.subTitle(entity.getSubTitle())
						.content(entity.getContent())
						.userId(entity.getUserId())
						.createdDate(entity.getCreatedDate())
						.updatedDate(entity.getUpdatedDate())
						.jobDate(entity.getJobDate())
						.workDate(entity.getWorkDate())
						.build();
				lst.add(boardObject);
			});
			
			JsonPrint.getInstance().savePrettyJson(new File(this.fileToWord), lst);
			
			if (!Flag.flag) System.exit(0);
		}
	}
	
	public void loadJsonFile() {
		log.info("KANG-20200806 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) {
			this.boardRepository.deleteAll();
		}
		
		if (Flag.flag) {
			try {
				List<BoardObject> lst = JsonPrint.getInstance().getObjectMapper().readValue(
						new File(this.fileToWord)
						, new TypeReference<List<BoardObject>>() {});
				lst.forEach(dat -> {
					Board board = this.boardRepository.save(Board.builder()
							.id(dat.getId())
							.title(dat.getTitle())
							.subTitle(dat.getSubTitle())
							.content(dat.getContent())
							.userId(dat.getUserId())
							.createdDate(dat.getCreatedDate())
							.build());
					JsonPrint.getInstance().printPrettyJson(board);
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
