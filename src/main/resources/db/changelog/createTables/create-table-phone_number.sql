--liquibase formatted sql
--changeset sergei:01f3870b-a432-4952-b7bd-7255da6b98df

CREATE TABLE phone_number(
                        client_id BIGINT,
                        phone_number VARCHAR(12) UNIQUE NOT NULL,
                        FOREIGN KEY (client_id) REFERENCES clients (client_id) ON DELETE CASCADE
);

--rollback DROP TABLE phone_number;