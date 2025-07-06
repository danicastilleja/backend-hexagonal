package com.icodeapp.proyectospring.application.autor.usecase;


import com.icodeapp.proyectospring.domain.autor.model.Autor;
import org.springframework.stereotype.Component;

import java.util.List;

public interface GetAutoresUseCase {
    List<Autor> getAutores();
}
