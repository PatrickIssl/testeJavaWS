package com.patrick.issler.entity;


import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "carro")
@Entity
@Component
@Getter @Setter @NoArgsConstructor
public class CarEntity {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "timestamp_cadastro")
	private Timestamp timestampCadastro;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "modelo_id")
	private ModelEntity modelo;
	
	@Column(name = "ano")
	private int ano;
	
	@Column(name = "combustivel")
	private String combustivel;
	
	@Column(name = "num_portas")
	private int numPortas;
	
	@Column(name = "cor")
	private String cor;
	

}