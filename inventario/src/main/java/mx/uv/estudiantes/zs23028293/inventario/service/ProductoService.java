package mx.uv.estudiantes.zs23028293.inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mx.uv.estudiantes.zs23028293.inventario.entity.Producto;
import mx.uv.estudiantes.zs23028293.inventario.repository.ProductoRepository;

@Service
@RequiredArgsConstructor
public class ProductoService {
    private ProductoRepository repository;

    public List<Producto> listarTodos() {
        return repository.findAll();
    }

    public Optional<Producto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
