package com.lili;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HelloClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloClientApplication.class, args);
    }

}
