package com.icodeapp.proyectospring.api.autor.mapper;

import com.icodeapp.proyectospring.api.autor.dto.AutorCreateDTO;
import com.icodeapp.proyectospring.api.autor.dto.AutorDTO;
import com.icodeapp.proyectospring.domain.autor.model.Autor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AutorMapper {

    private final ModelMapper modelMapper;

    public AutorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Autor toDomain(AutorDTO autorDTO){
        return modelMapper.map(autorDTO, Autor.class);
    }

    public Autor toDomain(AutorCreateDTO autorDTO){
        return modelMapper.map(autorDTO, Autor.class);
    }

    public AutorDTO toDto(Autor autor){
        return modelMapper.map(autor, AutorDTO.class);
    }
}
