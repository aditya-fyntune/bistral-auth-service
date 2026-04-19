package com.bistral.app.bistral_auth_service.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;



public class UserNotFoundException extends  Exception{
    private  UUID userId;

    public UserNotFoundException(UUID userId,String message)
    {
        super(message);
        this.userId= userId;
    }

}
