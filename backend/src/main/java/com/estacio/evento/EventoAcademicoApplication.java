package com.estacio.evento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;

@SpringBootApplication
public class EventoAcademicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventoAcademicoApplication.class, args);
	}

//	@Bean
//	public static EntityManager entityManager() {
//		return new EntityManager() {
//		}
//	}

}
