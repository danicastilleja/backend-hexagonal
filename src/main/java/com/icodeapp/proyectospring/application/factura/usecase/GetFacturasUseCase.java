package com.icodeapp.proyectospring.application.factura.usecase;

import com.icodeapp.proyectospring.domain.factura.model.Factura;

import java.util.List;
import java.util.Optional;

public interface GetFacturasUseCase {

    List<Factura> getFacturas();
}
