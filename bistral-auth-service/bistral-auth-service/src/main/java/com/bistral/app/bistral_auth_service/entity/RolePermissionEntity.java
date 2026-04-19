package com.bistral.app.bistral_auth_service.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class RolePermissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "role_permission_id")
    private UUID rolePermissionId;

}