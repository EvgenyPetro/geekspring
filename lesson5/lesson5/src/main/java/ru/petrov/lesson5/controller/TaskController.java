package ru.petrov.lesson5.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.petrov.lesson5.domain.Task;
import ru.petrov.lesson5.domain.TaskStatus;
import ru.petrov.lesson5.dto.TaskDescriptionDto;
import ru.petrov.lesson5.dto.TaskStatusDto;
import ru.petrov.lesson5.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/")
    public List<Task> findAllTasks() {
        return taskService.findAllTasks();
    }

    @GetMapping("/status/{status}")
    public List<Task> findTaskByStatus(@PathVariable TaskStatus status) {
        return taskService.findByStatus(status);
    }

    @PostMapping("/")
    public Task createTask(@RequestBody TaskDescriptionDto taskDescriptionDto) {
        return taskService.saveTask(taskDescriptionDto);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody TaskStatusDto statusDto) {
        return taskService.updateTask(id, statusDto);
    }


    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

}
