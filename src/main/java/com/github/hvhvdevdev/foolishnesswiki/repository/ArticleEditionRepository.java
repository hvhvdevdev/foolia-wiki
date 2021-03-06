package com.github.hvhvdevdev.foolishnesswiki.repository;

import com.github.hvhvdevdev.foolishnesswiki.model.ArticleEdition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface ArticleEditionRepository extends JpaRepository<ArticleEdition, Long> {
}
