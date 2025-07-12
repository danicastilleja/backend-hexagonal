package com.icodeapp.proyectospring.domain.factura.model;

import com.icodeapp.proyectospring.domain.detallefactura.model.DetalleFactura;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Factura {

    private Long id;
    private String numeroFactura;
    private BigDecimal subTotal;
    private BigDecimal total;
    private LocalDateTime fechaCreacion;
    private Set<DetalleFactura> detalleFacturas;
    private final Double IVA = 0.15;

}
