package com.patrick.issler.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class RetornoTesteWSDTO {
    
    @JsonProperty("id")
    private Long id;
    @JsonProperty("marca_id")
    private Long marcaId;
    @JsonProperty("marca_nome")
    private String marcaNome;
    @JsonProperty("nome_modelo")
    private String nomeModelo;
    @JsonProperty("ano")
    private int ano;
    @JsonProperty("combustivel")
    private String combustivel;
    @JsonProperty("num_portas")
    private int numPortas;
    @JsonProperty("valor_fipe")
    private Double valorFipe;
    @JsonProperty("cor")
    private String cor;
    @JsonProperty("timestamp_cadastro")
    private Timestamp timestampCadastro;
}
