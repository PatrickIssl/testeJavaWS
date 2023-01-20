package com.patrick.issler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patrick.issler.entity.ModelEntity;


@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> { 
	
}
