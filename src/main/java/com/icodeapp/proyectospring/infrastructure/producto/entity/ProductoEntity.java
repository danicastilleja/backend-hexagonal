package com.icodeapp.proyectospring.infrastructure.producto.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="productos")
@Data
@NoArgsConstructor
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "detalle")
    private String detalle;
    @Column(name="precio")
    private BigDecimal precio;
    @Column(name = "fechaCreacion", updatable = false)
    @CreationTimestamp
    private LocalDate fechaCreacion;
    @Column(name = "fechaActualizacion")
    @UpdateTimestamp
    private LocalDate fechaActualizacion;

}
