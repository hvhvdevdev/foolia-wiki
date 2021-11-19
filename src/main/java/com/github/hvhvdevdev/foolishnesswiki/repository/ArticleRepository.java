package com.github.hvhvdevdev.foolishnesswiki.repository;

import com.github.hvhvdevdev.foolishnesswiki.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RepositoryRestResource
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Override
    @PreAuthorize("hasAnyRole('WRITER','ADMIN')")
    @NonNull
    <S extends Article> List<S> saveAll(@NonNull Iterable<S> entities);

    @Override
    @PreAuthorize("hasAnyRole('WRITER','ADMIN')")
    @NonNull
    <S extends Article> S save(@NonNull S entity);

}
