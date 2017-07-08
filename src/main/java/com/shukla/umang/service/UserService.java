package com.shukla.umang.service;

import java.security.Principal;

import com.shukla.umang.dto.request.CreateUserRequest;
import com.shukla.umang.domain.User;

public interface UserService {

    void saveNormalUser(CreateUserRequest createUserRequest);
    Long getLoggedInUserId(Principal principal);
}
