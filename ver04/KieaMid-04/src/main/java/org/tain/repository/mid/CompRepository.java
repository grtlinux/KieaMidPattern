package org.tain.repository.mid;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.tain.domain.mid.Comp;
import org.tain.info.mid.MidInfo;

@RepositoryRestResource
public interface CompRepository extends JpaRepository<Comp, Long>{

	@Query(value = ""
			+ " select "
			+ "    d.code       as divCode     "
			+ "    , d.title    as divTitle    "
			+ "    , d.content  as divContent  "
			+ "    , c.id       as compId      "
			+ "    , c.idx      as compIdx     "
			+ "    , c.code     as compCode    "
			+ "    , c.stmt_kr  as compStmtKr  "
			+ "    , c.stmt_en  as compStmtEn  "
			+ " from "
			+ "    comp as c left outer join division as d "
			+ "      on c.division_code = d.code "
			+ " where 1=1 "
			+ " order by c.id desc "
			+ ""
		, nativeQuery = true)
	List<MidInfo> getAll();
	
	@Query(value = ""
			+ " select "
			+ "    d.code       as divCode     "
			+ "    , d.title    as divTitle    "
			+ "    , d.content  as divContent  "
			+ "    , c.id       as compId      "
			+ "    , c.idx      as compIdx     "
			+ "    , c.code     as compCode    "
			+ "    , c.stmt_kr  as compStmtKr  "
			+ "    , c.stmt_en  as compStmtEn  "
			+ " from "
			+ "    comp as c left outer join division as d "
			+ "      on c.division_code = d.code "
			+ " where 1=1 "
			+ ""
		, countQuery = ""
			+ " select "
			+ "    count(*) "
			+ " from "
			+ "    comp as c left outer join division as d "
			+ "      on c.division_code = d.code "
			+ " where 1=1 "
			+ ""
		, nativeQuery = true)
	public Page<MidInfo> getPage(Pageable pageable);
}
