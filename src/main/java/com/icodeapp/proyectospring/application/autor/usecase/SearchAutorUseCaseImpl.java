package com.icodeapp.proyectospring.application.autor.usecase;

import com.icodeapp.proyectospring.domain.autor.model.Autor;
import com.icodeapp.proyectospring.domain.autor.port.AutorRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SearchAutorUseCaseImpl implements SearchAutorUseCase{

    private final AutorRepositoryPort autorRepositoryPort;

    public SearchAutorUseCaseImpl(AutorRepositoryPort autorRepositoryPort) {
        this.autorRepositoryPort = autorRepositoryPort;
    }

    @Override
    public Autor searchByNameAndSurname(String name, String surname) {
        Optional<Autor> autorOptional = autorRepositoryPort.searchByNameAndSurname(name, surname);
        if(autorOptional.isEmpty()){
            throw new RuntimeException("Autor no encontrado");
        }
        return autorOptional.get();
    }
}
