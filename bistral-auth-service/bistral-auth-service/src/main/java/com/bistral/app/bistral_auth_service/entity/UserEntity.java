package com.bistral.app.bistral_auth_service.entity;

import com.bistral.app.bistral_auth_service.enums.UserType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represent user in a system and user can be of two type
 * <ul>
 *     <li><code>System User</code> Represent user have access to resource related to system </li>
 *     <li><code>Tenant User</code> Represent user a real user of system who will use system for business purpose and
 *     own resource like bistro, branches order etc
 *     </li>
 *     <li>Each <code>User</code> must have <b>unique email and username</b></li>
 * </ul>
 * <p>Not Null Fields
 *  <ul>
 *      <li>userName</li>
 *      <li>userEmail</li>
 *      <li>userHashPassword</li>
 *  </ul>
 *  <p>
 *      <code>Note</code>
 *      <ul>
 *          <li>A username and userEmail should be unique where deleted at is null</li>
 *          <li>To ensure all active user have unique email and username</li>
 *      </ul>
 *  </p>
 * </p>
 *
 *
 */
@Entity
@Table(name = "user_entity")
@Getter
@Setter
@Builder
public class UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private  UUID userId;

    @Column(nullable = false)
    private  String userName;

    @Column(nullable = false)
    private  String userEmail;
    @Column(nullable = false)
    private  String userHashPasswd;

    @Column
    private UserType userTypeEnum;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Column(nullable = false, columnDefinition = "DEFAULT 0")
    private  Boolean isActive;

    @Column
    private LocalDateTime deletedAt;


}
