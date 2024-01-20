package ru.petrov.lesson3.service;

import org.springframework.stereotype.Service;
import ru.petrov.lesson3.domain.User;

@Service
public class RegistrationService {

    private final UserService userService;
    private final NotificationService notificationService;

    public RegistrationService(UserService userService, NotificationService notificationService) {
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public void processRegistration(User user) {
        userService.createUser(user);
        notificationService.notifyUser(user);
    }
}
