package com.github.hvhvdevdev.foolishnesswiki.repository;

import com.github.hvhvdevdev.foolishnesswiki.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TagRepository extends CrudRepository<Tag, String> {
}
