package br.com.lynikerrr.marvelsuniverse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.lynikerrr.marvelsuniverse.principal.Principal;

@SpringBootApplication
public class MarvelsuniverseApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MarvelsuniverseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Principal principal = new Principal();
		principal.menu();	
	}

}
