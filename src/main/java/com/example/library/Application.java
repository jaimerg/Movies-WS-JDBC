package com.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan
@EnableAutoConfiguration
@ImportResource("classpath*:META-INF/spring/applicationContext.xml")

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println();
    }
}
