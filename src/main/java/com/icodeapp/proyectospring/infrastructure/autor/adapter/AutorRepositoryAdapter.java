package com.icodeapp.proyectospring.infrastructure.autor.adapter;

import com.icodeapp.proyectospring.domain.autor.model.Autor;
import com.icodeapp.proyectospring.domain.autor.port.AutorRepositoryPort;
import com.icodeapp.proyectospring.infrastructure.autor.entity.AutorEntity;
import com.icodeapp.proyectospring.infrastructure.autor.repository.AutorHardcodeRepository;
import com.icodeapp.proyectospring.infrastructure.autor.repository.JpaAutorRepository;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AutorRepositoryAdapter implements AutorRepositoryPort {

    private final JpaAutorRepository jpaAutorRepository;

    public AutorRepositoryAdapter(JpaAutorRepository jpaAutorRepository) {
        this.jpaAutorRepository = jpaAutorRepository;
    }

    @Override
    public List<Autor> getAutores() {
        List<AutorEntity> autoresEntities = this.jpaAutorRepository.findAll();
        List<Autor> autoresDomain = new ArrayList<>();
        autoresEntities.forEach(autorEntity -> {
            Autor autorDomain = new Autor();
            autorDomain.setId(autorEntity.getId());
            autorDomain.setNombre(autorEntity.getNombre());
            autorDomain.setApellido(autorEntity.getApellido());
            autorDomain.setTelefono(autorEntity.getTelefono());
            autoresDomain.add(autorDomain);
        });
        return autoresDomain;
    }

    @Override
    public Optional<Autor> getAutor(Long id) {
        Optional<AutorEntity> autorEntityOptional = this.jpaAutorRepository.findById(id);
        if(autorEntityOptional.isPresent()){
            AutorEntity autorEntity = autorEntityOptional.get();
            Autor autorDomain = new Autor();
            autorDomain.setId(autorEntity.getId());
            autorDomain.setNombre(autorEntity.getNombre());
            autorDomain.setApellido(autorEntity.getApellido());
            autorDomain.setTelefono(autorEntity.getTelefono());
            return Optional.of(autorDomain);
        }
        return Optional.empty();
    }

    @Override
    public Autor createAutor(Autor autor) {

        AutorEntity autorEntity = new AutorEntity();
        autorEntity.setNombre(autor.getNombre());
        autorEntity.setApellido(autor.getApellido());
        autorEntity.setTelefono(autor.getTelefono());
        AutorEntity autorSaved = this.jpaAutorRepository.save(autorEntity);
        autor.setId(autorSaved.getId());

        return autor;
    }

    @Override
    public Autor updateAutor(Autor autorUpdated) {
        AutorEntity autorEntity = new AutorEntity();
        autorEntity.setId(autorUpdated.getId());
        autorEntity.setNombre(autorUpdated.getNombre());
        autorEntity.setApellido(autorUpdated.getApellido());
        autorEntity.setTelefono(autorUpdated.getTelefono());
        this.jpaAutorRepository.save(autorEntity);
        return autorUpdated;
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
        Optional<AutorEntity> autorEntityOptional = this.jpaAutorRepository.searchByNameAndSurname(name, surname);
        if(autorEntityOptional.isPresent()){
            AutorEntity autorEntity = autorEntityOptional.get();
            Autor autorDomain = new Autor();
            autorDomain.setId(autorEntity.getId());
            autorDomain.setNombre(autorEntity.getNombre());
            autorDomain.setApellido(autorEntity.getApellido());
            autorDomain.setTelefono(autorEntity.getTelefono());
            return Optional.of(autorDomain);
        }

        return Optional.empty();
    }
}
