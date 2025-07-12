package com.icodeapp.proyectospring.application.factura.usecase;

import com.icodeapp.proyectospring.domain.factura.model.Factura;

public interface CreateFacturaUseCase {

    Factura createFactura(Factura factura);
}
