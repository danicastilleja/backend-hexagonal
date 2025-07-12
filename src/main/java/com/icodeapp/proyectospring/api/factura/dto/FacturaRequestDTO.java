package com.icodeapp.proyectospring.api.factura.dto;

import com.icodeapp.proyectospring.api.detallefactura.dto.DetalleFacturaRequestDTO;
import lombok.Data;

import java.util.Set;

@Data
public class FacturaRequestDTO {
    private Long id;
    private String numeroFactura;
    private Set<DetalleFacturaRequestDTO> detalleFacturas;
}
