package com.icodeapp.proyectospring.application.autor.usecase.impl;

import com.icodeapp.proyectospring.application.autor.usecase.GetAutorUseCase;
import com.icodeapp.proyectospring.domain.exception.model.ResourceNotFoundException;
import com.icodeapp.proyectospring.domain.autor.model.Autor;
import com.icodeapp.proyectospring.domain.autor.port.AutorRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetAutorUseCaseImpl implements GetAutorUseCase {

    private final AutorRepositoryPort autorRepositoryPort;

    public GetAutorUseCaseImpl(AutorRepositoryPort autorRepositoryPort) {
        this.autorRepositoryPort = autorRepositoryPort;
    }

    @Override
    public Autor getAutor(Long id) {
        Optional<Autor> autorOptional= autorRepositoryPort.getAutor(id);
        if(autorOptional.isEmpty()){
            throw new ResourceNotFoundException("Recurso con id: " + id + " no encontrado.");
        }
        return autorOptional.get();
    }}
