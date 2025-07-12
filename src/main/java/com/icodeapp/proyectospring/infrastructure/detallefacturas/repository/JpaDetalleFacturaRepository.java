package com.icodeapp.proyectospring.infrastructure.detallefacturas.repository;

import com.icodeapp.proyectospring.infrastructure.detallefacturas.entity.DetalleFacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaDetalleFacturaRepository extends JpaRepository<DetalleFacturaEntity, Long> {
}
