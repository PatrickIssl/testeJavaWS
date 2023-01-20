package com.patrick.issler.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "marca")
@Entity
@Component
@Getter @Setter @NoArgsConstructor
public class MarcaEntity {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_marca")
	private String nomeMarca;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "marca")
        private List<ModelEntity> modelos;
	
}