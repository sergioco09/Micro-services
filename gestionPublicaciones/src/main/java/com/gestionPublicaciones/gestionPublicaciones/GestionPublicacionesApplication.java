package com.gestionPublicaciones.gestionPublicaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GestionPublicacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionPublicacionesApplication.class, args);
	}

}
