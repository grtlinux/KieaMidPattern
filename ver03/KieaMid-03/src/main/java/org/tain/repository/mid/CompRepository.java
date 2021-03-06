package org.tain.repository.mid;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.tain.domain.mid.Comp;
import org.tain.info.mid.DivisionCompInfo;

@RepositoryRestResource
public interface CompRepository extends JpaRepository<Comp, Long>{

	@Query("select "
			+ "    d.code       as divCode "
			+ "    , d.title    as divTitle "
			+ "    , d.content  as divContent"
			+ "    , c.id       as compId    "
			+ "    , c.idx      as compIdx "
			+ "    , c.stmtKr   as compStmtKr "
			+ "    , c.stmtEn   as compStmtEn "
			+ "from "
			+ "  Comp c left outer join c.division d "
			+ "where 1=1 "
			+ "order by c.id desc ")
	List<DivisionCompInfo> getAll();
	
	@Query("select "
			+ "    d.code       as divCode "
			+ "    , d.title    as divTitle "
			+ "    , d.content  as divContent"
			+ "    , c.id       as compId    "
			+ "    , c.idx      as compIdx "
			+ "    , c.stmtKr   as compStmtKr "
			+ "    , c.stmtEn   as compStmtEn "
			+ "from "
			+ "  Comp c left outer join c.division d "
			+ "where 1=1 "
			+ "order by c.id desc ")
	Page<DivisionCompInfo> getPage(Pageable pageable);
}
