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

import com.patrick.issler.dto.CarDTO;
import com.patrick.issler.service.CarService;

/**
 * Controller para carros.
 */
@RestController
@RequestMapping("/carro")
public class CarController {
    
    private final CarService carService;

    @Autowired
    public CarController(final CarService carService) {
        super();
        this.carService = carService;
    }
    
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CarDTO>> listCars() {
        return ResponseEntity.ok(carService.listCars());
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CarDTO> createCar(
            @RequestBody final CarDTO carDTO
    ){
        return ResponseEntity.ok(carService.createCar(carDTO));
    }

    @PutMapping("/{idCar}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<CarDTO> editCar(@RequestBody final CarDTO carDTO, @PathVariable final Long idCar){
        carDTO.setId(idCar);
        return ResponseEntity.ok(carService.editCar(carDTO));
    }

    @GetMapping("/{idCar}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<CarDTO> findCar(@PathVariable final Long idCar){
        return ResponseEntity.ok(carService.findCar(idCar));
    }

    @DeleteMapping("/{idCar}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> deleMarca(@PathVariable final Long idCar){
        carService.delete(idCar);
        return ResponseEntity.ok("Marca deletada com sucesso");
    }
    
}