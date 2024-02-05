package ru.petrov.lesson7_1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @GetMapping("/private-data")
    public String privateData(){

        return "private";
    }

    @GetMapping("/public-data")
    public String publicData(){

        return "public";
    }
}
