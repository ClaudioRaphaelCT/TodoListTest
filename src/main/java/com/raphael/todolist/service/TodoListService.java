package com.raphael.todolist.service;

import com.raphael.todolist.mappers.TodoListMapper;
import com.raphael.todolist.model.TodoList;
import com.raphael.todolist.payload.request.TodoListRequest;
import com.raphael.todolist.payload.response.ApiResponses;
import com.raphael.todolist.payload.response.TodoListResponse;
import com.raphael.todolist.repositories.TodoListRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoListService {
    private final TodoListRepository repository;
    private final TodoListMapper mapper;

    public TodoListService(TodoListRepository repository, TodoListMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ApiResponses<TodoListResponse> insert(TodoListRequest request) {
        TodoList todoList = mapper.toEntity(request);
        TodoList save = repository.save(todoList);
        TodoListResponse response = mapper.toDTO(save);
        return ApiResponses.messageInsertOk(response);

    }
}
