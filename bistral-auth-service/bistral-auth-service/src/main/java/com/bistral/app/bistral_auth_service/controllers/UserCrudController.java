package com.bistral.app.bistral_auth_service.controllers;


import com.bistral.app.bistral_auth_service.dtos.ApiResponse;
import com.bistral.app.bistral_auth_service.dtos.CreateUserDto;
import com.bistral.app.bistral_auth_service.service.interfaces.UserCrudService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * API Endpoint for user crud operations.
 *
 */
@AllArgsConstructor
@RestController("/user")
public class UserCrudController {

    private final UserCrudService userCrudService;


    @PostMapping("")
    public ApiResponse<?> createUser(@Valid @RequestBody CreateUserDto userSignUpDto){
        userCrudService.createUser(userSignUpDto);
        return null;
    }

    @GetMapping("/{userId}")
    public void getUserDto(){

    }


}
