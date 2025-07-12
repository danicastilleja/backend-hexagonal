package com.icodeapp.proyectospring.application.factura.usecase.impl;

import com.icodeapp.proyectospring.application.factura.usecase.CreateFacturaUseCase;
import com.icodeapp.proyectospring.domain.detallefactura.model.DetalleFactura;
import com.icodeapp.proyectospring.domain.exception.model.ResourceNotFoundException;
import com.icodeapp.proyectospring.domain.factura.model.Factura;
import com.icodeapp.proyectospring.domain.factura.port.FacturaRepositoryPort;
import com.icodeapp.proyectospring.domain.producto.model.Producto;
import com.icodeapp.proyectospring.domain.producto.port.ProductoRepositoryPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class CreateFacturaUseCaseImpl implements CreateFacturaUseCase {

    private final FacturaRepositoryPort facturaRepositoryPort;
    private final ProductoRepositoryPort productoRepositoryPort;

    public CreateFacturaUseCaseImpl(FacturaRepositoryPort facturaRepositoryPort, ProductoRepositoryPort productoRepositoryPort) {
        this.facturaRepositoryPort = facturaRepositoryPort;
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Transactional
    @Override
    public Factura createFactura(Factura factura) {
        Factura facturaNew = new Factura();
        BigDecimal subtotalFactura = BigDecimal.ZERO;
        Set<DetalleFactura> detalles = new HashSet<>();

        facturaNew.setNumeroFactura(factura.getNumeroFactura());

        for(DetalleFactura detalle : factura.getDetalleFacturas()){
            Optional<Producto> producto = this.productoRepositoryPort.getProductoById(detalle.getProducto().getId());
            if(producto.isEmpty()){
                throw new ResourceNotFoundException("No se ha encontrado el producto, no se puede completar la compra");
            }

            BigDecimal totalProducto = producto.get().getPrecio().multiply(BigDecimal.valueOf(detalle.getCantidad()));
            subtotalFactura = subtotalFactura.add(totalProducto);

            DetalleFactura detalleFacturaNew = new DetalleFactura();
            detalleFacturaNew.setProducto(producto.get());
            detalleFacturaNew.setCantidad(detalle.getCantidad());
            detalleFacturaNew.setTotal(totalProducto);
            detalleFacturaNew.setFactura(factura);

            detalles.add(detalleFacturaNew);
        }

        factura.setDetalleFacturas(detalles);
        factura.setSubTotal(subtotalFactura);
        factura.setTotal(subtotalFactura.add(subtotalFactura.multiply(BigDecimal.valueOf(factura.getIVA()))));

        return this.facturaRepositoryPort.createFactura(factura);
    }
}
