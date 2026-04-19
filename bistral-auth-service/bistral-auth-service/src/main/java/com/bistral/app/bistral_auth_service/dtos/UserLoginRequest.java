package com.bistral.app.bistral_auth_service.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
public class UserLoginRequest {

    @NotNull
    @NotBlank
    @Length(
            min = 4,
            max = 100
    )
    private String userName;
    @NotBlank
    @NotNull
    @Length(
            min = 4,
            max = 100
    )
    private String password;
}
