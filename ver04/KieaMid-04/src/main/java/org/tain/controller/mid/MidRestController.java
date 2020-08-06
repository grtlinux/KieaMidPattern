package org.tain.controller.mid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tain.info.mid.MidInfo;
import org.tain.repository.mid.CompRepository;
import org.tain.utils.CurrentInfo;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = {"/rest/mid"})
@Slf4j
public class MidRestController {

	@Autowired
	private CompRepository compRepository;
	
	@RequestMapping(value = {"/list1"}, method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<?> list1(HttpEntity<String> httpEntity) throws Exception {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
		
		List<MidInfo> list = this.compRepository.getAll();
		
		MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		
		return new ResponseEntity<>(list, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/list2"}, method = {RequestMethod.GET, RequestMethod.POST})
	public List<MidInfo> list2() throws Exception {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
		return this.compRepository.getAll();
	}
	
	@RequestMapping(value = {"/page1"}, method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<?> page1(HttpEntity<String> httpEntity
			, @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) throws Exception {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
		
		Page<MidInfo> list = this.compRepository.getPage(pageable);
		
		MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		
		return new ResponseEntity<>(list, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/page2"}, method = {RequestMethod.GET, RequestMethod.POST})
	public Page<MidInfo> page2(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) throws Exception {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
		return this.compRepository.getPage(pageable);
	}
}
