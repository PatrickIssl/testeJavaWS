package com.patrick.issler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patrick.issler.entity.MarcaEntity;


@Repository
public interface MarcaRepository extends JpaRepository<MarcaEntity, Long> { 
	
}
