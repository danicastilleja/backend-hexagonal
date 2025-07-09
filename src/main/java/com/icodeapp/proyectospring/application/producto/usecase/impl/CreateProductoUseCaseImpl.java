package com.icodeapp.proyectospring.application.producto.usecase.impl;

import com.icodeapp.proyectospring.application.producto.usecase.CreateProductoUseCase;
import com.icodeapp.proyectospring.domain.producto.model.Producto;
import com.icodeapp.proyectospring.domain.producto.port.ProductoRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class CreateProductoUseCaseImpl implements CreateProductoUseCase {

    private final ProductoRepositoryPort productoRepositoryPort;

    public CreateProductoUseCaseImpl(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public Producto createProducto(Producto producto) {
        return productoRepositoryPort.createProducto(producto);
    }
}
