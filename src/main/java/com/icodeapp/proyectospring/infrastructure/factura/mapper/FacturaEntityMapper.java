package com.icodeapp.proyectospring.infrastructure.factura.mapper;

import com.icodeapp.proyectospring.domain.detallefactura.model.DetalleFactura;
import com.icodeapp.proyectospring.domain.factura.model.Factura;
import com.icodeapp.proyectospring.infrastructure.detallefacturas.entity.DetalleFacturaEntity;
import com.icodeapp.proyectospring.infrastructure.factura.entity.FacturaEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

@Service
public class FacturaEntityMapper {

    private final ModelMapper modelMapper;

    public FacturaEntityMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public FacturaEntity toEntity(Factura factura){
        return modelMapper.map(factura, FacturaEntity.class);
    }
    public Factura toDomain(FacturaEntity entity){
        return modelMapper.map(entity, Factura.class);
    }

}
