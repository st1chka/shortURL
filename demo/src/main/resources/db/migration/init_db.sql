-- liquibase formatted sql

-- changeset kalinine:1.1

CREATE TABLE public.users
(
    id         bigserial NOT NULL,
    "name"     varchar   NULL,
    "password" varchar   NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);


CREATE TABLE public.urlentity
(
    user_id   int8                NULL,
    id        int8 GENERATED ALWAYS AS IDENTITY ( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807
        START 1 CACHE 1 NO CYCLE) NOT NULL,
    long_url  varchar             NOT NULL,
    short_url varchar             NOT NULL,
    CONSTRAINT urlentity_pk PRIMARY KEY (id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id)
);




