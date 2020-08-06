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

	@Query(value = ""
			+ " select "
			+ "    g.no        as grpNo   "
			+ "    , g.name    as grpName "
			+ "    , s.no      as sentNo  "
			+ "    , s.sent_en as sentEn  "
			+ "    , s.sent_kr as sentKr  "
			+ " from "
			+ "    sent as s left outer join grp as g "
			+ "      on s.grp_no = g.no "
			+ " where 1=1 "
			+ " order by s.no desc "
			+ ""
		, nativeQuery = true)
	List<GrpSentInfo> getAll();
	
	@Query(value = ""
			+ " select "
			+ "    g.no       as grpNo   "
			+ "    , g.name   as grpName "
			+ "    , s.no     as sentNo  "
			+ "    , s.sent_en as sentEn  "
			+ "    , s.sent_kr as sentKr  "
			+ " from "
			+ "    sent as s left outer join grp as g "
			+ "      on s.grp_no = g.no "
			+ " where 1=1 "
			+ ""
		, countQuery = ""
			+ " select "
			+ "    count(*) "
			+ " from "
			+ "    Sent as s left outer join Grp as g "
			+ "      on s.grp_no = g.no "
			+ " where 1=1 "
			+ ""
		, nativeQuery = true)
	public Page<GrpSentInfo> getPage(Pageable pageable);
}
