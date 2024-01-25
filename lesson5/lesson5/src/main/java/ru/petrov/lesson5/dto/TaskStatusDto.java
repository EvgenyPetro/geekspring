package ru.petrov.lesson5.dto;

import lombok.Data;
import ru.petrov.lesson5.domain.TaskStatus;

@Data
public class TaskStatusDto {
    private TaskStatus status;
}
