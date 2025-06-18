package com.raphael.todolist.controller;

import com.raphael.todolist.payload.request.TodoListRequest;
import com.raphael.todolist.payload.response.ApiResponses;
import com.raphael.todolist.payload.response.TodoListResponse;
import com.raphael.todolist.service.TodoListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todolist/v1")
public class TodoListController {
    private final TodoListService service;

    public TodoListController(TodoListService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponses<TodoListResponse>> insertTask(@RequestBody TodoListRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(request));
    }
}
