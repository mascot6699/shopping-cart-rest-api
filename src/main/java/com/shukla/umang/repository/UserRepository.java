package com.shukla.umang.repository;

import com.shukla.umang.domain.User;

public interface UserRepository extends BaseCreateOnlyRepository<User, Long>
{
	User findByUsername(String username);
}
