package ru.petrov.lesson3.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import ru.petrov.lesson3.domain.User;
import ru.petrov.lesson3.service.FileGateway;
import ru.petrov.lesson3.service.RegistrationService;
import ru.petrov.lesson3.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final RegistrationService registrationService;
    private final UserService userService;
    private final FileGateway fileGateway;

    public UserController(RegistrationService registrationService, UserService userService, FileGateway fileGateway) {
        this.registrationService = registrationService;
        this.userService = userService;
        this.fileGateway = fileGateway;
    }

    @GetMapping
    public List<User> userList() {
        return userService.getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        registrationService.processRegistration(user);
        fileGateway.writeToFile(user.getName() + ".txt", user.toString());
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
