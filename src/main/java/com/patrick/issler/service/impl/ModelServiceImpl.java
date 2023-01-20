package com.patrick.issler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrick.issler.dto.ModelDTO;
import com.patrick.issler.entity.ModelEntity;
import com.patrick.issler.exceptionhandler.NotFoundException;
import com.patrick.issler.itg.ModelItg;
import com.patrick.issler.service.ModelService;
import com.patrick.issler.utils.ModelUtils;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelItg modelItg;

    @Autowired
    public ModelServiceImpl(final ModelItg modelItg) {
        super();
        this.modelItg = modelItg;
    }

    @Override
    public List<ModelDTO> listModels() {
        final List<ModelEntity> modelEntityList = modelItg.listModels();
        if(modelEntityList.isEmpty()){
            throw new NotFoundException("Não existem modelos cadastrados");
        }
        return ModelUtils.convertEntityListInDTOList(modelEntityList);
       
    }

    @Override
    public ModelDTO createModel(final ModelDTO modelDTO) {
        final ModelEntity modelEntity = ModelUtils.convertDTOemEntity(modelDTO);
        modelItg.createModel(modelEntity);
        return ModelUtils.convertEntityemDTO(modelEntity);
    }

    @Override
    public ModelDTO editModel(final ModelDTO modelDTO) {
        final ModelEntity modelEntity = ModelUtils.convertDTOemEntity(modelDTO);
        modelItg.editModel(modelEntity);
        return ModelUtils.convertEntityemDTO(modelEntity);
    }

    @Override
    public ModelDTO findModel(final Long idModel) {
        final ModelEntity modelEntity = modelItg.findModel(idModel);
        return ModelUtils.convertEntityemDTO(modelEntity);
    }

    @Override
    public void delete(final Long idModel) {
        modelItg.delete(idModel);
    }

}
