package com.icodeapp.proyectospring.infrastructure.factura.entity;

import com.icodeapp.proyectospring.infrastructure.detallefacturas.entity.DetalleFacturaEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "facturas")
@Getter
@Setter
public class FacturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numeroFactura")
    private String numeroFactura;
    @Column(name = "subTotal")
    private BigDecimal subTotal;
    @Column(name = "total")
    private BigDecimal total;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime fechaCreacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura", orphanRemoval = true)
    private Set<DetalleFacturaEntity> detalleFacturas;
    @Transient
    private final Double IVA = 0.15;


}
