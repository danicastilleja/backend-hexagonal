package com.icodeapp.proyectospring.domain.producto.port;

import com.icodeapp.proyectospring.domain.producto.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepositoryPort {

    Producto createProducto(Producto producto);

    List<Producto> getAllProductos();

    Optional<Producto> getProductoById(Long id);

    boolean existsById(Long id);

    void deleteProducto(Long id);

    Producto updateProducto(Producto productoForUpdated);
}
