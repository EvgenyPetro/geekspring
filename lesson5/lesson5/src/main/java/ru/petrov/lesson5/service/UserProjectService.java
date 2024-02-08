package ru.petrov.lesson5.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.petrov.lesson5.aspect.TrackUserAction;
import ru.petrov.lesson5.domain.Project;
import ru.petrov.lesson5.domain.User;
import ru.petrov.lesson5.domain.UsersProject;
import ru.petrov.lesson5.repository.ProjectRepository;
import ru.petrov.lesson5.repository.UserRepository;
import ru.petrov.lesson5.repository.UsersProjectRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final UsersProjectRepository usersProjectRepository;


    @TrackUserAction
    public List<User> getUsersByProjectId(Long projectId) {
        List<Long> userId = usersProjectRepository.findUsersIdByProjectId(projectId);
        return userRepository.findAllById(userId);
    }

    @TrackUserAction
    public List<Project> getProjectsByUserId(Long userId) {
        List<Long> projectIds = usersProjectRepository.findProjectIdByUserId(userId);
        return projectRepository.findAllById(projectIds);
    }

    public void addUserToProject(Long userId, Long projectId) {
        UsersProject usersProject = new UsersProject();
        usersProject.setUserId(userId);
        usersProject.setProjectId(projectId);
        usersProjectRepository.save(usersProject);
    }

    public void removeUserFromProject(Long userId, Long projectId) {
        usersProjectRepository.deleteByUserIdAndProjectId(userId, projectId);
    }
}
