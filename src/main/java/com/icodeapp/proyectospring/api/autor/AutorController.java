package com.icodeapp.proyectospring.api.autor;

import com.icodeapp.proyectospring.application.autor.usecase.*;
import com.icodeapp.proyectospring.domain.autor.model.Autor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

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
    public ResponseEntity<List<Autor>>  getAutores(){
        return ResponseEntity.ok(this.getAutoresUseCase.getAutores()) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutor(@PathVariable Long id){
        return ResponseEntity.ok(this.getAutorUseCase.getAutor(id));
    }

    @GetMapping("/search")
    public ResponseEntity<Autor> searchAutor(@RequestParam String nombre, @RequestParam String apellido){
        Autor autor = searchAutorUseCase.searchByNameAndSurname(nombre, apellido);
        return ResponseEntity.ok(autor);
    }

    @PostMapping
    public ResponseEntity<Autor> createAutor(@RequestBody Autor autor){
        Autor autorResponse = createAutorUseCase.createAutor(autor);
        return new ResponseEntity<>(autorResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable Long id, @RequestBody Autor autor){
        autor.setId(id);
        return ResponseEntity.ok(this.updateAutorUseCase.updateAutor(autor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id){
        this.deleteAutorUseCase.deleteAutor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
