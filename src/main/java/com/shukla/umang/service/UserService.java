package com.shukla.umang.service;

import com.shukla.umang.dto.request.CreateUserRequest;

public interface UserService {

    void saveNormalUser(CreateUserRequest createUserRequest);
}
