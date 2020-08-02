package org.tain.repository.chun;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.tain.domain.chun.Tip;

@RepositoryRestResource
public interface TipRepository extends JpaRepository<Tip, Long>{

}
