package com.bistral.app.bistral_auth_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResourceRepository extends JpaRepository<ResourceRepository, UUID> {
}
