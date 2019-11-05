package com.example.anagrafica.presentation.webui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.example.anagrafica"})
@EntityScan(basePackages = {"com.example.anagrafica"})
@EnableJpaRepositories(basePackages = {"com.example.anagrafica"})
@SpringBootApplication
public class WebuiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebuiApplication.class, args);
	}

}
