CREATE TABLE person
(
    id         numeric(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name       VARCHAR(128)           NOT NULL,
    surname    VARCHAR(128)           NOT NULL,
    city       VARCHAR(128)           NOT NULL,
    address    VARCHAR(128)           NOT NULL,
    postalCode numeric(4)             NOT NULL
);