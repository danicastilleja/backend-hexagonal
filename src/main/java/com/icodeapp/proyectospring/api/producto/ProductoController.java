package com.icodeapp.proyectospring.api.producto;

import com.icodeapp.proyectospring.api.producto.dto.ProductoCreateDTO;
import com.icodeapp.proyectospring.api.producto.dto.ProductoDTO;
import com.icodeapp.proyectospring.api.producto.mapper.ProductoMapper;
import com.icodeapp.proyectospring.application.producto.usecase.*;
import com.icodeapp.proyectospring.domain.producto.model.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final GetAllProductoUseCase getAllProductoUseCase;
    private final GetProductoUseCase getProductoUseCase;
    private final CreateProductoUseCase createProductoUseCase;
    private final UpdateProductoUseCase updateProductoUseCase;
    private final DeleteProductoUseCase deleteProductoUseCase;
    private final ProductoMapper mapper;

    public ProductoController(GetAllProductoUseCase getAllProductoUseCase, GetProductoUseCase getProductoUseCase, CreateProductoUseCase createProductoUseCase, UpdateProductoUseCase updateProductoUseCase, DeleteProductoUseCase deleteProductoUseCase, ProductoMapper mapper) {
        this.getAllProductoUseCase = getAllProductoUseCase;
        this.getProductoUseCase = getProductoUseCase;
        this.createProductoUseCase = createProductoUseCase;
        this.updateProductoUseCase = updateProductoUseCase;
        this.deleteProductoUseCase = deleteProductoUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getAllProductos(){
        return ResponseEntity.ok(this.getAllProductoUseCase.getAllProductos().stream().map(mapper::toDto).toList());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductoDTO> getProducto(@PathVariable Long id){
        return ResponseEntity.ok(mapper.toDto(this.getProductoUseCase.getProducto(id)));
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> createProducto(@RequestBody ProductoCreateDTO productoDTO){
        Producto producto = mapper.toDomain(productoDTO);
        return new ResponseEntity<>(mapper.toDto(this.createProductoUseCase.createProducto(producto)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ProductoDTO> updateProducto(@PathVariable Long id, @RequestBody  ProductoDTO producto ){
        Producto productoUpdated = mapper.toDomain(producto);
        productoUpdated.setId(id);
        return new ResponseEntity<>(mapper.toDto(this.updateProductoUseCase.updateProducto(productoUpdated)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id){
        this.deleteProductoUseCase.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }
}
