package com.github.hvhvdevdev.foolishnesswiki.repository;

import com.github.hvhvdevdev.foolishnesswiki.model.User;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Optional;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends User> @NonNull S save(S entity);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends User> @NonNull Iterable<S> saveAll(Iterable<S> entities);
}

