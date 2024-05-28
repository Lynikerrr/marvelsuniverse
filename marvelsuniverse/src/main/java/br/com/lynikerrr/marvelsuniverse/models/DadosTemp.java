package br.com.lynikerrr.marvelsuniverse.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemp(@JsonAlias("Season")Integer numero, @JsonAlias("Episodes") List<DadosEp> episodios) {
    
}
