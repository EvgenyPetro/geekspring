package ru.petrov.lesson4.repository;

import org.springframework.stereotype.Repository;
import ru.petrov.lesson4.domain.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryRepository implements UserRepository {

    private List<User> users = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {

        return users;
    }

    @Override
    public User createUser(User user) {

        users.add(user);
        return user;
    }
}
