package ru.petrov.lesson5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.petrov.lesson5.domain.Task;
import ru.petrov.lesson5.domain.TaskStatus;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}
