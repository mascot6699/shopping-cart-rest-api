package com.shukla.umang.service.Impl;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shukla.umang.domain.User;
import com.shukla.umang.service.UserService;
import com.shukla.umang.dto.request.CreateUserRequest;
import com.shukla.umang.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    /**
     * Returns the encoder used to encrypt password.
     */
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * Save user instance as non-admin and encrypt password.
     * @param createUserRequest the request object when a request is sent to create new user.
     */
    public void saveNormalUser(CreateUserRequest createUserRequest) {
        User user  = new User(createUserRequest);
        user.setAdmin(false);
        user.setPassword(getPasswordEncoder().encode(createUserRequest.getPassword()));
        repo.save(user);
    }

    public Long getLoggedInUserId(Principal principal) {
        User activeUser = (User) ((Authentication) principal).getPrincipal();
        if (activeUser != null) {
            return activeUser.getId();
        }
        return null;
    }

}
