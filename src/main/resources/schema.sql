DROP TABLE IF EXISTS client;
CREATE TABLE client
(
    id                   VARCHAR(255) NOT NULL,
    first_name            VARCHAR(255),
    last_name             VARCHAR(255),
    date_of_birth          VARCHAR(255),
    driving_license_number VARCHAR(255),
    license_validity      BOOLEAN,
    animal               VARCHAR(255),
    PRIMARY KEY (id)
);