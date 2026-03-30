package br.com.pedropgaraujo.tabela_fipe.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record YearCarData(@JsonAlias("nome") String year,
                          @JsonAlias("codigo") String code) {
}
