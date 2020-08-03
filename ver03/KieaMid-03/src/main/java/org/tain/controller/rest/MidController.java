package org.tain.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import org.tain.info.mid.DivisionCompInfo;
import org.tain.service.mid.MidService;
import org.tain.utils.CurrentInfo;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = {"/rest/mid"})
@Slf4j
public class MidController {

	@Autowired
	private MidService midService;
	
	@RequestMapping(value = {"/list"}, method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<?> list(HttpEntity<String> httpEntity) throws Exception {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
		
		List<DivisionCompInfo> list = this.midService.getAll();
		
		MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		
		return new ResponseEntity<>(list, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/page"}, method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<?> page(HttpEntity<String> httpEntity, Pageable pageable) throws Exception {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
		
		Page<DivisionCompInfo> page = this.midService.getPage(pageable);
		
		MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		
		return new ResponseEntity<>(page, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/list2"}, method = {RequestMethod.GET, RequestMethod.POST})
	public List<DivisionCompInfo> list2() throws Exception {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
		return this.midService.getAll();
	}
	
	@RequestMapping(value = {"/page2"}, method = {RequestMethod.GET, RequestMethod.POST})
	public Page<DivisionCompInfo> page2(Pageable pageable) throws Exception {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
		return this.midService.getPage(pageable);
	}
}
