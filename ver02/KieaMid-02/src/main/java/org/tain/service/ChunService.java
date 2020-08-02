package org.tain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tain.repository.chun.SentenceRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ChunService {

	@Autowired
	private SentenceRepository sentenceRepository;
	
}
