package com;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class Chapter133Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter133Application.class, args);
    }

}
