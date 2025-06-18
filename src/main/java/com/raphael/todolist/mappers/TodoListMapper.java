package com.raphael.todolist.mappers;

import com.raphael.todolist.model.TodoList;
import com.raphael.todolist.payload.request.TodoListRequest;
import com.raphael.todolist.payload.response.TodoListResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoListMapper {
    TodoListResponse toDTO(TodoList todoList);

    TodoList toEntity(TodoListRequest todoListRequest);
}
