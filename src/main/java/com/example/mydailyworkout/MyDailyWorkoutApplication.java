package com.example.mydailyworkout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MyDailyWorkoutApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyDailyWorkoutApplication.class, args);
    }

}
