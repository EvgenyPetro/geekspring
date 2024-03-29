package ru.petrov.lesson5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Lesson5Application {

    public static void main(String[] args) {
        SpringApplication.run(Lesson5Application.class, args);
    }

}
