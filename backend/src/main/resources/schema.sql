CREATE TABLE role
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(30) UNIQUE NOT NULL
);

CREATE TABLE account
(
    id         SERIAL PRIMARY KEY,
    username   VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    password   VARCHAR(500) NOT NULL,
    email      VARCHAR(150),
    role_id    INTEGER REFERENCES role (id) ON DELETE CASCADE,
    enabled    BOOLEAN
);

CREATE TABLE vaccine
(
    id              SERIAL PRIMARY KEY,
    name            VARCHAR(100) NOT NULL,
    description     TEXT
);

CREATE TABLE disease
(
    id          INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name        VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT pk_disease PRIMARY KEY (id)
);