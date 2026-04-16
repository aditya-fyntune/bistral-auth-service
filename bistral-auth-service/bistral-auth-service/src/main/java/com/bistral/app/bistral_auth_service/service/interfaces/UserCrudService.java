package com.bistral.app.bistral_auth_service.service.interfaces;

import com.bistral.app.bistral_auth_service.dtos.UserDto;
import com.bistral.app.bistral_auth_service.dtos.UserSignUpDto;

/**
 * provide interface for crud service of global users
 *
 */
public interface UserCrudService {

    /**
     * Create user with given information
     */
    public UserDto createUser(UserSignUpDto userSignUpDto);

    public  void  getUser();
    public  void  getUserList();

}
