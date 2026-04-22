# API Rest - Gestión de Productos

API REST completa para gestionar el inventario de productos de una tienda, construida en Spring Boot, Gradle, PostgreSQL y dockerizada.

## Tecnologías
- Spring Boot 4.0.5
- Gradle
- PostgreSQL 16
- JPA - Hibernate
- Docker & Docker Compose

## Quick Start - Docker Compose (Recomendado)

```bash
# 1. Clonar el repositorio
git clone https://github.com/BJD23/inventario
cd inventario

# 2. Iniciar con Docker Compose (incluye la BD automáticamente)
docker compose up -d

# La app estará en http://localhost:8081
```

**Verifica el estado:**
```bash
docker compose ps
```

**Parar los servicios:**
```bash
docker compose down
```

---

## Ejecución Local sin Docker

```bash
# 1. Asegurate de tener PostgreSQL corriendo en tu máquina
# 2. Configura las credenciales en application.properties
# 3. Ejecuta con Gradle
./gradlew bootRun
```

---

## Docker Hub

Si quieres usar la imagen desde Docker Hub, **debes usar Docker Compose** (no `docker run` solo).

**Opción 1: Con Docker Compose (recomendado)**
```bash
docker compose pull
docker compose up -d
```

**Opción 2: Con PostgreSQL existente**
```bash
docker run -p 8080:8080 \
  -e DB_HOST=host.docker.internal \
  -e DB_PORT=5432 \
  -e DB_USER=postgres \
  -e DB_PASSWORD=postgres \
  sebastianc23/inventario-app:latest
```

Ver más opciones en [DOCKER_SETUP.md](./DOCKER_SETUP.md)

---

## API Endpoints

| Método | Endpoint | Descripción |
| --- | --- | --- |
| GET | `/api/productos` | Lista todos los productos |
| GET | `/api/productos/{id}` | Obtiene un producto por ID |
| POST | `/api/productos` | Crea un nuevo producto |
| PUT | `/api/productos/{id}` | Actualiza un producto |
| DELETE | `/api/productos/{id}` | Elimina un producto |

---

## Configuración

### Base de Datos

- **Host:** `localhost` (o `db` en Docker)
- **Puerto:** 5432
- **Database:** `inventariodb`
- **Usuario:** `postgres`
- **Contraseña:** `postgres`

### Puertos

- **App:** Puerto 8080 (mapeado a 8081 en Docker)
- **BD:** Puerto 5432

---

## Monitoreo

La app incluye health checks automáticos:

```bash
# Ver logs de la app
docker compose logs inventario-app

# Ver logs de la BD
docker compose logs inventario-db

# Ver estado en tiempo real
docker compose ps
```

---

## Variables de Entorno

Puedes personalizar la conexión a BD con variables de entorno:

```bash
docker run -p 8080:8080 \
  -e DB_HOST=tu_host \
  -e DB_PORT=tu_puerto \
  -e DB_USER=tu_usuario \
  -e DB_PASSWORD=tu_contraseña \
  sebastianc23/inventario-app:latest
```

---

## Autor

Sebastian Carrillo
