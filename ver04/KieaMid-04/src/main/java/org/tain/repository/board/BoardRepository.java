package org.tain.repository.board;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.tain.domain.board.Board;
import org.tain.info.board.BoardInfo;

@RepositoryRestResource
public interface BoardRepository extends JpaRepository<Board, Long>{

	/*
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
	
	@Query(value = "select "
			//+ "  new org.tain.object.chun.GrpSentence("  // need @AllArgsConstructor
			+ "    g.no       as grpNo "
			+ "    , g.name   as grpName "
			+ "    , s.no     as sentNo "
			+ "    , s.sentEn as sentEn "
			+ "    , s.sentKr as sentKr "
			//+ "  ) "
			+ "from "
			+ "  Sent s left outer join s.grp g "
			+ "where 1=1 ", nativeQuery = true)
			
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
	*/
	
	@Query(value = ""  // Table.columnName   AS  Entity.fieldName
			+ " select "
			+ "  b.id          as id       "
			+ "  , b.title     as title    "
			+ "  , b.sub_title as subTitle "
			+ "  , b.content   as content  "
			+ "  , b.user_id   as userId   "
			+ " from "
			+ "   tb_board as b "
			+ " where 1=1 "
			+ "   and b.id < :id "
			+ " order by "
			+ "  b.id desc "
			+ ""
		, nativeQuery = true)
	List<BoardInfo> findBoardInfoSome(@Param("id") Long id);
	
	@Query(value = ""  // Table.columnName   AS  Entity.fieldName
			+ " select "
			+ "  b.id          as id       "
			+ "  , b.title     as title    "
			+ "  , b.sub_title as subTitle "
			+ "  , b.content   as content  "
			+ "  , b.user_id   as userId   "
			+ " from "
			+ "   tb_board as b "
			+ " where 1=1 "
			+ "   and b.id < :id "
			+ " order by "
			+ "  b.id desc "
			+ ""
		, countQuery = ""
			+ " select "
			+ "   count(*) "
			+ " from "
			+ "   tb_board as b "
			+ " where 1=1 "
			+ "   and b.id < :id "
			+ ""
		, nativeQuery = true)
	Page<BoardInfo> findBoardInfoSome(Pageable pageable, @Param("id") Long id);
}
