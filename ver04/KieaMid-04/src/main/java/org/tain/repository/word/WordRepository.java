package org.tain.repository.word;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.tain.domain.word.Word;
import org.tain.info.word.WordInfo;

@RepositoryRestResource
public interface WordRepository extends JpaRepository<Word, Integer>{

	@Query(value = ""  // Table.columnName   AS  Entity.fieldName
			+ " select "
			+ "  b.idx      as idx  "
			+ "  , b.word   as word "
			+ "  , b.mean   as mean "
			+ " from "
			+ "   word as b "
			+ " where 1=1 "
			+ " order by "
			+ "  b.idx desc "
			+ ""
		, nativeQuery = true)
	List<WordInfo> getAll();
	
	@Query(value = ""  // Table.columnName   AS  Entity.fieldName
			+ " select "
			+ "  b.idx      as idx  "
			+ "  , b.word   as word "
			+ "  , b.mean   as mean "
			+ " from "
			+ "   word as b "
			+ " where 1=1 "
			+ ""
		, countQuery = ""
			+ " select "
			+ "   count(*) "
			+ " from "
			+ "   word as b "
			+ " where 1=1 "
			+ ""
		, nativeQuery = true)
	Page<WordInfo> getPage(Pageable pageable);
}
