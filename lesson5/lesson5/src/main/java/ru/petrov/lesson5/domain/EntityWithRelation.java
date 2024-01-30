package ru.petrov.lesson5.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@Table(name = "user_project")
public abstract class EntityWithRelation {

    @Id
    @SequenceGenerator(name = "user_project",
            sequenceName = "user_project_seq",
            initialValue = 6)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_project")
    protected Long id;
//    @Column(name="dtype")
//    private String relatedEntityId;
}
