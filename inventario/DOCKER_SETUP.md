# Inventario App - Docker Deployment Guide

## Para otros usuarios desde Docker Hub

**IMPORTANTE:** Esta app requiere PostgreSQL. No uses `docker run` sin una base de datos.

### Opción 1: Usar Docker Compose (Recomendado ✅)

1. **Descarga el docker-compose.yml** desde el repositorio:
```bash
wget https://raw.githubusercontent.com/BJD23/inventario/main/docker-compose.yml
```

2. **Inicia los servicios:**
```bash
docker compose up -d
```

La app estará en `http://localhost:8081`

---

### Opción 2: Correr con una BD existente

Si ya tienes PostgreSQL corriendo en tu máquina (puerto 5432):

```bash
docker run -p 8080:8080 \
  -e DB_HOST=host.docker.internal \
  -e DB_PORT=5432 \
  -e DB_USER=tu_usuario \
  -e DB_PASSWORD=tu_contraseña \
  sebastianc23/inventario-app:latest
```

---

### Opción 3: Correr PostgreSQL y la app por separado con Docker

```bash
# Terminal 1: PostgreSQL
docker run -d --name inventario-db \
  -e POSTGRES_DB=inventariodb \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -p 5432:5432 \
  postgres:16-alpine

# Terminal 2: App (espera 5 segundos a que Postgres inicie)
docker run -p 8080:8080 \
  -e DB_HOST=host.docker.internal \
  sebastianc23/inventario-app:latest
```

---

## Verificar estado

```bash
docker compose ps
```

Deberías ver:
- `inventario-db`: Healthy ✅
- `inventario-app`: Up ✅

## Parar todo

```bash
docker compose down
```

## Notas

- Los datos de la BD se persisten en un volumen Docker
- La app se reinicia automáticamente si falla  
- Los healthchecks monitorean ambos servicios
