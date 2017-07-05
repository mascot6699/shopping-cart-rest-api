package com.shukla.umang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .paths(PathSelectors.ant("/v1/**"))
                .build()
                .apiInfo(apiInfo());
    }

    private static ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Shopping Cart REST API")
                .description("Api for creating and managing shopping experience")
                .version("1.0")
                .license("license v1.0")
                .licenseUrl("https://mascot6699.github.io")
                .termsOfServiceUrl("https://mascot6699.github.io")
                .contact(new Contact("Umang",
                                     "https://mascot6699.github.io",
                                     "umangshucool@gmail.com"))
                .build();
    }
}
