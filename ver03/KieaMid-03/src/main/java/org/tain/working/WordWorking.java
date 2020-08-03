package org.tain.working;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.tain.domain.word2500.Word;
import org.tain.object.word2500.WordObject;
import org.tain.repository.word2500.WordRepository;
import org.tain.utils.CurrentInfo;
import org.tain.utils.Flag;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WordWorking {

	@Autowired
	private WordRepository wordRepository;
	
	public void loading() {
		log.info("KANG-20200803 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) {
			// text -> table
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader("src/main/resources/json/org_word2500.txt"));
				String line = null;
				
				Integer idx = 1;
				Word word = null;
				
				while ((line = br.readLine()) != null) {
					line = line.trim();
					if ("".equals(line))
						continue;
					
					if (!Flag.flag) System.out.println(">>>>> " + line);
					
					String[] items = line.split("\t+");
					List<String> lstItem = Arrays.asList(items);
					if (!Flag.flag) System.out.println(">>>>> " + lstItem);
					
					word = this.wordRepository.save(Word.builder()
							.idx(idx)
							.word(lstItem.get(0))
							.mean(lstItem.get(1))
							.build());
					if (Flag.flag) System.out.println(">>>>> " + word.toPrettyJson());
					
					idx ++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (br != null) try { br.close(); } catch (Exception e) {}
			}
		}
	}
	public void getAll() {
		log.info("KANG-20200803 >>>>> {} {}", CurrentInfo.get());
		
		this.wordRepository.getAll().forEach(entity -> {
			WordObject wordObject = WordObject.builder()
					.idx(entity.getIdx())
					.word(entity.getWord())
					.mean(entity.getMean())
					.build();
			if (Flag.flag) System.out.println("getAll >>>>> json: " + wordObject.toPrettyJson());
		});
	}
	
	public void getPage() {
		log.info("KANG-20200803 >>>>> {} {}", CurrentInfo.get());
		
		Pageable pageable = PageRequest.of(0, 4);
		this.wordRepository.getPage(pageable).forEach(entity -> {
			WordObject wordObject = WordObject.builder()
					.idx(entity.getIdx())
					.word(entity.getWord())
					.mean(entity.getMean())
					.build();
			if (Flag.flag) System.out.println("getPage >>>>> json: " + wordObject.toPrettyJson());
		});
	}
	
	public void selecting() {
		log.info("KANG-20200803 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) {
			this.wordRepository.getAll().forEach(entity -> {
				//if (!Flag.flag) System.out.println(">>>>> json: " + entity.toJson());
			});
		}
	}
}
