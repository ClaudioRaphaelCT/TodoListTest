package com.raphael.todolist.payload.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public record ApiResponses<T>(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime timestamp,
        String message,
        T data
) {
    public static <T> ApiResponses<T> messageInsertOk(T data) {
        return new ApiResponses<>(
                LocalDateTime.now(),
                "Task insert successfully.",
                data

        );
    }

    public static <T> ApiResponses<List<T>> messageFindAllOk(List<T> persons) {
        return new ApiResponses<>(
                LocalDateTime.now(),
                "Task insert successfully.",
                persons

        );
    }
}
