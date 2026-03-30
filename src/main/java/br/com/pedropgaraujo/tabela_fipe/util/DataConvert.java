package br.com.pedropgaraujo.tabela_fipe.util;

import tools.jackson.databind.ObjectMapper;

public class DataConvert implements IConverteDados {
    private ObjectMapper mapper = new ObjectMapper();


    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        return mapper.readValue(json, classe);


    }
}


