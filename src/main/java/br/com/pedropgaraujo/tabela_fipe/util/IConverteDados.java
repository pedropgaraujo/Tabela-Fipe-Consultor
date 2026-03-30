package br.com.pedropgaraujo.tabela_fipe.util;

public interface IConverteDados {

    <T> T obterDados (String json, Class<T> classe);
}
