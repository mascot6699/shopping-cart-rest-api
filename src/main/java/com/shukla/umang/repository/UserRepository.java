package com.shukla.umang.repository;

import org.springframework.data.repository.CrudRepository;

import com.shukla.umang.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);
}