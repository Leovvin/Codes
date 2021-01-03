package com.example.demo.mall.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseEntity<T> {
    boolean isSuccess;
    
    List<ErrorMsg> errors;
    T data;
    ResponseEntity(T data){
        this.isSuccess = true;
        this.data = data;
    }

    ResponseEntity(List<ErrorMsg> errors){
        this.isSuccess = false;
        this.errors = errors;
    }

    public static <T> ResponseEntity success(T t){
        return new ResponseEntity(t);
    }
    public static <T> ResponseEntity failed(List<ErrorMsg> errors){
        return new ResponseEntity(errors);
    }
}
