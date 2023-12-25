CREATE TABLE TB_PARTNERS (
    idpartner UUID PRIMARY KEY UNIQUE,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    partnertype INTEGER NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    active BOOLEAN
);