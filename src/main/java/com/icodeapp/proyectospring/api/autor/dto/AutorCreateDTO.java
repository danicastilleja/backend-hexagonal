package com.icodeapp.proyectospring.api.autor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutorCreateDTO {

    private String nombre;
    private String apellido;
    private String telefono;
}
