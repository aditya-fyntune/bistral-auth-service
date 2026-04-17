package com.bistral.app.bistral_auth_service.dtos;


import com.bistral.app.bistral_auth_service.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

/**
 * Data Transfer Object representing user details exposed in API responses.
 *
 * <p>
 * This DTO contains only non-sensitive and required user information
 * that is safe to return to clients. It excludes confidential fields
 * such as password or internal audit data.
 * </p>
 *
 * <p>
 * Typically used in user-related API responses such as fetching user details.
 * </p>
 */
@Builder
@AllArgsConstructor
@Data
public class UserResponseDto {

    private UUID userId;
    private String userName;
    private String userEmail;
    private UserType userType;

}
