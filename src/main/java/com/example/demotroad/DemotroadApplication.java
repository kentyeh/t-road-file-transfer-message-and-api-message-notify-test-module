package com.example.demotroad;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemotroadApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemotroadApplication.class, args);
    }

 
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("Public API")
                .packagesToScan("com.example.demotroad")
                .build();
    }
}
