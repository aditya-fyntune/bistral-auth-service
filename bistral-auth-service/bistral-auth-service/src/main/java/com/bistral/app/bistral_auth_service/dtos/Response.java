package com.bistral.app.bistral_auth_service.dtos;


import lombok.Data;

@Data
public class Response <T> {
    String message;
    Integer status;
    Boolean isError;
    T data;
}
