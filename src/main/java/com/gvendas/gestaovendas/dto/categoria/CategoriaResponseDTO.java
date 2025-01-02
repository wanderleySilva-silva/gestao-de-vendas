package com.gvendas.gestaovendas.dto.categoria;

import com.gvendas.gestaovendas.entidades.Categoria;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(name = "Categoria Response DTO", description = "Categoria Response DTO")
public class CategoriaResponseDTO {
	
	@Schema(name = "Código")
	private Long codigo;
	
	@Schema(name = "Nome")
	private String nome;

	public static CategoriaResponseDTO converterCategoriaParaCategoriaResponseDTO(Categoria categoria) {
		return new CategoriaResponseDTO(categoria.getCodigo(), categoria.getNome());
	}
}
