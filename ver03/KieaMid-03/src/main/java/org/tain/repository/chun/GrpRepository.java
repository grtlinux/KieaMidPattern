package org.tain.repository.chun;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.tain.domain.chun.Grp;

@RepositoryRestResource
public interface GrpRepository extends JpaRepository<Grp, Integer>{

}
