package com.shukla.umang.repository;

import java.util.List;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface BaseCreateOnlyRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    @Override
    @RestResource(exported = false)
    void delete(T entity);

    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends T> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();

    @Override
    @RestResource(exported = false)
    List<T> findAll();

    @Override
    @RestResource(exported = false)
    T findOne(ID id);

}
