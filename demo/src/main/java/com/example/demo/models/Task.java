package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Класс задачи
 */
@Data
@Entity(name = "tasks")
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private LocalDateTime dateCreate;
}
