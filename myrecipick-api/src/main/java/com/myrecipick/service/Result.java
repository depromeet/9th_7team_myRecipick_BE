package com.myrecipick.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Data
public class Result<T> {
    private int status;
    private String message;
    private T data;

    public Result(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private Result(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static Result of(HttpStatus httpStatus, String message) {
        int status = Optional.ofNullable(httpStatus)
            .orElse(HttpStatus.OK)
            .value();
        return new Result<>(status, message, null);
    }

    public static <T> Result<T> of(HttpStatus httpStatus, String message, T data) {
        int status = Optional.ofNullable(httpStatus)
            .orElse(HttpStatus.OK)
            .value();
        return new Result<>(status, message, data);
    }
}
