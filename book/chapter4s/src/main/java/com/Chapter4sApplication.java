package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Chapter4sApplication {
    public static void main(String[] args) {
        SpringApplication.run(Chapter4sApplication.class, args);
    }
}
