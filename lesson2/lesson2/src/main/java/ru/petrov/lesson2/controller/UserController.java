package ru.petrov.lesson2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.petrov.lesson2.model.User;
import ru.petrov.lesson2.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();


        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(User user) {
        return "user-update";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable Integer id,Model model){
        model.addAttribute("user",userService.getUserById(id));
        return "user";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/users";
    }
}