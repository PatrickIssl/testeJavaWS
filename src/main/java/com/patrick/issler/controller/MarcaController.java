package com.patrick.issler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.patrick.issler.dto.MarcaDTO;
import com.patrick.issler.service.MarcaService;

/**
 * Controller para usuarios.
 */
@RestController
@RequestMapping("/marca")
public class MarcaController {
    
    private final MarcaService marcaService;

    @Autowired
    public MarcaController(final MarcaService marcaService) {
        super();
        this.marcaService = marcaService;
    }
    
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MarcaDTO>> listMarcas() {
        return ResponseEntity.ok(marcaService.listMarcas());
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MarcaDTO> createMarca(
            @RequestBody final MarcaDTO marcaDTO
    ){
        return ResponseEntity.ok(marcaService.createMarca(marcaDTO));
    }

    @PutMapping("/{idMarca}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<MarcaDTO> editMarca(@RequestBody final MarcaDTO marcaDTO, @PathVariable final Long idMarca){
        marcaDTO.setId(idMarca);
        return ResponseEntity.ok(marcaService.editMarca(marcaDTO));
    }

    @GetMapping("/{idMarca}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<MarcaDTO> findMarca(@PathVariable final Long idMarca){
        return ResponseEntity.ok(marcaService.findMarca(idMarca));
    }

    @DeleteMapping("/{idMarca}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> deleMarca(@PathVariable final Long idMarca){
        marcaService.delete(idMarca);
        return ResponseEntity.ok("Marca deletada com sucesso");
    }
    
}