package ru.petrov.lesson2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.petrov.lesson2.model.User;
import ru.petrov.lesson2.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;


    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        log.info("controller called findAll");
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        log.info("controller called updateUserForm");
        return "user-create";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(User user) {
        log.info("controller called updateUserForm");

        return
                "user-update";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        log.info("controller called createUser");
        return "redirect:/users";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUserById(id);
        log.info("controller called deleteUser");
        return "redirect:/users";
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        log.info("controller called getUserById");
        return "user";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.updateUser(user);
        log.info("controller called updateUser");
        return "redirect:/users";
    }
}
