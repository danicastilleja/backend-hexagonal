package com.icodeapp.proyectospring.domain.producto.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    private Long id;
    private String nombre;
    private String detalle;
    private BigDecimal precio;
    private LocalDate fechaCreacion;
    private LocalDate fechaActualizacion;
}
