package com.patrick.issler.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class MarcaDTO {
    
            @JsonProperty("marca_id")
            private Long id;
            @JsonProperty("marca_nome")
            private String nomeMarca;
}
