package com.icodeapp.proyectospring.application.producto.usecase;

import com.icodeapp.proyectospring.domain.producto.model.Producto;

import java.util.List;

public interface GetAllProductoUseCase {

    List<Producto> getAllProductos();
}
