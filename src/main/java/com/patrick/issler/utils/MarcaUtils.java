package com.patrick.issler.utils;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.patrick.issler.dto.MarcaDTO;
import com.patrick.issler.entity.MarcaEntity;

/**
 * Classe responsavel pelos conversores de Entidades e DTOs de marcas.
 */
public final class MarcaUtils {

    private MarcaUtils() {
        super();
    }
    

    /**
     * ConverterDTOEmEntidade sem perder os dados
     * @param MarcaDTO
     * @return entidade de carros
     */
    public static MarcaEntity convertDTOemEntity(final MarcaDTO marcaDTO){
        final Gson gson= new Gson();
        final String tmp = gson.toJson(marcaDTO);
        final MarcaEntity marcaEntity = gson.fromJson(tmp,MarcaEntity.class);
        return marcaEntity;
    }
    
    /**
     * convertEntityemDTO sem perder os dados
     * @param MarcaEntity
     * @return entidade de marca
     */
    public static MarcaDTO convertEntityemDTO(final MarcaEntity marcaEntity){
        marcaEntity.setModelos(null);
        final Gson gson= new Gson();
        final String tmp = gson.toJson(marcaEntity);
        final MarcaDTO marcaDTO = gson.fromJson(tmp,MarcaDTO.class);
        return marcaDTO;
    }
    

    /**
     * converter lista de dto em lista entity.
     * @param listDTO lista de dtos
     * @return lista de entidades.
     */
    public static List<MarcaEntity> convertDTOListInEntityList(final List<MarcaDTO> listDTO){
        final List<MarcaEntity> marcaEntityList = new ArrayList<>();
        for(final MarcaDTO marcaDTO: listDTO){
            marcaEntityList.add(convertDTOemEntity(marcaDTO));
        }
        return marcaEntityList;
    }

    /**
     * converter lista de entidade em lista dto.
     * @param listEntity lista de entidades
     * @return lista de dtos.
     */
    public static List<MarcaDTO> convertEntityListInDTOList(final List<MarcaEntity> listEntity){
        final List<MarcaDTO> marcaDTOList = new ArrayList<>();
        for(final MarcaEntity marcaEntity: listEntity){
            marcaDTOList.add(convertEntityemDTO(marcaEntity));
        }
        return marcaDTOList;
    }

    
}
