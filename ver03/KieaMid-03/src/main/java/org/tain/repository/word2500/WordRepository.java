package org.tain.repository.word2500;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.tain.domain.word2500.Word;
import org.tain.info.word2500.WordInfo;

@RepositoryRestResource
public interface WordRepository extends JpaRepository<Word, Integer>{

	@Query("select "
			+ "   w.idx as idx "
			+ "   , w.word as word "
			+ "   , w.mean as mean "
			+ " from "
			+ "   Word w "
			+ " where 1=1 "
			+ " order by w.idx desc")
	List<WordInfo> getAll();
	
	@Query("select "
			+ "   w.idx as idx "
			+ "   , w.word as word "
			+ "   , w.mean as mean "
			+ " from Word w "
			+ " where 1=1")
	Page<WordInfo> getPage(Pageable pageable);
}
