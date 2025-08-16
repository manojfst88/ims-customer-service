package com.ims.customer.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "Authorization",
        scheme = "bearer",
        type = SecuritySchemeType.APIKEY,
        in = SecuritySchemeIn.HEADER,
        bearerFormat = "JWT"
)
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(new Info().title("Demo project for Spring Boot Auth with Spring Security, JWT and MongoDB")
                .description("Demo project for Spring Boot Auth with Spring Security, JWT and MongoDB")
                .version("v0.0.2")
                .contact(getContactDetails()));
    }

    private Contact getContactDetails() {
        return new Contact().name("Manoj Kumar")
                .email("manojfst88@gmail.com")
                .url("https://github.com/manojfst88");
    }

}