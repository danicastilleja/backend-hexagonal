package com.icodeapp.proyectospring.application.factura.usecase.impl;

import com.icodeapp.proyectospring.application.factura.usecase.GetFacturaUseCase;
import com.icodeapp.proyectospring.domain.exception.model.ResourceNotFoundException;
import com.icodeapp.proyectospring.domain.factura.model.Factura;
import com.icodeapp.proyectospring.domain.factura.port.FacturaRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetFacturaUseCaseImpl implements GetFacturaUseCase {

    private final FacturaRepositoryPort facturaRepositoryPort;

    public GetFacturaUseCaseImpl(FacturaRepositoryPort facturaRepositoryPort) {
        this.facturaRepositoryPort = facturaRepositoryPort;
    }

    @Override
    public Factura getFactura(Long id) {
        Optional<Factura> factura =  facturaRepositoryPort.getFactura(id);
        if(factura.isEmpty()){
            throw new ResourceNotFoundException("No se encuentra la factura con id: " + id);
        }
        return factura.get();

    }
}
