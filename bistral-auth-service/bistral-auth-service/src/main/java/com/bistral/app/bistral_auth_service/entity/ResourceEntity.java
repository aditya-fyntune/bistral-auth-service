package com.bistral.app.bistral_auth_service.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * Represent a resource in a System.
 * <code>Example</code>
 * <ul>
 * <li>Bistro</li>
 * <li>Menu</li>
 * <li>Order</li>
 * </ul>
 * <note>
 *     <ul>
 *         <li>A resource should have unique name in system</li>
 *         <li>
 *             <note>
 *                 Resource should be created , update , modify or delete by only system user
 *             </note>
 *         </li>
 *     </ul>
 * </note>
 */
public class ResourceEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    @Column(name = "resource_id")
    private UUID resourceId;
    private String resourceName;

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
