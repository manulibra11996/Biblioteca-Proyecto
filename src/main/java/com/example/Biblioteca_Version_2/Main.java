package com.example.Biblioteca_Version_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		// inicializar spring
		ApplicationContext spring = SpringApplication.run(Main.class, args);

	}
}