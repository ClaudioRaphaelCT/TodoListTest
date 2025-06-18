package com.raphael.todolist.payload.request;

public record TodoListRequest(String person, String task, int priority) {
}
