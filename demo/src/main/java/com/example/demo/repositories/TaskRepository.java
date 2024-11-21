package com.example.demo.repositories;

import com.example.demo.models.Task;
import com.example.demo.models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий для работы с БД
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Метод получения списка задач по статусу выполнения
     * @param status
     * @return список задач
     */
    List<Task> findTasksByStatus(TaskStatus status);
}
