package org.tain.working.word;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.tain.domain.word.Word;
import org.tain.repository.word.WordRepository;
import org.tain.utils.CurrentInfo;
import org.tain.utils.Flag;
import org.tain.utils.JsonPrint;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WordWorking {

	@Autowired
	private WordRepository wordRepository;
	
	@Value("${file.from.word}")
	private String fileFromWord;
	
	@Value("${file.to.word}")
	private String fileToWord;
	
	public void loading() {
		log.info("KANG-20200808 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) {
			// text -> table
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(this.fileFromWord));
				String line = null;
				
				Long id = 1L;
				Word word = null;
				
				while ((line = br.readLine()) != null) {
					line = line.trim();
					if ("".equals(line))
						continue;
						//break;
					
					if (!Flag.flag) System.out.println(">>>>> " + line);
					
					int pos = line.indexOf(' ');
					if (pos < 0)
						continue;
						//break;
					
					String strWord = line.substring(0, pos);
					String strMean = line.substring(pos).trim();
					
					word = this.wordRepository.save(Word.builder()
							//.id(id)
							.word(strWord)
							.mean(strMean)
							.build());
					if (Flag.flag) System.out.println(">>>>> " + JsonPrint.getInstance().toPrettyJson(word));
					
					id ++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (br != null) try { br.close(); } catch (Exception e) {}
			}
		}
	}
}
