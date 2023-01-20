package com.patrick.issler.service;

import java.util.List;

import com.patrick.issler.dto.ModelDTO;

/**
 * Classe de serviço para cadastro de modelos.
 * @since 1.0.0
 */
public interface ModelService {

   /**
    * Listar modelos cadastrados.
    * @return lista de modelos
    */
    List<ModelDTO> listModels();

    /**
     * criar modelo.
     * @param modelDTO dto de modelo.
     * @return modelDTO.
     */
    ModelDTO createModel(ModelDTO modelDTO);

    /**
     * Editar modelo.
     * @param modelDTO modelo dto.
     * @return modelDTO.
     */
    ModelDTO editModel(ModelDTO modelDTO);

    /**
     * Buscar modelo.
     * @param idCar id do modelo
     * @return ModelDTO.
     */
    ModelDTO findModel(Long carId);

    /**
     * Deletar modelo pelo id
     * @param idModel
     */
    void delete(Long idModel);
}
