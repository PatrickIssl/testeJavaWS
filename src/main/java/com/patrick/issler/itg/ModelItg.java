package com.patrick.issler.itg;

import java.util.List;

import com.patrick.issler.entity.ModelEntity;

public interface ModelItg {

    /**
     * Busca Modelos no banco.
     * @return lista de ModelEntity
     */
    List<ModelEntity> listModels();

    /**
     * Criar modelos.
     * @param ModelEntity entidade de modelos.
     */
    void createModel(ModelEntity modelEntity);


    /**
     * Editar modelos.
     * @param ModelEntity entidade de modelos.
     */
    void editModel(ModelEntity modelEntity);

    /**
     * procurar modelos por id.
     * @param idModel id do modelos.
     * @return entidade de modelos.
     */
    ModelEntity findModel(Long idModel);

    /**
     * 
     * @param idModel
     */
    void delete(Long idModel);
}
