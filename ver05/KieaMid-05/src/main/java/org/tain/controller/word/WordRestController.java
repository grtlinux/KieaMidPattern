package org.tain.controller.word;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tain.domain.word.Word;
import org.tain.repository.word.WordRepository;
import org.tain.utils.CurrentInfo;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = {"/rest/word"})
@Slf4j
public class WordRestController {

	@Autowired
	private WordRepository wordRepository;
	
	@RequestMapping(value = {"/list1"}, method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<?> list1(HttpEntity<String> httpEntity) throws Exception {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
		
		List<Word> lst = this.wordRepository.findAll();
		
		MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		
		return new ResponseEntity<>(lst, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/list2"}, method = {RequestMethod.GET, RequestMethod.POST})
	public List<Word> list2() throws Exception {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
		return this.wordRepository.findAll();
	}
	
	@RequestMapping(value = {"/page1"}, method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<?> page1(HttpEntity<String> httpEntity) throws Exception {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
		
		Pageable pageable = PageRequest.of(0, 3);
		Page<Word> lst = this.wordRepository.findAll(pageable);
		
		MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		
		return new ResponseEntity<>(lst, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/page2"}, method = {RequestMethod.GET, RequestMethod.POST})
	public Page<Word> page2() throws Exception {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
		return this.wordRepository.findAll(PageRequest.of(0, 3));
	}
}
