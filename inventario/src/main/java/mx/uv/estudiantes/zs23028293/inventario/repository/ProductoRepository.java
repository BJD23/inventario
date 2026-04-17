package mx.uv.estudiantes.zs23028293.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.uv.estudiantes.zs23028293.inventario.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
