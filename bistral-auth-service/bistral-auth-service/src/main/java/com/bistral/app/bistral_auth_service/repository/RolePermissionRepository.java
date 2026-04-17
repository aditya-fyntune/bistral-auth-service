package com.bistral.app.bistral_auth_service.repository;

import com.bistral.app.bistral_auth_service.entity.RolePermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RolePermissionRepository extends JpaRepository<RolePermissionEntity, UUID> {

}
