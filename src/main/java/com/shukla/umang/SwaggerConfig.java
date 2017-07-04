package com.shukla.umang;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.models.dto.builder.ApiInfoBuilder;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableSwagger
public class SwaggerConfig {

    @Inject
    private SpringSwaggerConfig springSwaggerConfig;

    @Bean
    public SwaggerSpringMvcPlugin configureSwagger() {
        SwaggerSpringMvcPlugin swaggerSpringMvcPlugin = new SwaggerSpringMvcPlugin(this.springSwaggerConfig);
        ApiInfo apiInfo = new ApiInfoBuilder()
                                    .title("Shopping Cart REST API")
                                    .description("Api for creating and managing shopping experience")
                                    .termsOfServiceUrl("https://mascot6699.github.io")
                                    .contact("umangshucool@gmail.com")
                                    .license("MIT License")
                                    .licenseUrl("http://opensource.org/licenses/MIT")
                                    .build();
        swaggerSpringMvcPlugin
                    .apiInfo(apiInfo)
                    .apiVersion("1.0");
        swaggerSpringMvcPlugin.useDefaultResponseMessages(false);
        return swaggerSpringMvcPlugin;
    }
}
