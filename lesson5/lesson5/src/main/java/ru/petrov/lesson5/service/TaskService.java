package ru.petrov.lesson5.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.petrov.lesson5.domain.Task;
import ru.petrov.lesson5.domain.TaskStatus;
import ru.petrov.lesson5.dto.TaskDescriptionDto;
import ru.petrov.lesson5.dto.TaskStatusDto;
import ru.petrov.lesson5.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

import static ru.petrov.lesson5.domain.TaskStatus.NOT_STARTED;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> findByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    public Task saveTask(TaskDescriptionDto taskDescriptionDto) {

        Task task = new Task();
        task.setDescription(taskDescriptionDto.getDescription());
        task.setStatus(NOT_STARTED);
        task.setLocalDateTime(LocalDateTime.now());

        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(Long id, TaskStatusDto statusDto) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus(statusDto.getStatus());
        task.setLocalDateTime(LocalDateTime.now());

        return taskRepository.save(task);
    }

}
