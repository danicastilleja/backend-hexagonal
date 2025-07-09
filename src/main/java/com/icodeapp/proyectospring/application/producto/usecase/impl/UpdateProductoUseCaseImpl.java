package com.icodeapp.proyectospring.application.producto.usecase.impl;

import com.icodeapp.proyectospring.application.producto.usecase.UpdateProductoUseCase;
import com.icodeapp.proyectospring.domain.exception.model.ResourceNotFoundException;
import com.icodeapp.proyectospring.domain.producto.model.Producto;
import com.icodeapp.proyectospring.domain.producto.port.ProductoRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateProductoUseCaseImpl implements UpdateProductoUseCase {

    private final ProductoRepositoryPort productoRepositoryPort;

    public UpdateProductoUseCaseImpl(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public Producto updateProducto(Producto producto) {
        Optional<Producto> productoOptional = this.productoRepositoryPort.getProductoById(producto.getId());
        if(productoOptional.isEmpty()){
            throw new ResourceNotFoundException("Recurso con id: " + producto.getId() + " no encontrado");
        }

        Producto productoForUpdated = productoOptional.get();
        productoForUpdated.setNombre(producto.getNombre());
        productoForUpdated.setDetalle(producto.getDetalle());
        productoForUpdated.setPrecio(producto.getPrecio());

        return this.productoRepositoryPort.updateProducto(productoForUpdated);
    }
}
