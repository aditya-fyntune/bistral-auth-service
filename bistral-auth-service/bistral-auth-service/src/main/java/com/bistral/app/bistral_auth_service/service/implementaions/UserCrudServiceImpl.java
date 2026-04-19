package com.bistral.app.bistral_auth_service.service.implementaions;

import com.bistral.app.bistral_auth_service.dtos.CreateUserDto;
import com.bistral.app.bistral_auth_service.dtos.UserResponseDto;
import com.bistral.app.bistral_auth_service.entity.UserEntity;
import com.bistral.app.bistral_auth_service.enums.UserType;
import com.bistral.app.bistral_auth_service.exceptions.UserNotFoundException;
import com.bistral.app.bistral_auth_service.repository.UserRepository;
import com.bistral.app.bistral_auth_service.service.interfaces.UserCrudService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Implementation of {@link  UserCrudService} to provide crud operation for {@link  UserEntity}
 *
 */
@AllArgsConstructor
@Service
public class UserCrudServiceImpl implements UserCrudService, UserDetailsService {

    private final UserRepository userCrudRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    /**
     *
     * @param userSignUpDto required information for creation of user
     * @return
     */
    @Override
    public UserResponseDto createUser(CreateUserDto userSignUpDto) {
        UserEntity userEntity =
                UserEntity.builder()
                        .userEmail(userSignUpDto.getUserEmail())
                        .userName(userSignUpDto.getUserName())
                        .build();
        userEntity.setUserHashPasswd(
                bCryptPasswordEncoder.encode(userSignUpDto.getPassword())
        );
        //TODO As of new we creating system user by default
        userEntity.setUserTypeEnum(UserType.SYSTEM_USER);
        userEntity = userCrudRepository.save(userEntity);
        return UserResponseDto.builder()
                .userEmail(userEntity.getUserEmail())
                .userName(userEntity.getUsername())
                .userId(userEntity.getUserId())
                .userType(userEntity.getUserTypeEnum())
                .build();
    }

    @Override
    public UserResponseDto getUserById(UUID userId) throws UserNotFoundException {
        UserEntity userEntity = userCrudRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId, "User not found with given Id " + userId));

        return UserResponseDto.builder()
                .userEmail(userEntity.getUserEmail())
                .userName(userEntity.getUsername())
                .userId(userEntity.getUserId())
                .userType(userEntity.getUserTypeEnum())
                .build();
    }


    /**
     * get user by username or userEmail based on given input
     * @param username can be userName or userEmail
     * @return {@link  UserDetails} represent user in a system
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userCrudRepository
                .findByUserNameAndIsActiveTrueAndDeletedAtIsNull(username)
                .orElse(userCrudRepository.findByUserEmailAndIsActiveTrueAndDeletedAtIsNull(username)
                        .orElseThrow(()-> new UsernameNotFoundException("User "+username+"not found "))
                );

    }
}
