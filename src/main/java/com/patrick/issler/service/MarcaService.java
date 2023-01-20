package com.patrick.issler.service;

import java.util.List;

import com.patrick.issler.dto.MarcaDTO;

/**
 * Classe de serviço para cadastro de marcas.
 * @since 1.0.0
 */
public interface MarcaService {

   /**
    * Listar marcas cadastrados.
    * @return lista de marcas
    */
    List<MarcaDTO> listMarcas();

    /**
     * criar marca.
     * @param marcaDTO dto de marca.
     * @return marcaDTO.
     */
    MarcaDTO createMarca(MarcaDTO marcaDTO);

    /**
     * Editar marca.
     * @param marcaDTO marca dto.
     * @return marcaDTO.
     */
    MarcaDTO editMarca(MarcaDTO marcaDTO);

    /**
     * Buscar marca.
     * @param idCar id do marca
     * @return MarcaDTO.
     */
    MarcaDTO findMarca(Long carId);
    
    /**
     * deletar marca conforme id
     * @param idMarca
     */
    void delete(final Long idMarca);
}
