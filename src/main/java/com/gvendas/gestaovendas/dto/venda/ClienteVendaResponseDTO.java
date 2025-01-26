package com.gvendas.gestaovendas.dto.venda;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Schema(name = "Cliente da Venda Response DTO")
public class ClienteVendaResponseDTO {
	
	@Schema(description = "Nome Cliente")
	private String nome;

	@Schema(description = "Venda")
	private List<VendaResponseDTO> vendaResponseDTOs;

}
