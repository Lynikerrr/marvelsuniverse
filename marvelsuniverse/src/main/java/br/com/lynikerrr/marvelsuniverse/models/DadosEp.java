package br.com.lynikerrr.marvelsuniverse.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEp(@JsonAlias("Title") String titulo, @JsonAlias("Episode") Integer numEp, @JsonAlias("imdbRating") String avaliacaoEp, @JsonAlias("Released") String dataLancamento) {
    
}
 