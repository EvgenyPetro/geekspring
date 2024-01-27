package ru.petrov.lesson5.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
public class UsersProject extends EntityWithRelation {
    private Long projectId;
    private Long userId;

}
