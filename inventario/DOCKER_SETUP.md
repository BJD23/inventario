# Inventario App - Docker Setup

## Requisitos
- Docker y Docker Compose instalados

## Opción 1: Desde Docker Hub (Recomendado)

```bash
# Clonar el repositorio o descargar el docker-compose.yml
docker compose pull
docker compose up -d
```

La aplicación estará disponible en `http://localhost:8081`

## Opción 2: Construir localmente

```bash
docker compose up -d --build
```

## Verificar estado

```bash
docker compose ps
```

Deberías ver:
- `inventario-db` en estado `healthy`
- `inventario-app` en estado `up`

## Parar los contenedores

```bash
docker compose down
```

## Notas importantes

- **NO usar `docker run`** - La app necesita Postgres, usa `docker compose`
- La base de datos se persiste en un volumen Docker
- La app se reinicia automáticamente si falla
- Los healthchecks monitorean ambos servicios

## Conectar a la base de datos

```bash
psql -h localhost -U postgres -d inventariodb
# Contraseña: postgres
```
