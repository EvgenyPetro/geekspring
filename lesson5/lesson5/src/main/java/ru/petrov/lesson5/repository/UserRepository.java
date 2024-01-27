package ru.petrov.lesson5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.petrov.lesson5.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
