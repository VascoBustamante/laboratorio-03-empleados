# Laboratorio 03 - Gestión de Empleados

Aplicación web desarrollada para el curso de Diseño de Software.

El sistema permite autenticar a un administrador y realizar operaciones CRUD sobre empleados.

## Tecnologías utilizadas

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Thymeleaf
- PostgreSQL
- Docker
- Docker Compose
- Maven

## Funcionalidades

### Sistema de Login

La aplicación cuenta con autenticación de usuarios mediante Spring Security.

Las credenciales se validan utilizando la base de datos PostgreSQL.

Credenciales iniciales:

- Usuario: `admin`
- Contraseña: `admin123`

Si las credenciales son incorrectas, se muestra un mensaje de error.

### Gestión de empleados

El sistema permite realizar las siguientes operaciones:

- Crear empleados.
- Listar empleados.
- Editar empleados.
- Eliminar empleados.
- Confirmar antes de eliminar un empleado.

Cada empleado contiene los siguientes atributos:

- ID
- Nombre
- Email
- Rol

## Estructura del proyecto

```text
empleados/
├── database/
│   └── init.sql
├── src/
│   └── main/
│       ├── java/
│       │   └── empleados/
│       │       ├── config/
│       │       ├── controller/
│       │       ├── model/
│       │       ├── repository/
│       │       └── service/
│       └── resources/
│           ├── templates/
│           └── application.properties
├── Dockerfile
├── compose.yaml
├── pom.xml
└── README.md