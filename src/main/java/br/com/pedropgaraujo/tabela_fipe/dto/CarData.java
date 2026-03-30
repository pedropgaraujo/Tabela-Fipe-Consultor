package br.com.pedropgaraujo.tabela_fipe.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CarData(@JsonAlias("Modelo") ModelCarData model,
                      @JsonAlias("Marca") BrandCarData brand,
                      @JsonAlias("AnoModelo") String year,
                      @JsonAlias("Valor") String value) {
}
