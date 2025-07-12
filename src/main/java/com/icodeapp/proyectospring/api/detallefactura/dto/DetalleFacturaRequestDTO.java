package com.icodeapp.proyectospring.api.detallefactura.dto;

import lombok.Data;

@Data
public class DetalleFacturaRequestDTO {
    private Long idProducto;
    private Integer cantidad;
}
