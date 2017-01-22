package com.edsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableEurekaClient
public class MovieMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieMicroserviceApplication.class, args);
    }
}
