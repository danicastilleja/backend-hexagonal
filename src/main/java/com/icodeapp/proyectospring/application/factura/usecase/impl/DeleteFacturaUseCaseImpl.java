package com.icodeapp.proyectospring.application.factura.usecase.impl;

import com.icodeapp.proyectospring.application.factura.usecase.DeleteFacturaUseCase;
import com.icodeapp.proyectospring.domain.factura.port.FacturaRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class DeleteFacturaUseCaseImpl implements DeleteFacturaUseCase {

    private final FacturaRepositoryPort facturaRepositoryPort;

    public DeleteFacturaUseCaseImpl(FacturaRepositoryPort facturaRepositoryPort) {
        this.facturaRepositoryPort = facturaRepositoryPort;
    }

    @Override
    public void deleteFactura(Long id) {
        facturaRepositoryPort.deleteFactura(id);
    }
}
