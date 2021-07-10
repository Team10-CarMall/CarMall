package com.team10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CarMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarMallApplication.class, args);
    }

}
