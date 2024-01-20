package ru.petrov.lesson3.service;

import org.springframework.stereotype.Service;
import ru.petrov.lesson3.domain.User;
import ru.petrov.lesson3.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    private final UserRepository repository;

    public DataProcessingService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> sortUsersByAge() {

        return repository.findAll().stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> filterUsersByAge(int age) {

        return repository.findAll().stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public double calculateAverageAge() {

        return repository.findAll().stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

}
