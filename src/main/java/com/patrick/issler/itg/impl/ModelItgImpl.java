package com.patrick.issler.itg.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrick.issler.entity.ModelEntity;
import com.patrick.issler.exceptionhandler.NotFoundException;
import com.patrick.issler.itg.ModelItg;
import com.patrick.issler.repository.ModelRepository;

@Service
public class ModelItgImpl implements ModelItg{

    private final ModelRepository modelRepository;
    
    @Autowired
    public ModelItgImpl(final ModelRepository modelRepository) {
        super();
        this.modelRepository = modelRepository;
    }

    @Override
    public List<ModelEntity> listModels() {
        return modelRepository.findAll();
    }

    @Override
    public void createModel(final ModelEntity modelEntity) {
        modelRepository.save(modelEntity);
    }

    @Override
    public void editModel(final ModelEntity modelEntity) {
        modelRepository.save(modelEntity);
    }

    @Override
    public ModelEntity findModel(final Long idModel) {
        final Optional<ModelEntity> modelEntity = modelRepository.findById(idModel);
        if(!modelEntity.isPresent()){
            throw new NotFoundException("Modelo não cadastrado");
        }
        return modelEntity.get();
    }

    @Override
    public void delete(final Long idModel) {
        modelRepository.deleteById(idModel);
    }

    
}
