package com.patrick.issler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrick.issler.dto.MarcaDTO;
import com.patrick.issler.entity.MarcaEntity;
import com.patrick.issler.exceptionhandler.NotFoundException;
import com.patrick.issler.itg.MarcaItg;
import com.patrick.issler.service.MarcaService;
import com.patrick.issler.utils.MarcaUtils;

@Service
public class MarcaServiceImpl implements MarcaService {

    private final MarcaItg marcaItg;

    @Autowired
    public MarcaServiceImpl(final MarcaItg marcaItg) {
        super();
        this.marcaItg = marcaItg;
    }

    @Override
    public List<MarcaDTO> listMarcas() {
        final List<MarcaEntity> marcaEntityList = marcaItg.listMarcas();
        if(marcaEntityList.isEmpty()){
            throw new NotFoundException("Não existem marcas cadastrados");
        }
        return MarcaUtils.convertEntityListInDTOList(marcaEntityList);
       
    }

    @Override
    public MarcaDTO createMarca(final MarcaDTO marcaDTO) {
        final MarcaEntity marcaEntity = MarcaUtils.convertDTOemEntity(marcaDTO);
        marcaItg.createMarca(marcaEntity);
        return MarcaUtils.convertEntityemDTO(marcaEntity);
    }

    @Override
    public MarcaDTO editMarca(final MarcaDTO marcaDTO) {
        final MarcaEntity marcaEntity = MarcaUtils.convertDTOemEntity(marcaDTO);
        marcaItg.editMarca(marcaEntity);
        return MarcaUtils.convertEntityemDTO(marcaEntity);
    }

    @Override
    public MarcaDTO findMarca(final Long idMarca) {
        final MarcaEntity marcaEntity = marcaItg.findMarca(idMarca);
        return MarcaUtils.convertEntityemDTO(marcaEntity);
     
    }
    
    @Override
    public void delete(final Long idMarca) {
        marcaItg.delete(idMarca);
     
    }



}
