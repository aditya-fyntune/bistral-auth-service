package com.bistral.app.bistral_auth_service.repository;

import com.bistral.app.bistral_auth_service.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Repository interface for managing {@link com.bistral.app.bistral_auth_service.entity.UserEntity}.
 *
 * <p>
 * Provides CRUD operations for user data including support for
 * soft deletion (via deletedAt) and active status (isActive flag).
 * </p>
 *
 * <p>
 * Consumers should ensure filtering of inactive or soft-deleted users
 * where applicable at the service or query level.
 * </p>
 */
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

}
