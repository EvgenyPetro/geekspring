package ru.petrov.lesson5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.petrov.lesson5.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
