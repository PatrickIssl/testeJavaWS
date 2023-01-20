package com.patrick.issler.utils;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.patrick.issler.dto.CarDTO;
import com.patrick.issler.dto.RetornoTesteWSDTO;
import com.patrick.issler.entity.CarEntity;

/**
 * Classe responsavel pelos conversores de Entidades e DTOs de Carros.
 */
public final class CarUtils {

    private CarUtils() {
        super();
    }
    
    /**
     * ConverterDTOEmEntidade sem perder os dados
     * @param carDTO
     * @return entidade de carros
     */
    public static CarEntity convertDTOemEntity(final CarDTO carDTO){
        final Gson gson= new Gson();
        final String tmp = gson.toJson(carDTO);
        final CarEntity carEntity = gson.fromJson(tmp,CarEntity.class);
        return carEntity;
    }
    
    /**
     * convertEntityemDTO sem perder os dados
     * @param carEntity
     * @return entidade de carros
     */
    public static CarDTO convertEntityemDTO(final CarEntity carEntity){
        carEntity.getModelo().setCarros(null);
        carEntity.getModelo().getMarca().setModelos(null);
        final Gson gson= new Gson();
        final String tmp = gson.toJson(carEntity);
        final CarDTO carDTO = gson.fromJson(tmp,CarDTO.class);
        return carDTO;
    }
    
    /**
     * converter lista de dto em lista entity.
     * @param listDTO lista de dtos
     * @return lista de entidades.
     */
    public static List<CarEntity> convertDTOListInEntityList(final List<CarDTO> listDTO){
        final List<CarEntity> carEntityList = new ArrayList<>();
        for(final CarDTO carDTO: listDTO){
            final CarEntity carEntity = convertDTOemEntity(carDTO);
            carEntityList.add(carEntity);
        }
        return carEntityList;
    }

    /**
     * converter lista de entidade em lista dto.
     * @param listEntity lista de entidades
     * @return lista de dtos.
     */
    public static List<CarDTO> convertEntityListInDTOList(final List<CarEntity> listEntity){
        final List<CarDTO> carDTOList = new ArrayList<>();
        for(final CarEntity carEntity: listEntity){
            carEntity.getModelo().setCarros(null);
            carEntity.getModelo().getMarca().setModelos(null);
            carDTOList.add(convertEntityemDTO(carEntity));
        }
        return carDTOList;
    }
    
    /**
     * converter lista de entidade de carros em lista de retorno dto.
     * @param listEntity lista de entidade de carros
     * @return lista de dtos de retorno.
     */
    public static List<RetornoTesteWSDTO> convertCarEntityListInRetornoDTOList(final List<CarEntity> listEntity){
        final List<RetornoTesteWSDTO> retornoDTOList = new ArrayList<>();
        for(final CarEntity carEntity: listEntity){
            final RetornoTesteWSDTO itemRetorno = new RetornoTesteWSDTO();
            itemRetorno.setId(carEntity.getId());
            itemRetorno.setMarcaId(carEntity.getModelo().getMarca().getId());
            itemRetorno.setMarcaNome(carEntity.getModelo().getMarca().getNomeMarca());
            itemRetorno.setNomeModelo(carEntity.getModelo().getNome());
            itemRetorno.setAno(carEntity.getAno());
            itemRetorno.setCombustivel(carEntity.getCombustivel());
            itemRetorno.setNumPortas(carEntity.getNumPortas());
            itemRetorno.setValorFipe(carEntity.getModelo().getValorFipe());
            itemRetorno.setCor(carEntity.getCor());
            itemRetorno.setTimestampCadastro(carEntity.getTimestampCadastro());
            retornoDTOList.add(itemRetorno);
        }
        
        return retornoDTOList;
    }
   
}
