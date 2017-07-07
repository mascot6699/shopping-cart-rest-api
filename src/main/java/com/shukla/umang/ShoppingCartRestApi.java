package com.shukla.umang;

import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.shukla.umang.repository.UserRepository;
import com.shukla.umang.config.CustomUserDetails;
import com.shukla.umang.service.Impl.UserServiceImpl;

@SpringBootApplication
public class ShoppingCartRestApi {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartRestApi.class, args);
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder,
        UserRepository repository, UserServiceImpl service) throws Exception {
        builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);
    }

    private UserDetailsService userDetailsService(final UserRepository repository) {
        return username -> new CustomUserDetails(repository.findByUsername(username));
    }
}
