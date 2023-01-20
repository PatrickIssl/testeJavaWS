package com.patrick.issler.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "modelo")
@Entity
@Component
@Getter @Setter @NoArgsConstructor
public class ModelEntity {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_modelo")
	private String nome;
	
	@Column(name = "valor_fipe")
	private Double valorFipe;
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "modelo")
	private List<CarEntity> carros;
	
	@ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "marca_id")
        private MarcaEntity marca;
	

}