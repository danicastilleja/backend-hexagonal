package com.icodeapp.proyectospring.infrastructure.producto.mapper;

import com.icodeapp.proyectospring.domain.producto.model.Producto;
import com.icodeapp.proyectospring.infrastructure.producto.entity.ProductoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductoEntityMapper {

    private final ModelMapper modelMapper;

    public ProductoEntityMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Producto toDomain(ProductoEntity entity){
        return this.modelMapper.map(entity, Producto.class);
    }

    public ProductoEntity toEntity(Producto producto){
        return this.modelMapper.map(producto, ProductoEntity.class);
    }
}
