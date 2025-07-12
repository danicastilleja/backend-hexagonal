package com.icodeapp.proyectospring.api.factura;

import com.icodeapp.proyectospring.api.factura.dto.FacturaRequestDTO;
import com.icodeapp.proyectospring.api.factura.dto.FacturaResponseDTO;
import com.icodeapp.proyectospring.api.factura.mapper.FacturaMapper;
import com.icodeapp.proyectospring.application.factura.usecase.CreateFacturaUseCase;
import com.icodeapp.proyectospring.application.factura.usecase.DeleteFacturaUseCase;
import com.icodeapp.proyectospring.application.factura.usecase.GetFacturaUseCase;
import com.icodeapp.proyectospring.application.factura.usecase.GetFacturasUseCase;
import com.icodeapp.proyectospring.domain.factura.model.Factura;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    private final CreateFacturaUseCase createFacturaUseCase;
    private final GetFacturaUseCase getFacturaUseCase;
    private final GetFacturasUseCase getFacturasUseCase;
    private final DeleteFacturaUseCase deleteFacturaUseCase;
    private final FacturaMapper mapper;

    public FacturaController(CreateFacturaUseCase createFacturaUseCase, GetFacturaUseCase getFacturaUseCase, GetFacturasUseCase getFacturasUseCase, DeleteFacturaUseCase deleteFacturaUseCase, FacturaMapper mapper) {
        this.createFacturaUseCase = createFacturaUseCase;
        this.getFacturaUseCase = getFacturaUseCase;
        this.getFacturasUseCase = getFacturasUseCase;
        this.deleteFacturaUseCase = deleteFacturaUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<FacturaResponseDTO>> getAllFacturas(){
        List<FacturaResponseDTO> facturas = getFacturasUseCase.getFacturas().stream().map(mapper::toDTO).toList();
        return ResponseEntity.ok(facturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaResponseDTO> getFactura(@PathVariable Long id){
        FacturaResponseDTO factura = mapper.toDTO(getFacturaUseCase.getFactura(id));
        return ResponseEntity.ok(factura);
    }

    @PostMapping
    public ResponseEntity<FacturaResponseDTO> crearFactura(@RequestBody FacturaRequestDTO facturaRequestDTO){
        Factura factura = createFacturaUseCase.createFactura(mapper.toDomain(facturaRequestDTO));
        return ResponseEntity.ok(mapper.toDTO(factura));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFactura(@PathVariable Long id){
        this.deleteFacturaUseCase.deleteFactura(id);
        return ResponseEntity.noContent().build();
    }


}
