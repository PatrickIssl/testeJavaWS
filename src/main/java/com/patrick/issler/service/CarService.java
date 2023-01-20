package com.patrick.issler.service;

import java.util.List;

import com.patrick.issler.dto.CarDTO;
import com.patrick.issler.dto.RetornoTesteWSDTO;

/**
 * Classe de serviço para cadastro de carros.
 * @since 1.0.0
 */
public interface CarService {

   /**
    * Listar carros cadastrados.
    * @return lista de carros
    */
    List<CarDTO> listCars();

    /**
     * Listar carros cadastrados conforme pedido no teste.
     * @return lista de carros conforme o teste
     */
    List<RetornoTesteWSDTO> listCarsReturn();

    /**
     * criar carro.
     * @param carDTO dto de carro.
     * @return carDTO.
     */
    CarDTO createCar(CarDTO carDTO);

    /**
     * Editar carro.
     * @param carDTO carro dto.
     * @return carDTO.
     */
    CarDTO editCar(CarDTO carDTO);

    /**
     * Buscar carro.
     * @param idCar id do carro
     * @return CarDTO.
     */
    CarDTO findCar(Long carId);

    /**
     * Deletar carro pelo id.
     * @param idCar
     */
    void delete(Long idCar);
}
