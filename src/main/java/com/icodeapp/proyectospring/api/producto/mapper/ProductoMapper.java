package com.icodeapp.proyectospring.api.producto.mapper;

import com.icodeapp.proyectospring.api.producto.dto.ProductoCreateDTO;
import com.icodeapp.proyectospring.api.producto.dto.ProductoDTO;
import com.icodeapp.proyectospring.domain.producto.model.Producto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    private final ModelMapper mapper;

    public ProductoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Producto toDomain(ProductoDTO productoDTO){
        return this.mapper.map(productoDTO, Producto.class);
    }

    public Producto toDomain(ProductoCreateDTO productoCreateDTO){
        return this.mapper.map(productoCreateDTO, Producto.class);
    }

    public ProductoDTO toDto(Producto producto){
        return this.mapper.map(producto, ProductoDTO.class);
    }
}
