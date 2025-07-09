package com.icodeapp.proyectospring.infrastructure.producto.repository;

import com.icodeapp.proyectospring.infrastructure.producto.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductoRepository extends JpaRepository<ProductoEntity, Long> {
}
