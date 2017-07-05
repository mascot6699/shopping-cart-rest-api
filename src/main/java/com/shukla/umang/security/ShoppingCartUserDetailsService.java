package com.shukla.umang.security;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.shukla.umang.repository.UserRepository;


/**
 * makes use of UserRepository to retrieve User information from the database.
 * UserDetailsService is typically used to retrieve user information, which gets
 * compared with user-submitted credentials during the authentication process.
 */
@Component
public class ShoppingCartUserDetailsService implements UserDetailsService {

    @Inject
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.shukla.umang.domain.User user = userRepository.findByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException(
                String.format("User with the username %s doesn't exist", username));
        }

        // Create a granted authority based on user's role.
        // Can't pass null authorities to user. Hence initialize with an empty arraylist
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(user.isAdmin()) {
            authorities = AuthorityUtils.createAuthorityList("ROLE_ADMIN");
        }

        // Create a UserDetails object from the data
        UserDetails userDetails = new User(user.getUsername(), user.getPassword(), authorities);

        return userDetails;
    }
}
