package com.bistral.app.bistral_auth_service.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Api Contract object represent sign up field for <code>userEntity</code>
 * <p>
 *     <ul>
 *         <li><code>userName</code> must not be null or empty</li>
 *         <li><code>userEmail</code>user email should be valid and unique</li>
 *         <li><code>password</code> A password should consist of alphabets, number and special symbols with minimum length of 8 </li>
 *     </ul>
 * </p>
 *
 */
@Data

public class UserSignUpDto {

    @NotNull
    @Min(4)
    private String userName;
    @Email
    private String userEmail;
    @NotNull
    @NotBlank
    private String password;

}
