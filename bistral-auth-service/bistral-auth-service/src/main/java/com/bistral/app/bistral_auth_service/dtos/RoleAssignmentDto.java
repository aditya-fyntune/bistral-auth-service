package com.bistral.app.bistral_auth_service.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class RoleAssignmentDto {

    private UUID roleId;
    private UUID branchId;
}
