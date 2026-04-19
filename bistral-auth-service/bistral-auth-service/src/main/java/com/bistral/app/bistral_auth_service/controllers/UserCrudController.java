package com.bistral.app.bistral_auth_service.controllers;


import com.bistral.app.bistral_auth_service.dtos.ApiResponse;
import com.bistral.app.bistral_auth_service.dtos.CreateUserDto;
import com.bistral.app.bistral_auth_service.dtos.UserResponseDto;
import com.bistral.app.bistral_auth_service.exceptions.UserNotFoundException;
import com.bistral.app.bistral_auth_service.service.interfaces.UserCrudService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * API Endpoint for user crud operations.
 *
 */
@AllArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserCrudController {

    private final UserCrudService userCrudService;


    @PostMapping
    public ApiResponse<UserResponseDto> createUser(@Valid @RequestBody CreateUserDto userSignUpDto){
       return ApiResponse.<UserResponseDto>builder()
               .message("Sign up Success fully")
               .data(userCrudService.createUser(userSignUpDto))
               .build();

    }

    @GetMapping("/{userId}")
    public ApiResponse<Object> findUserById(@PathVariable UUID userId) throws UserNotFoundException {
        return  ApiResponse
                .builder()
                .data(userCrudService.getUserById(userId))
                .message("user fetch success fully")
                .build();
    }



}
