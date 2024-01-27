package com.gvendas.gestaovendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.gvendas.gestaovendas.entidades"})
@EnableJpaRepositories(basePackages = {"com.gvendas.gestaovendas.repositorios"})
@ComponentScan(basePackages = {"com.gvendas.gestaovendas.servicos", "com.gvendas.gestaovendas.controladores", "com.gvendas.gestaovendas.excecao"})
@SpringBootApplication
public class GestaoVendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoVendasApplication.class, args);
	}

}
