package com.bistral.app.bistral_auth_service.repository;

import com.bistral.app.bistral_auth_service.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for managing {@link RoleEntity}.
 * Provides CRUD operations as well as other custom data access method.
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {

}
