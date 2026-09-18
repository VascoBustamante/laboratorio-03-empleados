-- Base de datos utilizada por el Laboratorio 03
-- Sistema de gestión de empleados

CREATE TABLE IF NOT EXISTS empleados (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    rol VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS usuarios_login (
    id BIGSERIAL PRIMARY KEY,
    usuario VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);