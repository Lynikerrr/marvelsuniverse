package br.com.lynikerrr.marvelsuniverse.models;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodio {
    private Integer temporada;
    private String titulo;
    private Integer numEp;
    private Double avaliacaoEp;
    private LocalDate dataLancamento;
    public Episodio(Integer numTemp, DadosEp dadosEps) {
        this.temporada = numTemp;
        this.titulo = dadosEps.titulo();
        this.numEp = dadosEps.numEp();

        try{
            
            this.avaliacaoEp = Double.valueOf(dadosEps.avaliacaoEp());
        }catch(NumberFormatException ex){
            this.avaliacaoEp = 0.0;
        }
        try{
            this.dataLancamento = LocalDate.parse(dadosEps.dataLancamento());
        }catch(DateTimeParseException ex){
            this.dataLancamento = null;
        }
        
    }
    public Integer getTemporada() {
        return temporada;
    }
    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Integer getNumEp() {
        return numEp;
    }
    public void setNumEp(Integer numEp) {
        this.numEp = numEp;
    }
    public Double getAvaliacaoEp() {
        return avaliacaoEp;
    }
    public void setAvaliacaoEp(Double avaliacaoEp) {
        this.avaliacaoEp = avaliacaoEp;
    }
    public LocalDate getDataLancamento() {
        return dataLancamento;
    }
    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
    @Override
    public String toString() {
        return "temporada=" + temporada + ", titulo=" + titulo + ", numEp=" + numEp + ", avaliacaoEp="
                + avaliacaoEp + ", dataLancamento=" + dataLancamento;
    }
    
    

}
