package org.tain.repository.word2500;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.tain.domain.word2500.Word;

@RepositoryRestResource
public interface WordRepository extends JpaRepository<Word, Integer>{

}
