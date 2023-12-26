package ru.petrov;

import com.google.gson.Gson;

public class App {


    public static void main(String[] args) {

        Person person = new Person("Ivan", "Petrov", 24);
        Gson mapper = new Gson();

        String json = mapper.toJson(person);
        Person fromJson = mapper.fromJson(json, Person.class);

        System.out.println(json);
        System.out.println(fromJson);
    }
}
