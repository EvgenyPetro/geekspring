package ru.petrov.rickandmorty.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.petrov.rickandmorty.service.RickAndMortyService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/character")
public class RickAndMortyController {

    private final RickAndMortyService service;
    private Integer count = 1;


    @GetMapping
    public String getResponsePage(@RequestParam(required = false) String page, Model model) {
        if (page != null) {
            if (page.startsWith("inc")) {
                count++;
            } else if (page.startsWith("dec")) {
                count--;
            }
        }
        model.addAttribute("response", service.getAllCharacters(count));
        return "index";
    }

    @GetMapping("/{id}")
    public String getCharacters(@PathVariable String id, Model model) {
        model.addAttribute("character", service.getCharacter(id));
        return "character";
    }
}
