package com.icodeapp.proyectospring.infrastructure.factura.adapter;

import com.icodeapp.proyectospring.domain.detallefactura.model.DetalleFactura;
import com.icodeapp.proyectospring.domain.factura.model.Factura;
import com.icodeapp.proyectospring.domain.factura.port.FacturaRepositoryPort;
import com.icodeapp.proyectospring.domain.producto.model.Producto;
import com.icodeapp.proyectospring.infrastructure.detallefacturas.entity.DetalleFacturaEntity;
import com.icodeapp.proyectospring.infrastructure.factura.entity.FacturaEntity;
import com.icodeapp.proyectospring.infrastructure.factura.mapper.FacturaEntityMapper;
import com.icodeapp.proyectospring.infrastructure.factura.repository.JpaFacturaRepository;
import com.icodeapp.proyectospring.infrastructure.producto.entity.ProductoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class FacturaRepositoryAdapter implements FacturaRepositoryPort {

    private final JpaFacturaRepository jpaFacturaRepository;
    private final FacturaEntityMapper mapper;

    public FacturaRepositoryAdapter(JpaFacturaRepository jpaFacturaRepository, FacturaEntityMapper mapper) {
        this.jpaFacturaRepository = jpaFacturaRepository;
        this.mapper = mapper;
    }

    @Override
    public void deleteFactura(Long idFactura) {
        this.jpaFacturaRepository.deleteById(idFactura);
    }

    @Override
    public List<Factura> getFacturas() {
        List<FacturaEntity> facturas = this.jpaFacturaRepository.findAll();
        return facturas.stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Factura> getFactura(Long id) {
        return this.jpaFacturaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Factura createFactura(Factura factura) {
        FacturaEntity facturaEntity = mapper.toEntity(factura);
        this.jpaFacturaRepository.save(facturaEntity);
        return mapper.toDomain(facturaEntity);
    }
}
