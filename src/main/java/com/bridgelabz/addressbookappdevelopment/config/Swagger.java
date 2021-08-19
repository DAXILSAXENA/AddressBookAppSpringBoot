/** Swagger.java */
package com.bridgelabz.addressbookappdevelopment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class Swagger {

    /**
     * Purpose: @EnableSwagger2 enables Swagger in Application which is further used to
     *          handle api calls using UserInterface in a simple manner.
     */

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bridgelabz.addressbookappdevelopment"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Address Book Development Application",
                "This application perform CRUD operations to get,create,update and delete data from MySQL database",
                "VERSION 1.0",
                "TERMS OF SERVICE URL",
                new Contact("Daxil Saxena","URL","abc@gmail.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}

