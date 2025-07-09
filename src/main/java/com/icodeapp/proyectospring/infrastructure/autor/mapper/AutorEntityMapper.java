package com.icodeapp.proyectospring.infrastructure.autor.mapper;

import com.icodeapp.proyectospring.api.autor.dto.AutorDTO;
import com.icodeapp.proyectospring.domain.autor.model.Autor;
import com.icodeapp.proyectospring.infrastructure.autor.entity.AutorEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AutorEntityMapper {

    private final ModelMapper modelMapper;

    public AutorEntityMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Autor toDomain(AutorEntity autorEntity){
        return this.modelMapper.map(autorEntity, Autor.class);
    }

    public AutorEntity toEntity(Autor autor){
        return this.modelMapper.map(autor, AutorEntity.class);
    }
}
