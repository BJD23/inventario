# API Rest -productos de productos

API REST completa para gestionar el productos de una tienda, construida en Spring Boot, Gradle, postgres y
dockerizada.

## Tecnologías
- Spring Boot 4.0.5
- Gradle
- PostgreSQL
- JPA - hibernate
- Docker, Docker compose

## Como ejecutar localmente
``` bash
# 1. Clonar el repositorio
git clone https://github.com/BJD23/inventario

# 2. Entrar en la carpeta del repositorio
cd inventario

# 3. Ejecutar con Docker compose
docker compose up --build
```



## Endpoints


Base de datos: PostgreSQL (5433)

| Método | Endpoint | Descripción |
| --- | --- | ---
|GET | /api/productos | Lista todos los productos|
|GET | /api/productos/{id} | Obtiene un producto por su id|
|POST | /api/productos| Crea un nuevo producto|
|PUT | /api/productos/{id}| Actualiza un producto por su id|
|DELETE | /api/productos/{id}| Elimina un producto por su id|



##
