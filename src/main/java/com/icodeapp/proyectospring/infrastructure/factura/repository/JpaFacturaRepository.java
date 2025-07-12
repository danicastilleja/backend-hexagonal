package com.icodeapp.proyectospring.infrastructure.factura.repository;

import com.icodeapp.proyectospring.infrastructure.factura.entity.FacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFacturaRepository extends JpaRepository<FacturaEntity, Long> {
}
