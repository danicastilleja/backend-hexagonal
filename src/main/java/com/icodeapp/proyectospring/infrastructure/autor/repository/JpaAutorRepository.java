package com.icodeapp.proyectospring.infrastructure.autor.repository;

import com.icodeapp.proyectospring.infrastructure.autor.entity.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaAutorRepository extends JpaRepository<AutorEntity, Long> {

    @Query("SELECT a FROM AutorEntity a WHERE LOWER(a.nombre) = LOWER(:nombre) AND LOWER(a.apellido) = LOWER(:apellido)")
    Optional<AutorEntity> searchByNameAndSurname(@Param("nombre") String nombre, @Param("apellido") String apellido);
}
