package com.icodeapp.proyectospring.application.autor.usecase;

import com.icodeapp.proyectospring.domain.autor.model.Autor;

public interface SearchAutorUseCase {

    Autor searchByNameAndSurname(String name, String surname);
}
