package com.bistral.app.bistral_auth_service.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.management.relation.Role;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represent A mapping between {@link UserEntity} user  and {@link RoleEntity} role,
 * mean a role of <code>Bistro</code> assigned to user
 * <note>
 *     Each user must have assign one role only once , but user can have
 *     multiple roles in one or different bistros.
 * </note>
 */
@Table
        (name = "user_role_mappings",
                uniqueConstraints =
                        {
                                @UniqueConstraint(
                                        name = "unique_user_role",
                                        columnNames = {
                                                "user_id","role_id","bistro_id","branch_id"
                                        }
                                )
                        }
        )
@Getter
@Setter
@Builder
public class UserRoleMappingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_role_mapping_id")
    private UUID userRoleMappingId;

    @ManyToOne
    @Column(name = "role_id", nullable = false)
    private RoleEntity role;

    @ManyToOne
    @Column(name = "user_id" , nullable = false)
    private UserEntity user;

    @Column(name = "bistro_id", nullable = false)
    private UUID bistro_id;

    @Column(name = "branch_id", nullable = false)
    private  UUID branch_id;

    @ManyToOne
    @Column(name = "created_by", nullable = false)
    private UserEntity createdBy;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "updated_by", nullable = false)
    private UserEntity updated_by;

}
