package com.patrick.issler.itg;

import java.util.List;

import com.patrick.issler.entity.CarEntity;

public interface CarItg {

    /**
     * Busca Carros no banco.
     * @return lista de CarEntity
     */
    List<CarEntity> listCars();

    /**
     * Criar Carro.
     * @param CarEntity entidade de Carro.
     */
    void createCar(CarEntity carEntity);


    /**
     * Editar Carro.
     * @param CarEntity entidade de Carro.
     */
    void editCar(CarEntity carEntity);

    /**
     * procurar Carro por id.
     * @param idCar id do Carro.
     * @return entidade de Carro.
     */
    CarEntity findCar(Long idCar);

    /**
     * Excluir carro por id.
     * @param idCar
     */
    void delete(Long idCar);
}
