package com.shukla.umang.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.shukla.umang.dto.request.CreateUserRequest;


/**
 * This class consists exclusively of non-static methods that return
 * properties of user. It is mapped with Users table in database.
 */
@Entity
@Table(name="USERS")
public class User {

    @Id
    @GeneratedValue
    @Column(name="USER_ID")
    private Long id;

    @NotEmpty
    @Column(unique=true)
    private String username;

    @Column(name="PASSWORD")
    @NotEmpty
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name="FIRST_NAME")
    @NotEmpty
    private String firstName;

    @Column(name="LAST_NAME")
    @NotEmpty
    private String lastName;

    @Column(name="ADMIN", columnDefinition="char(3)")
    @Type(type="yes_no")
    private boolean admin;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date modified;

    public User() {
    }

    public User(CreateUserRequest createUserRequest) {
        this.username = createUserRequest.getUsername();
        this.firstName = createUserRequest.getFirstName();
        this.lastName = createUserRequest.getLastName();
    }

    /**
     * Getters for User class.
     */

    public Long getId() {
        return id;
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

    public boolean isAdmin() {
        return admin;
    }

    /**
     * Setters for user class.
     */

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return getUsername();
    }

}
