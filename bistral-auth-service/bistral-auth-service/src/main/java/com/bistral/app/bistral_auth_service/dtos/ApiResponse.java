package com.bistral.app.bistral_auth_service.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ApiResponse<T> {
    String message;
    Integer status;
    Boolean isError;
    T data;
}
