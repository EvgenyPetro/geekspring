package ru.petrov.lesson4.repository;

import ru.petrov.lesson4.domain.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUsers();

    User createUser(User user);
}
