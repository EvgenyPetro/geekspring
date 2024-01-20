package ru.petrov.lesson3.service;

import org.springframework.stereotype.Service;
import ru.petrov.lesson3.domain.User;
import ru.petrov.lesson3.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
