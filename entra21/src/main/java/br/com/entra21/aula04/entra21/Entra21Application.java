package br.com.entra21.aula04.entra21;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Entra21Application implements CommandLineRunner{
	@Autowired
	private JdbcTemplate jdbc;
	public static void main(String[] args) {
		SpringApplication.run(Entra21Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql = "INSERT INTO programador (nome, qtd_linguagem) VALUES (?, ?)"; 

		int result = jdbc.update(sql, "Ariana", 3);
		
		String sql2 = "INSERT INTO superhero (super_name, super_power) VALUES (?, ?)";
		 int super_result = jdbc.update(sql2, "Peter Parker", "pular de prédio em prédio rs");
		
	}

}
