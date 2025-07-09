package com.icodeapp.proyectospring.application.producto.usecase.impl;

import com.icodeapp.proyectospring.application.producto.usecase.DeleteProductoUseCase;
import com.icodeapp.proyectospring.domain.exception.model.ResourceNotFoundException;
import com.icodeapp.proyectospring.domain.producto.port.ProductoRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductoUseCaseImpl implements DeleteProductoUseCase {

    private final ProductoRepositoryPort productoRepositoryPort;

    public DeleteProductoUseCaseImpl(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public void deleteProducto(Long id) {
        if(!productoRepositoryPort.existsById(id)){
            throw new ResourceNotFoundException("Recurso con id: " + id + " no encontrado");
        }else{
            this.productoRepositoryPort.deleteProducto(id);
        }
    }
}
