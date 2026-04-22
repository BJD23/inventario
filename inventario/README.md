# API Rest - Gestión de Productos

API REST completa para gestionar el inventario de productos de una tienda, construida en Spring Boot, Gradle, PostgreSQL y dockerizada.

## Tecnologías
- Spring Boot 4.0.5
- Gradle
- PostgreSQL 16
- JPA - Hibernate
- Docker & Docker Compose

---

## Quick Start - SIN CLONAR NADA (Opción más fácil)

```bash
# Descarga solo el archivo docker-compose
curl -O https://raw.githubusercontent.com/BJD23/inventario/main/docker-compose.standalone.yml

# Renombralo a docker-compose.yml
mv docker-compose.standalone.yml docker-compose.yml

# Levanta los servicios
docker compose up -d

# La app estará en http://localhost:8081
```

O con wget:
```bash
wget https://raw.githubusercontent.com/BJD23/inventario/main/docker-compose.standalone.yml -O docker-compose.yml
docker compose up -d
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

## Quick Start - CON REPOSITORIO (Para desarrollo)

```bash
# 1. Clonar el repositorio
git clone https://github.com/BJD23/inventario
cd inventario

# 2. Iniciar con Docker Compose (construye localmente para desarrollo)
docker compose up -d

# La app estará en http://localhost:8081
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

- **Host:** `db` (interno en Docker)
- **Puerto:** 5432
- **Database:** `inventariodb`
- **Usuario:** `postgres`
- **Contraseña:** `postgres`

### Puertos

- **App:** Puerto 8080 interno → 8081 externo
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

# Ver estado detallado
docker inspect inventario-app
```

---

## Variables de Entorno Personalizadas

Si quieres cambiar credenciales o puerto, edita el `docker-compose.yml` antes de ejecutar:

```yaml
environment:
  DB_HOST: db
  DB_PORT: "5432"
  DB_USER: postgres
  DB_PASSWORD: tu_contraseña_aqui
```

Luego ejecuta:
```bash
docker compose up -d
```

---

## Archivos Docker Compose

- **`docker-compose.standalone.yml`** - Usa la imagen de Docker Hub (SIN clonar repo) ⭐
- **`docker-compose.prod.yml`** - Usa la imagen de Docker Hub (necesita repo)
- **`docker-compose.yml`** - Construye la imagen localmente (para desarrollo)

---

## Troubleshooting

**"Connection refused"**
- Asegúrate de que Postgres esté saludable: `docker compose ps`
- Espera 10 segundos a que Postgres inicie completamente

**Puerto ya en uso**
- Cambia el puerto en `docker-compose.yml`: `"8082:8080"` en lugar de `"8081:8080"`

**Ver logs completos**
```bash
docker compose logs -f
```

---

## Autor

Sebastian Carrillo
