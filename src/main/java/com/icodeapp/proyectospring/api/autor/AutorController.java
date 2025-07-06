package com.icodeapp.proyectospring.api.autor;

import com.icodeapp.proyectospring.api.autor.dto.AutorCreateDTO;
import com.icodeapp.proyectospring.api.autor.dto.AutorDTO;
import com.icodeapp.proyectospring.api.autor.mapper.AutorMapper;
import com.icodeapp.proyectospring.application.autor.usecase.*;
import com.icodeapp.proyectospring.domain.autor.model.Autor;
import org.modelmapper.ModelMapper;
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
    private final AutorMapper autorMapper;

    public AutorController(GetAutoresUseCase getAutoresUseCase, CreateAutorUseCase createAutorUseCase, UpdateAutorUseCase updateAutorUseCase,
                           DeleteAutorUseCase deleteAutorUseCase, GetAutorUseCase getAutorUseCase, SearchAutorUseCase searchAutorUseCase, AutorMapper autorMapper) {
        this.getAutoresUseCase = getAutoresUseCase;
        this.createAutorUseCase = createAutorUseCase;
        this.updateAutorUseCase = updateAutorUseCase;
        this.deleteAutorUseCase = deleteAutorUseCase;
        this.getAutorUseCase = getAutorUseCase;
        this.searchAutorUseCase = searchAutorUseCase;
        this.autorMapper = autorMapper;
    }

    @GetMapping
    public ResponseEntity<List<AutorDTO>>  getAutores(){

        List<AutorDTO> autoresDTO = this.getAutoresUseCase.getAutores().stream().map(autorMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(autoresDTO) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> getAutor(@PathVariable Long id){
        Autor autor = this.getAutorUseCase.getAutor(id);
        return ResponseEntity.ok(autorMapper.toDto(autor));
    }

    @GetMapping("/search")
    public ResponseEntity<AutorDTO> searchAutor(@RequestParam String nombre, @RequestParam String apellido){
        Autor autor = searchAutorUseCase.searchByNameAndSurname(nombre, apellido);
        return ResponseEntity.ok(autorMapper.toDto(autor));
    }

    @PostMapping
    public ResponseEntity<AutorDTO> createAutor(@RequestBody AutorCreateDTO autorCreateDTO){
        Autor autorCreated = createAutorUseCase.createAutor(autorMapper.toDomain(autorCreateDTO));
        return new ResponseEntity<>(autorMapper.toDto(autorCreated), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorDTO> updateAutor(@PathVariable Long id, @RequestBody AutorDTO autorUpdatedDTO){
        Autor autor = autorMapper.toDomain(autorUpdatedDTO);
        autor.setId(id);
        Autor autorSaved = this.updateAutorUseCase.updateAutor(autor);
        return ResponseEntity.ok(autorMapper.toDto(autorSaved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id){
        this.deleteAutorUseCase.deleteAutor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
