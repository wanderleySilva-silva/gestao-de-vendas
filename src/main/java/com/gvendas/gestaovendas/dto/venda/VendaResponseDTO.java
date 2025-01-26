package com.gvendas.gestaovendas.dto.venda;

import java.time.LocalDate;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(name = "Venda Response DTO")
public class VendaResponseDTO {
	
	@Schema(description = "Código")
	private Long codigo;

	@Schema(description = "Data")
	private LocalDate data;

	@Schema(description = "Itens da Venda")
	private List<ItemVendaResponseDTO> itemVendaDTOs;

}
