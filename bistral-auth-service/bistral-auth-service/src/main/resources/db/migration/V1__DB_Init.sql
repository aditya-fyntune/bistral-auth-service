
--
-- user type enum to maintain consistency
--
CREATE TYPE user_type_enum AS ENUM ('SYSTEM_USER','TENANT_USER')

--
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--
CREATE TABLE user_entity(
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
CREATE UNIQUE INDEX unique_active_username   ON user_entity(lower(user_name))   WHERE deleted_at  IS NULL;
CREATE UNIQUE INDEX unique_active_user_email   ON user_entity(lower(user_email))   WHERE deleted_at IS NULL;


create Table action_entity(
    action_id uuid primary key,
    action_name varchar(100) not null,
    created_by uuid not null references user_entity(user_id),
    created_at  timestamp not null,
    updated_at  timestamp,
    updated_by uuid references user_entity(user_id)
);
create unique index unique_action_name on action_entity(lower(action_name));


CREATE TABLE user_role_entity(
    user_role_id uuid  primary key,
    role_name varchar(100) not null,
    bistro_id uuid not null,
    created_at timestamp not null,
    created_by uuid not null  references user_entity(user_id),
    updated_at timestamp,
    updated_by uuid   references user_entity(user_id)
)

create unique index unique_user_role_name on user_role_entity(lower(role_name),bistro_id);


CREATE TABLE user_role_mapping_entity(
    user_role_mapping_id uuid primary key,
    role_id uuid not null   references user_role_entity(user_role_id) on delete cascade,
    user_id uuid not null   references user_entity(user_id) ,
    bistro_id uuid not null ,
    branch_id uuid not null,
    created_at timestamp not null,
    created_by uuid not null   references user_entity(user_id),
    updated_at timestamp,
    updated_by uuid   references user_entity(user_id),
    CONSTRAINT unique_user_role unique(user_id,role_id,bistro_id,branch_id)
)


CREATE TABLE resource_entity(
    resources_id uuid primary key,
    resources_name varchar(100) not null,
    created_at timestamp not null,
    created_by uuid not null  references user_entity(user_id),
    updated_at timestamp,
    updated_by uuid references user_entity(user_id)
)

create unique index unique_resource_name on resource_entity(lower(resources_name));


CREATE TABLE role_permission_table_entity(
    role_permission_id uuid primary key,
    user_role_id uuid not null references user_role_entity(user_role_id) on delete cascade,
    resources_id uuid not null references resource_entity(resources_id) ,
    action_id uuid not null   references action_entity(action_id) ,
    created_at timestamp not null,
    created_by uuid not null   references user_entity(user_id),
    updated_at timestamp,
    updated_by uuid   references user_entity(user_id),
    CONSTRAINT unique_role_role_permission UNIQUE(user_role_id,action_id,resources_id)

)

CREATE INDEX role_permission on role_permission_table_entity(user_role_id,resources_id,action_id);
CREATE INDEX user_role_idx on user_role_mapping_entity(user_id,bistro_id,branch_id);
