package org.tain.repository.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.tain.domain.board.Board;

@RepositoryRestResource
public interface BoardRepository extends JpaRepository<Board, Long>{

}
