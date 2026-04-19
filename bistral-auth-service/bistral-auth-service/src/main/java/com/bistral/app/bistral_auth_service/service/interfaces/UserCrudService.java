package com.bistral.app.bistral_auth_service.service.interfaces;

import com.bistral.app.bistral_auth_service.dtos.CreateUserDto;
import com.bistral.app.bistral_auth_service.dtos.UserResponseDto;
import com.bistral.app.bistral_auth_service.entity.UserEntity;
import com.bistral.app.bistral_auth_service.exceptions.UserNotFoundException;

import java.util.UUID;

/**
 * provide interface for crud service of global {@link  UserEntity}
 *
 */
public interface UserCrudService {

    /**
     * Create user in system.
     * @param userSignUpDto required information for creation of user
     *
     * @return {@link  UserResponseDto} represent abstraction of {@link UserEntity}
     */
    public UserResponseDto createUser(CreateUserDto userSignUpDto);

    /**
     * Find and Return user of a given id
     * @param userId represent userid
     * @return {@link  UserResponseDto} represent api contract object of {@link  com.bistral.app.bistral_auth_service.entity.UserEntity}
     */
    public UserResponseDto getUserById(UUID userId) throws UserNotFoundException;



}
