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

import com.patrick.issler.dto.ModelDTO;
import com.patrick.issler.service.ModelService;

/**
 * Controller para usuarios.
 */
@RestController
@RequestMapping("/modelo")
public class ModelController {
    
    private final ModelService modelService;

    @Autowired
    public ModelController(final ModelService modelService) {
        super();
        this.modelService = modelService;
    }
    
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ModelDTO>> listModels() {
        return ResponseEntity.ok(modelService.listModels());
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ModelDTO> createModel(
            @RequestBody final ModelDTO modelDTO
    ){
        return ResponseEntity.ok(modelService.createModel(modelDTO));
    }

    @PutMapping("/{idModel}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<ModelDTO> editModel(@RequestBody final ModelDTO modelDTO, @PathVariable final Long idModel){
        modelDTO.setId(idModel);
        return ResponseEntity.ok(modelService.editModel(modelDTO));
    }

    @GetMapping("/{idModel}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<ModelDTO> findModel(@PathVariable final Long idModel){
        return ResponseEntity.ok(modelService.findModel(idModel));
    }
    
    @DeleteMapping("/{idModel}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> deleMarca(@PathVariable final Long idModel){
        modelService.delete(idModel);
        return ResponseEntity.ok("Marca deletada com sucesso");
    }

}