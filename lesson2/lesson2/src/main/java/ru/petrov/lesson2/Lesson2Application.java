package ru.petrov.lesson2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import ru.petrov.lesson2.utils.SqlQwery;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackageClasses = SqlQwery.class)
public class Lesson2Application {

    public static void main(String[] args) {
        SpringApplication.run(Lesson2Application.class, args);
    }

}
