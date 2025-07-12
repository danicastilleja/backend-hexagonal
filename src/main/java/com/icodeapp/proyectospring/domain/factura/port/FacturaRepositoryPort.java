package com.icodeapp.proyectospring.domain.factura.port;

import com.icodeapp.proyectospring.domain.factura.model.Factura;

import java.util.List;
import java.util.Optional;

public interface FacturaRepositoryPort {

    void deleteFactura(Long idFactura);
    List<Factura> getFacturas();

    Optional<Factura> getFactura(Long id);

    Factura createFactura(Factura factura);
}
