package com.bistral.app.bistral_auth_service.service.implementaions;

import com.bistral.app.bistral_auth_service.dtos.UserDto;
import com.bistral.app.bistral_auth_service.dtos.UserSignUpDto;
import com.bistral.app.bistral_auth_service.entity.UserEntity;
import com.bistral.app.bistral_auth_service.exceptions.UserNotFoundException;
import com.bistral.app.bistral_auth_service.repository.UserCrudRepository;
import com.bistral.app.bistral_auth_service.service.interfaces.UserCrudService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@AllArgsConstructor
@Service
public class UserCrudServiceImpl implements UserCrudService {

    private final UserCrudRepository userCrudRepository;

    @Override
    public UserDto createUser(UserSignUpDto userSignUpDto) {
        UserEntity userEntity =
                UserEntity.builder()
                        .userEmail(userSignUpDto.getUserEmail())
                        .userName(userSignUpDto.getUserName())
                        .build();
        userEntity = userCrudRepository.save(userEntity);
        return UserDto.builder()
                .userEmail(userEntity.getUserEmail())
                .userName(userEntity.getUserName())
                .userId(userEntity.getUserId())
                .build();
    }



    @Override
    public void getUser()  {

    }

    @Override
    public void getUserList() {

    }
}
