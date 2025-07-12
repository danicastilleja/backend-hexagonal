package com.icodeapp.proyectospring.api.detallefactura.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DetalleFacturaResponseDTO {

    private Integer idProducto;
    private Integer cantidad;
    private BigDecimal precio;
    private BigDecimal total;

}
