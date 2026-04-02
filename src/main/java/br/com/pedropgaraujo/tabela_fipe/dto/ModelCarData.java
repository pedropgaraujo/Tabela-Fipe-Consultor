package br.com.pedropgaraujo.tabela_fipe.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ModelCarData(@JsonAlias("codigo") String code,
                           @JsonAlias("nome") String name) {
}
