package com.icodeapp.proyectospring.domain.autor.port;

import com.icodeapp.proyectospring.domain.autor.model.Autor;

import java.util.List;
import java.util.Optional;

public interface AutorRepositoryPort {

    List<Autor> getAutores();
    Optional<Autor> getAutor(Long id);
    Autor createAutor(Autor autor);
    Autor updateAutor(Autor autor);
    void deleteAutor(Long id);
    boolean existsById(Long id);
    Optional<Autor> searchByNameAndSurname(String name, String surname);
}
