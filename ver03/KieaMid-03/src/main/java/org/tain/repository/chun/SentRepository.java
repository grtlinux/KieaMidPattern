package org.tain.repository.chun;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.tain.domain.chun.Sent;
import org.tain.info.chun.GrpSentInfo;

@RepositoryRestResource
public interface SentRepository extends JpaRepository<Sent, Integer>{

	@Query("select "
			//+ "  new org.tain.object.chun.GrpSentence("  // need @AllArgsConstructor
			+ "    g.no       as grpNo "
			+ "    , g.name   as grpName "
			+ "    , s.no     as sentNo "
			+ "    , s.sentEn as sentEn "
			+ "    , s.sentKr as sentKr "
			//+ "  ) "
			+ "from "
			+ "  Sent s left outer join s.grp g "
			+ "where 1=1 "
			+ "order by s.no desc ")
	public List<GrpSentInfo> getAll();
	
	@Query("select "
			//+ "  new org.tain.object.chun.GrpSentence("  // need @AllArgsConstructor
			+ "    g.no       as grpNo "
			+ "    , g.name   as grpName "
			+ "    , s.no     as sentNo "
			+ "    , s.sentEn as sentEn "
			+ "    , s.sentKr as sentKr "
			//+ "  ) "
			+ "from "
			+ "  Sent s left outer join s.grp g "
			+ "where 1=1 ")
	public Page<GrpSentInfo> getPage(Pageable pageable);
}
