--liquibase formatted sql
--changeset sergei:3fa68a7a-87a0-4010-a8f3-5320c5e03c54

CREATE TABLE clients(
                        client_id BIGINT PRIMARY KEY,
                        client_name VARCHAR(45) NOT NULL
);

--rollback DROP TABLE product;