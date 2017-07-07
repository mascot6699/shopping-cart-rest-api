package com.shukla.umang.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.shukla.umang.domain.User;


public interface UserRepository extends CrudRepository<User, Long> {


    @Override
    @RestResource(exported = false)
    void delete(Long id);

    @Override
    @RestResource(exported = false)
    void delete(User entity);

    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends User> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();

    @Override
    @RestResource(exported = false)
    public Iterable<User> findAll();

    @Override
    @RestResource(exported = false)
    public User findOne(Long id);

	public User findByUsername(String username);
}
