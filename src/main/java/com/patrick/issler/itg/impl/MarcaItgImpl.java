package com.patrick.issler.itg.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrick.issler.entity.MarcaEntity;
import com.patrick.issler.exceptionhandler.NotFoundException;
import com.patrick.issler.itg.MarcaItg;
import com.patrick.issler.repository.MarcaRepository;

@Service
public class MarcaItgImpl implements MarcaItg{

    private final MarcaRepository marcaRepository;
    
    @Autowired
    public MarcaItgImpl(final MarcaRepository marcaRepository) {
        super();
        this.marcaRepository = marcaRepository;
    }

    @Override
    public List<MarcaEntity> listMarcas() {
        return marcaRepository.findAll();
    }

    @Override
    public void createMarca(final MarcaEntity marcaEntity) {
        marcaRepository.save(marcaEntity);
    }

    @Override
    public void editMarca(final MarcaEntity marcaEntity) {
        marcaRepository.save(marcaEntity);
    }

    @Override
    public MarcaEntity findMarca(final Long idMarca) {
        final Optional<MarcaEntity> marcaEntity = marcaRepository.findById(idMarca);
        if(!marcaEntity.isPresent()){
            throw new NotFoundException("Marca não cadastrado");
        }
        return marcaEntity.get();
    }
    
    @Override
    public void delete(final Long idMarca) {
        marcaRepository.deleteById(idMarca);
    }

}
