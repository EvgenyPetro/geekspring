package ru.petrov.lesson2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.petrov.lesson2.model.User;
import ru.petrov.lesson2.repository.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }
}
