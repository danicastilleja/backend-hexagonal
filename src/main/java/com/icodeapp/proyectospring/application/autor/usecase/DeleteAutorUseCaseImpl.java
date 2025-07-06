package com.icodeapp.proyectospring.application.autor.usecase;

import com.icodeapp.proyectospring.domain.autor.port.AutorRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class DeleteAutorUseCaseImpl implements DeleteAutorUseCase{

    private final AutorRepositoryPort  autorRepositoryPort;

    public DeleteAutorUseCaseImpl(AutorRepositoryPort autorRepositoryPort) {
        this.autorRepositoryPort = autorRepositoryPort;
    }

    @Override
    public void deleteAutor(Long id) {
        if(autorRepositoryPort.existsById(id)){
            autorRepositoryPort.deleteAutor(id);
        }else{
            throw new RuntimeException("El autor no existe");
        }
    }
}
