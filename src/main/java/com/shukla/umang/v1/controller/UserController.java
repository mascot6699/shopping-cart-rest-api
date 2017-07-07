package com.shukla.umang.v1.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shukla.umang.dto.request.CreateUserRequest;
import com.shukla.umang.service.Impl.UserServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * All apis endpoints related to user stay here.
 */
@RestController("userControllerV1")
@RequestMapping("/v1/")
@Api(value = "user", description = "User API", protocols = "http")
public class UserController {

    @Inject
    private UserServiceImpl service;

    @RequestMapping(value="/user", method=RequestMethod.POST)
    @ApiOperation(value = "create a new user", notes="Performed only by admin user", response = Void.class)
    public ResponseEntity<Void> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        service.saveNormalUser(createUserRequest);
        // Since get user is not allowed not sending id of created user.
        return new ResponseEntity<> (null, HttpStatus.CREATED);
    }

}
