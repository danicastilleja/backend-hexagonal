package com.icodeapp.proyectospring.infrastructure.detallefacturas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.icodeapp.proyectospring.infrastructure.factura.entity.FacturaEntity;
import com.icodeapp.proyectospring.infrastructure.producto.entity.ProductoEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "detallefacturas")
@Getter
@Setter
public class DetalleFacturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="factura_id", nullable = false)
    @JsonIgnore
    private FacturaEntity factura;
    @ManyToOne
    @JoinColumn(name="producto_id", nullable = false)
    private ProductoEntity producto;
    @Column(name="cantidad")
    private Integer cantidad;
    @Column(name="total")
    private BigDecimal total;

}
