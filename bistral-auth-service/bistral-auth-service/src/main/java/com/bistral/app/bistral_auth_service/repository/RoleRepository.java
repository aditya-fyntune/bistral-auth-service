package com.bistral.app.bistral_auth_service.repository;

import com.bistral.app.bistral_auth_service.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Repository interface for managing {@link RoleEntity}.
 * Provides CRUD operations as well as other custom data access method.
 */
public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {

}
