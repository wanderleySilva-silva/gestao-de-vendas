package com.gvendas.gestaovendas.dto.categoria;

import org.hibernate.validator.constraints.Length;

import com.gvendas.gestaovendas.entidades.Categoria;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(name = "Categoria Requisição DTO", description = "Categoria Requisição DTO")
public class CategoriaRequestDTO {
	
	@NotBlank(message = "Nome")
	@Length(min = 3, max = 50, message = "Nome")
	@Schema(name = "Nome")
	private String nome;
	
	public Categoria converterParaEntidade() {
		return new Categoria(nome);
	}
	
	public Categoria converterParaEntidade(Long codigo) {
		return new Categoria(codigo, nome);
	}
}
