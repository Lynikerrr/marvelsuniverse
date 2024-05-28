package br.com.lynikerrr.marvelsuniverse.service;

public interface IConverterDados {
    <T> T obterDados(String json, Class<T> classe);
    
}
