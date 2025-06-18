package com.raphael.todolist.repositories;

import com.raphael.todolist.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {
}
