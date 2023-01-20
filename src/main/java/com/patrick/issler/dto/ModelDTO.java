package com.patrick.issler.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ModelDTO {
            @JsonProperty("id")
            private Long id;
            @JsonProperty("nome_modelo")
            private String nome;
            @JsonProperty("valor_fipe")
            private Double valorFipe;
            private MarcaDTO marca;
}
