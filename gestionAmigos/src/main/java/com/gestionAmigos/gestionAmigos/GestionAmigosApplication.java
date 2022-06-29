package com.gestionAmigos.gestionAmigos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GestionAmigosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionAmigosApplication.class, args);
	}

}
