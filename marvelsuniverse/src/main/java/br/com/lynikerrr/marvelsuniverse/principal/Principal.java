package br.com.lynikerrr.marvelsuniverse.principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.lynikerrr.marvelsuniverse.models.DadosEp;
import br.com.lynikerrr.marvelsuniverse.models.DadosMarvel;
import br.com.lynikerrr.marvelsuniverse.models.DadosTemp;
import br.com.lynikerrr.marvelsuniverse.models.Episodio;
import br.com.lynikerrr.marvelsuniverse.service.ConsumoAPI;
import br.com.lynikerrr.marvelsuniverse.service.ConverterDados;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverterDados conversor = new ConverterDados();

    private final String SITE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=fcbed685";

    public void menu() {
        System.out.println("***************************************");
        System.out.println("*****Bem-vindo ao Marvels Universe*****");
        System.out.println("*******Digite o nome da série: ********");
        System.out.println("***************************************");
        var nomeSerie = teclado.nextLine();
        var json = consumo.obterDados(SITE + nomeSerie.replace(" ", "+") + API_KEY);
        DadosMarvel dados = conversor.obterDados(json, DadosMarvel.class);
        System.out.println(dados);

        List<DadosTemp> temporadas = new ArrayList<>();

        for (int i = 1; i <= dados.totalTemp(); i++) {
            json = consumo.obterDados(SITE + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
            DadosTemp dadosTemp = conversor.obterDados(json, DadosTemp.class);
            temporadas.add(dadosTemp);
        }
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        List<DadosEp> dadosEps = temporadas.stream().flatMap(t -> t.episodios().stream()).collect(Collectors.toList());

        dadosEps.stream().filter(e -> !e.avaliacaoEp().equalsIgnoreCase("N/A")).sorted(Comparator.comparing(DadosEp::avaliacaoEp).reversed()).limit(5).forEach((System.out::println));

        List<Episodio> episodios = temporadas.stream().flatMap(t -> t.episodios().stream().map(e -> new Episodio(t.numero(), e))).collect(Collectors.toList());

        episodios.forEach(System.out::println);
        
    }
}
