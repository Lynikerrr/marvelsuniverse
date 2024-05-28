package br.com.lynikerrr.marvelsuniverse.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosMarvel(@JsonAlias("Title") String titulo, @JsonAlias("totalSeasons") Integer totalTemp, @JsonAlias("imdbRating") String avaliacao) {

    
}
