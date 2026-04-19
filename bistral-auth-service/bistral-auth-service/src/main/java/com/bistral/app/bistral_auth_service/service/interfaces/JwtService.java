package com.bistral.app.bistral_auth_service.service.interfaces;

import com.bistral.app.bistral_auth_service.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
/**
 * Service interface for generating JWT tokens.
 *
 * Defines contract for creating access and refresh tokens
 * for authenticated users.
 */
public interface JwtService {



    /**
     * Generates a short-lived access token for the given user.
     *
     * @param user the authenticated user
     * @return JWT access token
     */
    public String getAccessToken(UserEntity user) throws Exception;

    /**
     * Generates a long-lived refresh token for the given user.
     *
     * @param user the authenticated user
     * @return JWT refresh token
     */
    public String getRefreshToken(UserEntity user) throws Exception;
}
