package com.centric.centricexpress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.centric.centricexpress")
public class CentricExpressAPI {

    public static void main(String[] args) {
        SpringApplication.run(CentricExpressAPI.class, args);
    }
}
