package com.shukla.umang.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;


/**
 * Configures the authorization server.
 * The @EnableAuthorizationServer annotation is used to configure the OAuth 2.0 Authorization Server
 * mechanism, together with any @Beans that implement AuthorizationServerConfigurer
 * (there is a handy adapter implementation with empty methods).
 *
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Inject
    private AuthenticationManager authenticationManager;

    // The AuthorizationServerEndpointsConfigurer defines the authorization and token endpoints and the token services.
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(this.authenticationManager);
    }

    /**
     * Instead of creating a database to store the registered client details. We are storing
     * it in memory for now. Using the authorizedGrantTypes method, we specify that the
     * client is authorized to use the password grant type when communicating with the
     * authorization server. Also, we define two generic scope "read" and "write".
     *
     * TODO: Write these more securely. Remove hardcoding.
     * sample schema could at
     * https://github.com/spring-projects/spring-security-oauth/blob/master/spring-security-oauth2/src/test/resources/schema.sql
     *
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
            .inMemory()
                .withClient("rest_api_client_normal_user")
                .secret("top_secret")
                .authorizedGrantTypes("password")
                .scopes("read", "write")
                .resourceIds("oauth2-resource");
    }

    /**
     * We here defines the security constraints on the token endpoint.
     * We set it up to isAuthenticated, which returns true if the user is not anonymous.
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("isAuthenticated()");
    }
}
