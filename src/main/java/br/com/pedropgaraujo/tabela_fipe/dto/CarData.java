package br.com.pedropgaraujo.tabela_fipe.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CarData(@JsonAlias("Valor") String value,
                      @JsonAlias("AnoModelo") String year,
                      @JsonAlias("Modelo") String name,
                      @JsonAlias("Marca") String brand) {
}
