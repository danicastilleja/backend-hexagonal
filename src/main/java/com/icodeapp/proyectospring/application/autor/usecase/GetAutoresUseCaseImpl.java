package com.icodeapp.proyectospring.application.autor.usecase;

import com.icodeapp.proyectospring.domain.autor.model.Autor;
import com.icodeapp.proyectospring.domain.autor.port.AutorRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAutoresUseCaseImpl implements GetAutoresUseCase{

    private final AutorRepositoryPort autorRepositoryPort;

    public GetAutoresUseCaseImpl(AutorRepositoryPort autorRepositoryPort) {
        this.autorRepositoryPort = autorRepositoryPort;
    }

    @Override
    public List<Autor> getAutores() {
        return autorRepositoryPort.getAutores();
    }
}
