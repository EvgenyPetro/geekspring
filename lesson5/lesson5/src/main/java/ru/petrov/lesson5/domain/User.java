package ru.petrov.lesson5.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "usr")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String role;
}
