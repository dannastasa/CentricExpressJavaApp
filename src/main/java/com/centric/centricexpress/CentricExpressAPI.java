package com.centric.centricexpress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "com.centric.centricexpress")
@Import(SwaggerConfig.class)
public class CentricExpressAPI {

    public static void main(String[] args) {
        SpringApplication.run(CentricExpressAPI.class, args);
    }
}
