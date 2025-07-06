package com.icodeapp.proyectospring.infrastructure.autor.repository;

import com.icodeapp.proyectospring.domain.autor.model.Autor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AutorHardcodeRepository {

    private static List<Autor> autores = new ArrayList<>();

    public AutorHardcodeRepository(){
        List<Autor> autores = new ArrayList<>();

        Autor autor1 = new Autor();
        autor1.setId(1L);
        autor1.setNombre("Dani");
        autor1.setApellido("Albarran");
        autor1.setTelefono("672067541");

        Autor autor2 = new Autor();
        autor2.setId(2L);
        autor2.setNombre("Pepe");
        autor2.setApellido("Botella");
        autor2.setTelefono("639492828");

        Autor autor3 = new Autor();
        autor3.setId(3L);
        autor3.setNombre("Shere");
        autor3.setApellido("Rodriguez");
        autor3.setTelefono("653747881");

        AutorHardcodeRepository.getAutores().add(autor1);
        AutorHardcodeRepository.getAutores().add(autor2);
        AutorHardcodeRepository.getAutores().add(autor3);
    }

    public static List<Autor> getAutores() {
        return autores;
    }

    public static void setAutores(List<Autor> autores) {
        AutorHardcodeRepository.autores = autores;
    }

}
