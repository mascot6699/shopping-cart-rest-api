package com.shukla.umang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * The @EnableResourceServer annotation adds a filter of type OAuth2AuthenticationProcessingFilter
 * automatically to the Spring Security filter chain.
 */
@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("resource");
    }

    /**
     * For now just securing all of our api version 1 urls. Docs can be accessed without
     * creds from now.
     *
     */
    @Override
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public void configure(HttpSecurity http) throws Exception {
        http
        .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
        .authorizeRequests()
            .antMatchers("/" , "/swagger-ui/**", "/api-docs/**").permitAll()
            .antMatchers("/v1/**").authenticated();
    }

}
