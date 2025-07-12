package com.icodeapp.proyectospring.api.factura.mapper;

import com.icodeapp.proyectospring.api.detallefactura.dto.DetalleFacturaRequestDTO;
import com.icodeapp.proyectospring.api.detallefactura.dto.DetalleFacturaResponseDTO;
import com.icodeapp.proyectospring.api.factura.dto.FacturaRequestDTO;
import com.icodeapp.proyectospring.api.factura.dto.FacturaResponseDTO;
import com.icodeapp.proyectospring.domain.detallefactura.model.DetalleFactura;
import com.icodeapp.proyectospring.domain.factura.model.Factura;
import com.icodeapp.proyectospring.domain.producto.model.Producto;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
public class FacturaMapper {
    private final ModelMapper modelMapper;

    public FacturaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

        TypeMap<DetalleFacturaRequestDTO, DetalleFactura> detalleTypeMap =
                modelMapper.createTypeMap(DetalleFacturaRequestDTO.class, DetalleFactura.class);

        Converter<Long, Producto> converter = ctx -> {
            if (ctx.getSource() == null) return null;
            Producto producto = new Producto();
            producto.setId(ctx.getSource());
            return producto;
        };
        detalleTypeMap.addMappings(mapper -> {
            mapper.using(converter).map(DetalleFacturaRequestDTO::getIdProducto, DetalleFactura::setProducto);
            mapper.skip(DetalleFactura::setId);
            mapper.map(src -> null, DetalleFactura::setFactura);
        });

        TypeMap<DetalleFactura, DetalleFacturaResponseDTO> detalleResponseTypeMap =
                modelMapper.createTypeMap(DetalleFactura.class, DetalleFacturaResponseDTO.class);

        detalleResponseTypeMap.addMappings( mapper -> {
            mapper.map(src -> src.getProducto().getId(), DetalleFacturaResponseDTO::setIdProducto);
            mapper.map(src -> src.getProducto().getPrecio(), DetalleFacturaResponseDTO::setPrecio);
        });
    }

    public FacturaResponseDTO toDTO(Factura factura){
        return modelMapper.map(factura, FacturaResponseDTO.class);
    }

    public Factura toDomain(FacturaRequestDTO facturaRequestDTO){
        return modelMapper.map(facturaRequestDTO, Factura.class);
    }
}
