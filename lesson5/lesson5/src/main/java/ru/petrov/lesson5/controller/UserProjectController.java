package ru.petrov.lesson5.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.petrov.lesson5.domain.Project;
import ru.petrov.lesson5.domain.User;
import ru.petrov.lesson5.service.UserProjectService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserProjectController {

    private final UserProjectService userProjectService;

    @GetMapping("/users/{projectId}")
    public ResponseEntity<List<User>> getUsersByProjectId(@PathVariable Long projectId) {
        return ResponseEntity
                .status(200)
                .body(userProjectService.getUsersByProjectId(projectId));
    }

    @GetMapping("/projects/{userId}")
    public ResponseEntity<List<Project>> getProjectsByUserId(@PathVariable Long userId) {
        return ResponseEntity
                .status(200)
                .body(userProjectService.getProjectsByUserId(userId));

    }

    @PostMapping("/adduser/{userId}/{projectId}")
    public ResponseEntity<Void> addUserToProject(@PathVariable Long userId, @PathVariable Long projectId) {
        userProjectService.addUserToProject(userId, projectId);
        return ResponseEntity.status(200).build();

    }

    @PostMapping("/deleteuser/{userId}/{projectId}")
    public ResponseEntity<Void> removeUserFromProject(@PathVariable Long userId, @PathVariable Long projectId) {
        userProjectService.removeUserFromProject(userId, projectId);
        return ResponseEntity.status(200).build();
    }

}
