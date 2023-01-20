package com.patrick.issler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrick.issler.dto.CarDTO;
import com.patrick.issler.dto.RetornoTesteWSDTO;
import com.patrick.issler.entity.CarEntity;
import com.patrick.issler.exceptionhandler.NotFoundException;
import com.patrick.issler.itg.CarItg;
import com.patrick.issler.service.CarService;
import com.patrick.issler.utils.CarUtils;

@Service
public class CarServiceImpl implements CarService {

    private final CarItg carItg;

    @Autowired
    public CarServiceImpl(final CarItg carItg) {
        super();
        this.carItg = carItg;
    }

    @Override
    public List<CarDTO> listCars() {
        final List<CarEntity> carEntityList = carItg.listCars();
        if(carEntityList.isEmpty()){
            throw new NotFoundException("Não existem Carros cadastrados");
        }
        return CarUtils.convertEntityListInDTOList(carEntityList);
       
    }

    @Override
    public CarDTO createCar(final CarDTO carDTO) {
        CarEntity carEntity = new CarEntity();
        carEntity = CarUtils.convertDTOemEntity(carDTO);
        carItg.createCar(carEntity);
        return CarUtils.convertEntityemDTO(carEntity);
    }

    @Override
    public CarDTO editCar(final CarDTO carDTO) {
        CarEntity carEntity = new CarEntity();
        carEntity = CarUtils.convertDTOemEntity(carDTO);
        carItg.editCar(carEntity);
        return CarUtils.convertEntityemDTO(carEntity);
    }

    @Override
    public CarDTO findCar(final Long idCar) {
        final CarEntity carEntity = carItg.findCar(idCar);
        return CarUtils.convertEntityemDTO(carEntity);
    }

    @Override
    public List<RetornoTesteWSDTO> listCarsReturn() {
        final List<CarEntity> carEntityList = carItg.listCars();
        if(carEntityList.isEmpty()){
            throw new NotFoundException("Não existem Carros cadastrados");
        }
        return CarUtils.convertCarEntityListInRetornoDTOList(carEntityList);
    }

    
    @Override
    public void delete(final Long idCar) {
        carItg.delete(idCar);
    }

}
