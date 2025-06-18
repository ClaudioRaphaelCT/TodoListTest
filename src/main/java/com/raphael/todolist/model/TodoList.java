package com.raphael.todolist.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "todolist")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDateTime createdAt;
    private String person;
    private String task;
    private int priority;

    @PrePersist
    protected void setCreatedAt(){
        this.createdAt = LocalDateTime.now();
    }
}
