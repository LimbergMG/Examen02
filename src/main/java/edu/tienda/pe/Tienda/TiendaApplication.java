package edu.tienda.pe.Tienda;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaApplication.class, args);
	}
		@Bean
	public CommandLineRunner ejecutar(){
		return args -> {
			System.out.println("Conectado");
		}; 
	}
}
