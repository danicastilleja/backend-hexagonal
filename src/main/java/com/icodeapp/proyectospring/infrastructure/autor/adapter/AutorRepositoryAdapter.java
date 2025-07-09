package com.icodeapp.proyectospring.infrastructure.autor.adapter;

import com.icodeapp.proyectospring.domain.autor.model.Autor;
import com.icodeapp.proyectospring.domain.autor.port.AutorRepositoryPort;
import com.icodeapp.proyectospring.infrastructure.autor.entity.AutorEntity;
import com.icodeapp.proyectospring.infrastructure.autor.mapper.AutorEntityMapper;
import com.icodeapp.proyectospring.infrastructure.autor.repository.AutorHardcodeRepository;
import com.icodeapp.proyectospring.infrastructure.autor.repository.JpaAutorRepository;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AutorRepositoryAdapter implements AutorRepositoryPort {

    private final JpaAutorRepository jpaAutorRepository;
    private final AutorEntityMapper autorEntityMapper;

    public AutorRepositoryAdapter(JpaAutorRepository jpaAutorRepository, AutorEntityMapper autorEntityMapper) {
        this.jpaAutorRepository = jpaAutorRepository;
        this.autorEntityMapper = autorEntityMapper;
    }

    @Override
    public List<Autor> getAutores() {
        List<AutorEntity> autoresEntities = this.jpaAutorRepository.findAll();
        return autoresEntities.stream().map(autorEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Autor> getAutor(Long id) {
        return jpaAutorRepository.findById(id)
                .map(autorEntityMapper::toDomain);
    }

    @Override
    public Autor createAutor(Autor autor) {
        AutorEntity entity = autorEntityMapper.toEntity(autor);
        AutorEntity autorSaved = this.jpaAutorRepository.save(entity);
        return autorEntityMapper.toDomain(autorSaved);
    }

    @Override
    public Autor updateAutor(Autor autorUpdated) {
        AutorEntity entity = autorEntityMapper.toEntity(autorUpdated);
        AutorEntity saved = this.jpaAutorRepository.save(entity);
        return autorEntityMapper.toDomain(saved);
    }

    @Override
    public void deleteAutor(Long id) {
        this.jpaAutorRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return this.jpaAutorRepository.existsById(id);
    }

    @Override
    public Optional<Autor> searchByNameAndSurname(String name, String surname) {
        return this.jpaAutorRepository.searchByNameAndSurname(name, surname).map(autorEntityMapper::toDomain);
    }
}
