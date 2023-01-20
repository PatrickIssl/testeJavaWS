package com.patrick.issler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.patrick.issler.dto.RetornoTesteWSDTO;
import com.patrick.issler.service.CarService;

    /**
     * Controller para retorno dos dados do teste.
     */
    @RestController
    @RequestMapping("/wsWork")
    public class WSTesteController {
        
        private final CarService carService;

        @Autowired
        public WSTesteController(final CarService carService) {
            super();
            this.carService = carService;
        }
        
        @GetMapping("")
        @ResponseStatus(HttpStatus.OK)
        public ResponseEntity<List<RetornoTesteWSDTO>> listCarsReturn() {
            return ResponseEntity.ok(carService.listCarsReturn());
        }
}
