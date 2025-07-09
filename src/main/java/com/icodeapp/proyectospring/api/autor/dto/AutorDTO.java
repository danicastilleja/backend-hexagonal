package com.icodeapp.proyectospring.api.autor.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutorDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
}
