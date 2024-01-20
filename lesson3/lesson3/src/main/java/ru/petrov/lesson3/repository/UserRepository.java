package ru.petrov.lesson3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.petrov.lesson3.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
