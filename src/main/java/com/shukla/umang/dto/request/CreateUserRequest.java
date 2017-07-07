package com.shukla.umang.dto.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Create User Request DTO")
public class CreateUserRequest {

    @NotNull
    @ApiModelProperty(name = "username", value = "user name")
    @JsonProperty(value = "user_name", required = true)
    private String username;

    @NotNull
    @ApiModelProperty(name = "password", value = "password")
    @JsonProperty(value = "password", required = true)
    private String password;

    @NotNull
    @ApiModelProperty(name = "firstName", value = "firstName")
    @JsonProperty(value = "first_name", required = true)
    private String firstName;

    @NotNull
    @ApiModelProperty(name = "lastName", value = "lastName")
    @JsonProperty(value = "last_name", required = true)
    private String lastName;

    public CreateUserRequest() {

    }

    public CreateUserRequest(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
