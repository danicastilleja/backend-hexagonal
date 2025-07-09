package com.icodeapp.proyectospring.application.producto.usecase.impl;

import com.icodeapp.proyectospring.application.producto.usecase.GetProductoUseCase;
import com.icodeapp.proyectospring.domain.exception.model.ResourceNotFoundException;
import com.icodeapp.proyectospring.domain.producto.model.Producto;
import com.icodeapp.proyectospring.domain.producto.port.ProductoRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetProductoUseCaseImpl implements GetProductoUseCase {

    private final ProductoRepositoryPort productoRepositoryPort;

    public GetProductoUseCaseImpl(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public Producto getProducto(Long id) {
        Optional<Producto> producto = this.productoRepositoryPort.getProductoById(id);
        if(producto.isEmpty()){
            throw new ResourceNotFoundException("Recurso con id: " + id + " no encontrado.");
        }
        return producto.get();
    }
}
