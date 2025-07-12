package com.icodeapp.proyectospring.domain.detallefactura.model;

import com.icodeapp.proyectospring.domain.factura.model.Factura;
import com.icodeapp.proyectospring.domain.producto.model.Producto;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class DetalleFactura {

    private Long id;
    private Factura factura;
    private Producto producto;
    private Integer cantidad;
    private BigDecimal total;
}
