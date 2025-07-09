package com.icodeapp.proyectospring.application.autor.usecase.impl;

import com.icodeapp.proyectospring.application.autor.usecase.DeleteAutorUseCase;
import com.icodeapp.proyectospring.domain.autor.port.AutorRepositoryPort;
import com.icodeapp.proyectospring.domain.exception.model.ResourceNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DeleteAutorUseCaseImpl implements DeleteAutorUseCase {

    private final AutorRepositoryPort  autorRepositoryPort;

    public DeleteAutorUseCaseImpl(AutorRepositoryPort autorRepositoryPort) {
        this.autorRepositoryPort = autorRepositoryPort;
    }

    @Override
    public void deleteAutor(Long id) {
        if(autorRepositoryPort.existsById(id)){
            autorRepositoryPort.deleteAutor(id);
        }else{
            throw new ResourceNotFoundException("Recurso con id: " + id + " no encontrado.");
        }
    }
}
