package com.icodeapp.proyectospring.application.factura.usecase.impl;

import com.icodeapp.proyectospring.application.factura.usecase.GetFacturasUseCase;
import com.icodeapp.proyectospring.domain.factura.model.Factura;
import com.icodeapp.proyectospring.domain.factura.port.FacturaRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GetFacturasUseCaseImpl implements GetFacturasUseCase {

    private final FacturaRepositoryPort facturaRepositoryPort;

    public GetFacturasUseCaseImpl(FacturaRepositoryPort facturaRepositoryPort) {
        this.facturaRepositoryPort = facturaRepositoryPort;
    }

    @Override
    public List<Factura> getFacturas() {
        return this.facturaRepositoryPort.getFacturas();
    }
}
