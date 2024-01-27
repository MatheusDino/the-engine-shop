CREATE TABLE clientes
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    first_name  VARCHAR(255)                            NOT NULL,
    last_name   VARCHAR(255)                            NOT NULL,
    cpf         VARCHAR(255)                            NOT NULL,
    email       VARCHAR(255)                            NOT NULL,
    password    VARCHAR(255)                            NOT NULL,
    postal_code VARCHAR(255)                            NOT NULL,
    street      VARCHAR(255)                            NOT NULL,
    CONSTRAINT pk_cliente PRIMARY KEY (id)
);

ALTER TABLE clientes
    ADD CONSTRAINT uc_cliente_cpf UNIQUE (cpf);

ALTER TABLE clientes
    ADD CONSTRAINT uc_cliente_email UNIQUE (email);