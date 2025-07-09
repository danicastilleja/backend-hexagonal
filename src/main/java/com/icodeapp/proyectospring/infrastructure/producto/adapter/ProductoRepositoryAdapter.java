package com.icodeapp.proyectospring.infrastructure.producto.adapter;

import com.icodeapp.proyectospring.domain.producto.model.Producto;
import com.icodeapp.proyectospring.domain.producto.port.ProductoRepositoryPort;
import com.icodeapp.proyectospring.infrastructure.producto.entity.ProductoEntity;
import com.icodeapp.proyectospring.infrastructure.producto.mapper.ProductoEntityMapper;
import com.icodeapp.proyectospring.infrastructure.producto.repository.JpaProductoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductoRepositoryAdapter implements ProductoRepositoryPort {

    private final JpaProductoRepository jpaProductoRepository;
    private final ProductoEntityMapper mapper;

    public ProductoRepositoryAdapter(JpaProductoRepository jpaProductoRepository, ProductoEntityMapper mapper) {
        this.jpaProductoRepository = jpaProductoRepository;
        this.mapper = mapper;
    }

    @Override
    public Producto createProducto(Producto producto) {
        ProductoEntity entity = this.mapper.toEntity(producto);
        ProductoEntity saved = this.jpaProductoRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public List<Producto> getAllProductos() {
        return this.jpaProductoRepository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Producto> getProductoById(Long id) {
        return this.jpaProductoRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public boolean existsById(Long id) {
        return this.jpaProductoRepository.existsById(id);
    }

    @Override
    public void deleteProducto(Long id) {
        this.jpaProductoRepository.deleteById(id);
    }

    @Override
    public Producto updateProducto(Producto productoForUpdated) {
        ProductoEntity entity = mapper.toEntity(productoForUpdated);
        ProductoEntity updated = this.jpaProductoRepository.save(entity);
        return mapper.toDomain(updated);
    }
}
