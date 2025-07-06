package com.icodeapp.proyectospring.application.autor.usecase;

import com.icodeapp.proyectospring.domain.autor.model.Autor;
import com.icodeapp.proyectospring.domain.autor.port.AutorRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class CreateAutorUseCaseImpl implements CreateAutorUseCase {

    private final AutorRepositoryPort autorRepositoryPort;

    public CreateAutorUseCaseImpl(AutorRepositoryPort autorRepositoryPort) {
        this.autorRepositoryPort = autorRepositoryPort;
    }

    @Override
    public Autor createAutor(Autor autor) {
        return autorRepositoryPort.createAutor(autor);
    }
}
