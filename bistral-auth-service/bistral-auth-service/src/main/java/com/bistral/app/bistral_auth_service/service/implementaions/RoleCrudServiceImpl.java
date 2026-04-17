package com.bistral.app.bistral_auth_service.service.implementaions;

import com.bistral.app.bistral_auth_service.dtos.PageResponse;
import com.bistral.app.bistral_auth_service.dtos.RoleFilterRequest;
import com.bistral.app.bistral_auth_service.dtos.RoleRequestDto;
import com.bistral.app.bistral_auth_service.dtos.RoleResponseDto;
import com.bistral.app.bistral_auth_service.repository.RoleRepository;
import com.bistral.app.bistral_auth_service.service.interfaces.RoleCrudService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class RoleCrudServiceImpl implements RoleCrudService {
    private final RoleRepository roleRepository;


    @Override
    public RoleResponseDto createRole(RoleRequestDto roleRequestDto) {
        return null;
    }

    @Override
    public RoleResponseDto getRoleById(UUID roleId) {
        return null;
    }

    @Override
    public PageResponse<RoleResponseDto> getListOfRoles(RoleFilterRequest filterRequest, Integer page, Integer size) {
        return null;
    }
}
