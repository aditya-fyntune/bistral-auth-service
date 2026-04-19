
--
-- user type enum to maintain consistency
--
CREATE TYPE user_type_enum AS ENUM ('SYSTEM_USER','TENANT_USER');

--
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--
CREATE TABLE bistral_users(
    user_id uuid Not NULL primary key,
    user_name varchar(100) NOT NULL ,
    user_email varchar(100) NOT NULL ,
    password_hash varchar(300) NOT NULL,
    user_type user_type_enum NOT NULL,
    created_at  timestamp not null,
    updated_at  timestamp,
    is_active boolean default true not null,
    deleted_at timestamp
);
CREATE UNIQUE INDEX unique_active_username   ON bistral_users(lower(user_name))   WHERE deleted_at  IS NULL;
CREATE UNIQUE INDEX unique_active_user_email   ON bistral_users(lower(user_email))   WHERE deleted_at IS NULL;


create Table actions(
    action_id uuid primary key,
    action_name varchar(100) not null,
    created_by uuid not null references bistral_users(user_id),
    created_at  timestamp not null,
    updated_at  timestamp,
    updated_by uuid references bistral_users(user_id)
);
create unique index unique_action_name on actions(lower(action_name));


CREATE TABLE user_roles(
    user_role_id uuid  primary key,
    role_name varchar(100) not null,
    bistro_id uuid not null,
    created_at timestamp not null,
    created_by uuid not null  references bistral_users(user_id),
    updated_at timestamp,
    updated_by uuid   references bistral_users(user_id)
);

create unique index unique_user_role_name on user_roles(lower(role_name),bistro_id);


CREATE TABLE user_role_mappings(
    user_role_mapping_id uuid primary key,
    role_id uuid not null   references user_roles(user_role_id) on delete cascade,
    user_id uuid not null   references bistral_users(user_id) ,
    bistro_id uuid not null ,
    branch_id uuid not null,
    created_at timestamp not null,
    created_by uuid not null   references bistral_users(user_id),
    updated_at timestamp,
    updated_by uuid   references bistral_users(user_id),
    CONSTRAINT unique_user_role unique(user_id,role_id,bistro_id,branch_id)
);


CREATE TABLE resources(
    resource_id uuid primary key,
    resource_name varchar(100) not null,
    created_at timestamp not null,
    created_by uuid not null  references bistral_users(user_id),
    updated_at timestamp,
    updated_by uuid references bistral_users(user_id)
);

create unique index unique_resource_name on resources(lower(resource_name));


CREATE TABLE role_permissions(
    role_permission_id uuid primary key,
    user_role_id uuid not null references user_roles(user_role_id) on delete cascade,
    resource_id uuid not null references resources(resource_id) ,
    action_id uuid not null   references actions(action_id) ,
    created_at timestamp not null,
    created_by uuid not null   references bistral_users(user_id),
    updated_at timestamp,
    updated_by uuid   references bistral_users(user_id),
    CONSTRAINT unique_role_role_permission UNIQUE(user_role_id,action_id,resource_id)

);

CREATE INDEX role_permission on role_permissions(user_role_id,resource_id,action_id);
CREATE INDEX user_role_idx on user_role_mappings(user_id,bistro_id,branch_id);
