--liquibase formatted sql
--changeset sergei:604b37d2-5aff-4d00-8a13-be0b72c0e526

CREATE TABLE emails
(
    client_id BIGINT,
    email     VARCHAR(80) UNIQUE NOT NULL check (email RLIKE '[a-zA-Z0-9]@[a-zA-Z0-9]\.[a-z,A-Z]{2,6}'),
    FOREIGN KEY (client_id) REFERENCES clients (client_id) ON DELETE CASCADE
);
--rollback DROP TABLE emails;