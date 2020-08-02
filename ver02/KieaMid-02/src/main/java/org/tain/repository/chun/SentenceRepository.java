package org.tain.repository.chun;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.tain.domain.chun.Sentence;

@RepositoryRestResource
public interface SentenceRepository extends JpaRepository<Sentence, Integer>{

	/*
	@Query("select b.id, b.title, count(r) "
			+ "from Board b left outer join b.replies r "
			+ "where b.id > 0 "
			+ "group by b")
	public List<Object[]> getPage(Pageable pageable);
	*/
	
	@Query("select "
			//+ "  new org.tain.object.chun.GrpSentence("  // need @AllArgsConstructor
			+ "    g.no       as grpNo "
			+ "    , g.name   as grpName "
			+ "    , s.no     as sentNo "
			+ "    , s.sentEn as sentEn "
			+ "    , s.sentKr as sentKr "
			//+ "  ) "
			+ "from "
			+ "  Sentence s left outer join s.grp g "
			+ "where 1=1 "
			+ "order by s.no desc ")
	public List<Object[]> getAll();
	
	@Query("select "
			//+ "  new org.tain.object.chun.GrpSentence("  // need @AllArgsConstructor
			+ "    g.no       as grpNo "
			+ "    , g.name   as grpName "
			+ "    , s.no     as sentNo "
			+ "    , s.sentEn as sentEn "
			+ "    , s.sentKr as sentKr "
			//+ "  ) "
			+ "from "
			+ "  Sentence s left outer join s.grp g "
			+ "where 1=1 ")
	public Page<Object[]> getPage(Pageable pageable);
}
