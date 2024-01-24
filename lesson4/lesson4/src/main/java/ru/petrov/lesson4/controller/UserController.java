package ru.petrov.lesson4.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.petrov.lesson4.domain.User;
import ru.petrov.lesson4.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String getAllUsers(Model model) {

        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/adduser")
    public String getUser(Model model, User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }


}
