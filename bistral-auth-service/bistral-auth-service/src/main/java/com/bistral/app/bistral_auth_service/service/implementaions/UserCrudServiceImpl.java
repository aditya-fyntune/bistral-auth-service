package com.bistral.app.bistral_auth_service.service.implementaions;

import com.bistral.app.bistral_auth_service.dtos.CreateUserDto;
import com.bistral.app.bistral_auth_service.dtos.UserResponseDto;
import com.bistral.app.bistral_auth_service.entity.UserEntity;
import com.bistral.app.bistral_auth_service.repository.UserRepository;
import com.bistral.app.bistral_auth_service.service.interfaces.UserCrudService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@AllArgsConstructor
@Service
public class UserCrudServiceImpl implements UserCrudService {

    private final UserRepository userCrudRepository;


    @Override
    public UserResponseDto createUser(CreateUserDto userSignUpDto) {
        UserEntity userEntity =
                UserEntity.builder()
                        .userEmail(userSignUpDto.getUserEmail())
                        .userName(userSignUpDto.getUserName())
                        .build();
        userEntity = userCrudRepository.save(userEntity);
        return UserResponseDto.builder()
                .userEmail(userEntity.getUserEmail())
                .userName(userEntity.getUserName())
                .userId(userEntity.getUserId())
                .build();
    }

    @Override
    public UserResponseDto getUserById(UUID userId) {
        return null;
    }


}
