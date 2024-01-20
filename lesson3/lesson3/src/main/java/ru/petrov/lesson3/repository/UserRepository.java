package ru.petrov.lesson3.repository;

import ru.petrov.lesson3.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    private List<User> users = new ArrayList<>();
}
