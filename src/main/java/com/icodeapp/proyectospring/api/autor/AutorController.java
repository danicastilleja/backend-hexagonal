package com.icodeapp.proyectospring.api.autor;

import com.icodeapp.proyectospring.api.autor.dto.AutorCreateDTO;
import com.icodeapp.proyectospring.api.autor.dto.AutorDTO;
import com.icodeapp.proyectospring.application.autor.usecase.*;
import com.icodeapp.proyectospring.domain.autor.model.Autor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final GetAutoresUseCase getAutoresUseCase;
    private final CreateAutorUseCase createAutorUseCase;
    private final UpdateAutorUseCase updateAutorUseCase;
    private final DeleteAutorUseCase deleteAutorUseCase;
    private final GetAutorUseCase getAutorUseCase;
    private final SearchAutorUseCase searchAutorUseCase;

    public AutorController(GetAutoresUseCase getAutoresUseCase, CreateAutorUseCase createAutorUseCase, UpdateAutorUseCase updateAutorUseCase, DeleteAutorUseCase deleteAutorUseCase, GetAutorUseCase getAutorUseCase, SearchAutorUseCase searchAutorUseCase) {
        this.getAutoresUseCase = getAutoresUseCase;
        this.createAutorUseCase = createAutorUseCase;
        this.updateAutorUseCase = updateAutorUseCase;
        this.deleteAutorUseCase = deleteAutorUseCase;
        this.getAutorUseCase = getAutorUseCase;
        this.searchAutorUseCase = searchAutorUseCase;
    }

    @GetMapping
    public ResponseEntity<List<AutorDTO>>  getAutores(){

        List<AutorDTO> autoresDTO = this.getAutoresUseCase.getAutores().stream().map(autor -> {
            AutorDTO autorDTO = new AutorDTO();
            autorDTO.setId(autor.getId());
            autorDTO.setNombre(autor.getNombre());
            autorDTO.setApellido(autor.getApellido());
            autorDTO.setTelefono(autor.getTelefono());
            return autorDTO;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(autoresDTO) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> getAutor(@PathVariable Long id){
        Autor autor = this.getAutorUseCase.getAutor(id);
        AutorDTO autorDTO = new AutorDTO();
        autorDTO.setId(autor.getId());
        autorDTO.setNombre(autor.getNombre());
        autorDTO.setApellido(autor.getApellido());
        autorDTO.setTelefono(autor.getTelefono());
        return ResponseEntity.ok(autorDTO);
    }

    @GetMapping("/search")
    public ResponseEntity<AutorDTO> searchAutor(@RequestParam String nombre, @RequestParam String apellido){
        Autor autor = searchAutorUseCase.searchByNameAndSurname(nombre, apellido);
        AutorDTO autorDTO = new AutorDTO();
        autorDTO.setId(autor.getId());
        autorDTO.setNombre(autor.getNombre());
        autorDTO.setApellido(autor.getApellido());
        autorDTO.setTelefono(autor.getTelefono());
        return ResponseEntity.ok(autorDTO);
    }

    @PostMapping
    public ResponseEntity<AutorDTO> createAutor(@RequestBody AutorCreateDTO autorCreateDTO){
        Autor autorNew = new Autor();
        autorNew.setNombre(autorCreateDTO.getNombre());
        autorNew.setApellido(autorCreateDTO.getApellido());
        autorNew.setTelefono(autorCreateDTO.getTelefono());

        Autor autorCreated = createAutorUseCase.createAutor(autorNew);

        AutorDTO autorResponseDTO = new AutorDTO();
        autorResponseDTO.setId(autorCreated.getId());
        autorResponseDTO.setNombre(autorCreated.getNombre());
        autorResponseDTO.setApellido(autorCreated.getApellido());
        autorResponseDTO.setTelefono(autorCreated.getTelefono());

        return new ResponseEntity<>(autorResponseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorDTO> updateAutor(@PathVariable Long id, @RequestBody AutorDTO autorUpdatedDTO){
        Autor autor = new Autor();
        autor.setId(id);
        autor.setNombre(autorUpdatedDTO.getNombre());
        autor.setApellido(autorUpdatedDTO.getApellido());
        autor.setTelefono(autorUpdatedDTO.getTelefono());

        Autor autorSaved = this.updateAutorUseCase.updateAutor(autor);
        AutorDTO autorSavedDTO = new AutorDTO();
        autorSavedDTO.setId(autorSaved.getId());
        autorSavedDTO.setNombre(autorSaved.getNombre());
        autorSavedDTO.setApellido(autorSaved.getApellido());
        autorSavedDTO.setTelefono(autorSaved.getTelefono());
        return ResponseEntity.ok(autorSavedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id){
        this.deleteAutorUseCase.deleteAutor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
