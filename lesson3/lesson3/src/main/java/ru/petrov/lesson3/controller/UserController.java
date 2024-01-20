package ru.petrov.lesson3.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import ru.petrov.lesson3.domain.User;
import ru.petrov.lesson3.service.RegistrationService;
import ru.petrov.lesson3.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final RegistrationService registrationService;
    private final UserService userService;

    public UserController(RegistrationService registrationService, UserService userService) {
        this.registrationService = registrationService;
        this.userService = userService;
    }

    @GetMapping
    public List<User> userList() {
        return userService.getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        registrationService.processRegistration(user);
        return "User added from body!";
    }

    @GetMapping("/body")
    public String userAddFromParam(@Param("name") String name,
                                   @Param("age") int age,
                                   @Param("email") String email) {
        registrationService.processRegistration(new User(name, age, email));
        return "User added from param!";
    }
}
