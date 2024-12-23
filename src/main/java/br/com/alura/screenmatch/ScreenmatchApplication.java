package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Primeiro projeto spring sem Web!!!");

		//ConsumoAPI consumoAPI = new ConsumoAPI();
		var consumoAPI = new ConsumoAPI();
		var json =  consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=5ff471f1");
		System.out.println(json);

//		json = consumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");
//		System.out.println(json);

		// Instancia o conversor de dados e
		// depois chama o obterDados para converter o Json em dadosSerie
		ConverteDados conversor = new ConverteDados();
		DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dadosSerie);


	}
}
