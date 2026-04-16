package com.bistral.app.bistral_auth_service.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserNotFoundException extends  Exception{
    private  UUID userId;
    private  String userName;

}
