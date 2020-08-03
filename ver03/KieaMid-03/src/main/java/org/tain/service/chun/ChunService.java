package org.tain.service.chun;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.tain.info.chun.GrpSentInfo;
import org.tain.repository.chun.SentRepository;
import org.tain.utils.CurrentInfo;
import org.tain.utils.Flag;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ChunService {

	@Autowired
	private SentRepository sentRepository;
	
	public List<GrpSentInfo> getAll() {
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get());
		return this.sentRepository.getAll();
	}
	
	public Page<GrpSentInfo> getPage(Pageable pageable) {
		if (Flag.flag) {
			int pageNumber = pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1;
			int pageSize = pageable.getPageSize();
			Sort sort = pageable.getSort();
			
			pageSize = 10;
			
			pageable = PageRequest.of(pageNumber, pageSize, sort);
		}
		log.info("KANG-20200730 >>>>> {} {}", CurrentInfo.get(), pageable);
		return this.sentRepository.getPage(pageable);
	}
}
