package com.shukla.umang;

import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;


/**
 * Spring Security’s sensible defaults will create an in-memory token store for
 * this authorization server to use which will be responsible for managing client details,
 * verifying a resource owner’s authorization, and generating tokens such as authorization
 * code, access, and refresh tokens
 *
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Inject
    private AuthenticationManager authenticationManager;

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
                .resourceIds("shopping_cart_rest_api");
    }
}
