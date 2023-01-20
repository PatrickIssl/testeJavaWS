package com.patrick.issler.utils;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.patrick.issler.dto.ModelDTO;
import com.patrick.issler.entity.CarEntity;
import com.patrick.issler.entity.ModelEntity;

/**
 * Classe responsavel pelos conversores de Entidades e DTOs de Model.
 */
public final class ModelUtils {

    private ModelUtils() {
        super();
    }
    
    /**
     * ConverterDTOEmEntidade sem perder os dados
     * @param ModelDTO
     * @return entidade de carros
     */
    public static ModelEntity convertDTOemEntity(final ModelDTO modelDTO){
        final Gson gson= new Gson();
        final String tmp = gson.toJson(modelDTO);
        return gson.fromJson(tmp,ModelEntity.class);
      
    }
    
    /**
     * convertEntityemDTO sem perder os dados
     * @param ModelEntity
     * @return entidade de carros
     */
    public static ModelDTO convertEntityemDTO(final ModelEntity modelEntity){
        modelEntity.getMarca().setModelos(null);
        if(modelEntity.getCarros() != null) {
            for (final CarEntity carro : modelEntity.getCarros()) {
                carro.setModelo(null);
            }
        }
        final Gson gson= new Gson();
        final String tmp = gson.toJson(modelEntity);
        return gson.fromJson(tmp,ModelDTO.class);
    }
    

    /**
     * converter lista de dto em lista entity.
     * @param listDTO lista de dtos
     * @return lista de entidades.
     */
    public static List<ModelEntity> convertDTOListInEntityList(final List<ModelDTO> listDTO){
        final List<ModelEntity> modelEntityList = new ArrayList<>();
        for(final ModelDTO modelDTO: listDTO){
            modelEntityList.add(convertDTOemEntity(modelDTO));
        }
        return modelEntityList;
    }

    /**
     * converter lista de entidade em lista dto.
     * @param listEntity lista de entidades
     * @return lista de dtos.
     */
    public static List<ModelDTO> convertEntityListInDTOList(final List<ModelEntity> listEntity){
        final List<ModelDTO> modelDTOList = new ArrayList<>();
        for(final ModelEntity modelEntity: listEntity){
            modelDTOList.add(convertEntityemDTO(modelEntity));
        }
        return modelDTOList;
    }

    
}
