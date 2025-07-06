package com.icodeapp.proyectospring.application.autor.usecase;

import com.icodeapp.proyectospring.domain.autor.model.Autor;
import com.icodeapp.proyectospring.domain.autor.port.AutorRepositoryPort;
import com.icodeapp.proyectospring.domain.exception.model.ResourceNotFoundException;
import com.icodeapp.proyectospring.infrastructure.autor.repository.AutorHardcodeRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateAutorUseCaseImpl implements UpdateAutorUseCase{

    private final AutorRepositoryPort autorRepositoryPort;

    public UpdateAutorUseCaseImpl(AutorRepositoryPort autorRepositoryPort) {
        this.autorRepositoryPort = autorRepositoryPort;
    }

    @Override
    public Autor updateAutor(Autor autorUpdate) {

        Optional<Autor> autorOptional = this.autorRepositoryPort.getAutor(autorUpdate.getId());
        if (autorOptional.isEmpty()){
            throw new ResourceNotFoundException("Recurso con id: " + autorUpdate.getId() + " no encontrado.");
        }
        Autor autor = autorOptional.get();
        autor.setNombre(autorUpdate.getNombre());
        autor.setApellido(autorUpdate.getApellido());
        autor.setTelefono(autorUpdate.getTelefono());

        return this.autorRepositoryPort.updateAutor(autor);
    }
}
