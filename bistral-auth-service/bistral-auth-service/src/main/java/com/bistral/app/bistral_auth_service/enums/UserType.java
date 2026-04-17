package com.bistral.app.bistral_auth_service.enums;


/**
 * UserType Enum represent type of user in system
 * <ul>
 *     <li><Code>System User</Code> represent user type of system mean can access api related to system only</li>
 *     <li><code>Tenant User</code> represent user tenant can access resources allowed to them only</li>
 * </ul>
 *
 */
public enum UserType {
    SYSTEM_USER,
    TENANT_USER
}
