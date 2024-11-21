package com.example.demo.controllers;

import com.example.demo.models.Task;
import com.example.demo.models.TaskStatus;
import com.example.demo.services.TaskService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс для обработки запросов
 */
@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    /**
     * Метод обработки Get-запроса (пустой)
     * @return список всех задач
     */
    @GetMapping()
    public List<Task> getAllTask(){
        return taskService.getAllTasks();
    }

    /**
     * Метод обработки запроса на добавление задачи
     * @param description тело задачи, передается по параметрам через body
     * @return новая задача
     */
    @PostMapping()
    public Task addTaskFromParam(@RequestParam("description") String description){
        return taskService.createTask(description);
    }

    /** Метод обработки запроса списка задач с указанным статусом
     * (NOT_STARTED, IN_PROGRESS, COMPLETED)
     * @param status текущий статус
     * @return список задач
     */
    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable TaskStatus status){
        return taskService.findTasksByStatus(status);
    }

    /**
     * Метод обработки запроса изменения статуса задачи по id
     * @param id ID задачи
     * @return задача с измененным статусом
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id){
        return taskService.updateTaskStatus(id);
    }

    /**
     * Метод обработки запроса на удаления задачи по ее id
     * @param id ID задачи
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
