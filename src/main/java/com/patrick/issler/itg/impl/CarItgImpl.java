package com.patrick.issler.itg.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrick.issler.entity.CarEntity;
import com.patrick.issler.exceptionhandler.NotFoundException;
import com.patrick.issler.itg.CarItg;
import com.patrick.issler.repository.CarRepository;

@Service
public class CarItgImpl implements CarItg{

    private final CarRepository carRepository;
    
    @Autowired
    public CarItgImpl(final CarRepository carRepository) {
        super();
        this.carRepository = carRepository;
    }

    @Override
    public List<CarEntity> listCars() {
        return carRepository.findAll();
    }

    @Override
    public void createCar(final CarEntity carEntity) {
        carRepository.save(carEntity);
    }

    @Override
    public void editCar(final CarEntity carEntity) {
        carRepository.save(carEntity);
    }

    @Override
    public CarEntity findCar(final Long idCar) {
        final Optional<CarEntity> carEntity = carRepository.findById(idCar);
        if(!carEntity.isPresent()){
            throw new NotFoundException("Carro não cadastrado");
        }
        return carEntity.get();
    }

    @Override
    public void delete(final Long idCar) {
        carRepository.deleteById(idCar);
    }
    
}
