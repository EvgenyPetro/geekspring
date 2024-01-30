package ru.petrov.lesson5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.petrov.lesson5.domain.UsersProject;

import java.util.List;

public interface UsersProjectRepository extends JpaRepository<UsersProject, Long> {

    @Query("select u.userId from UsersProject u where u.projectId = :projectId")
    List<Long> findUsersIdByProjectId(Long projectId);

    @Query("select u.projectId from UsersProject u where u.userId = :userId")
    List<Long> findProjectIdByUserId(Long userId);

    UsersProject findByUserIdAndProjectId(Long userId, Long projectId);

    @Transactional
    @Modifying
    @Query("delete from UsersProject u where u.userId = :userId and u.projectId = :projectId")
    void deleteByUserIdAndProjectId(Long userId, Long projectId);

}
