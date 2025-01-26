package com.gvendas.gestaovendas.dto.venda;

import java.time.LocalDate;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "Venda requisição DTO")
public class VendaRequestDTO {
	
	@Schema(description = "Data")
	@NotNull(message = "Data")
	private LocalDate data;

	@Schema(description = "Itens da venda")
	@NotNull(message = "Itens venda")
	@Valid
	private List<ItemVendaRequestDTO> itensVendaDto;

}
