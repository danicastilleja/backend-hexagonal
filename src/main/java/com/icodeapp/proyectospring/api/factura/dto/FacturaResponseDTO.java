package com.icodeapp.proyectospring.api.factura.dto;

import com.icodeapp.proyectospring.api.detallefactura.dto.DetalleFacturaResponseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class FacturaResponseDTO {

    private Long id;
    private String numeroFactura;
    private BigDecimal subTotal;
    private BigDecimal total;
    private LocalDateTime fechaCreacion;
    private Set<DetalleFacturaResponseDTO> detalleFacturas;
}
