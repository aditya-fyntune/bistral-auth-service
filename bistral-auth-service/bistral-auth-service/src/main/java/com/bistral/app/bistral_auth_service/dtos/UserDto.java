package com.bistral.app.bistral_auth_service.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserDto {
    private UUID userId;
    private String userName;
    private String userEmail;
}
