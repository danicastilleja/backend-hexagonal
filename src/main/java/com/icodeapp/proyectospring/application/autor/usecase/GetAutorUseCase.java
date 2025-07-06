package com.icodeapp.proyectospring.application.autor.usecase;

import com.icodeapp.proyectospring.domain.autor.model.Autor;

public interface GetAutorUseCase {

    Autor getAutor(Long id);
}
