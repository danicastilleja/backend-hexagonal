package com.icodeapp.proyectospring.application.producto.usecase;

import com.icodeapp.proyectospring.domain.producto.model.Producto;

public interface CreateProductoUseCase {
    Producto createProducto(Producto producto);
}
