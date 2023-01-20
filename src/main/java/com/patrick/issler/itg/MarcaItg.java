package com.patrick.issler.itg;

import java.util.List;

import com.patrick.issler.entity.MarcaEntity;

public interface MarcaItg {

    /**
     * Busca Marcas no banco.
     * @return lista de MarcaEntity
     */
    List<MarcaEntity> listMarcas();

    /**
     * Criar marcas.
     * @param MarcaEntity entidade de marcas.
     */
    void createMarca(MarcaEntity marcaEntity);


    /**
     * Editar marcas.
     * @param MarcaEntity entidade de marcas.
     */
    void editMarca(MarcaEntity marcaEntity);

    /**
     * procurar marcas por id.
     * @param idMarca id do marcas.
     * @return entidade de marcas.
     */
    MarcaEntity findMarca(Long idMarca);

    /**
     * Deletar marca conforme id
     * @param idMarca
     */
    void delete(Long idMarca);
}
