
package com.gvendas.gestaovendas.controladores.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI configuracao() {
		return new OpenAPI()
				.info(new Info()
						.title("Gestão de Vendas")
						.description("Sistema de gestão de vendas")
						.version("1.0.0")
						);
	}

}
