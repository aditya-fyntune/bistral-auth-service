package com.bistral.app.bistral_auth_service.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

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
 * </p>
 *
 *
 */
@Entity
@Table(name = "user")
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
}
