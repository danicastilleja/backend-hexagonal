package com.icodeapp.proyectospring.application.producto.usecase.impl;

import com.icodeapp.proyectospring.application.producto.usecase.GetAllProductoUseCase;
import com.icodeapp.proyectospring.domain.producto.model.Producto;
import com.icodeapp.proyectospring.domain.producto.port.ProductoRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllProductoUseCaseImpl implements GetAllProductoUseCase {

    private final ProductoRepositoryPort productoRepositoryPort;

    public GetAllProductoUseCaseImpl(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public List<Producto> getAllProductos() {
        return productoRepositoryPort.getAllProductos();
    }
}
