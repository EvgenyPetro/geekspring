package ru.petrov.rickandmorty.domain;


import lombok.Data;

import java.util.List;

@Data
public class Response {
    private Info info;
    private List<Character> results;
}
