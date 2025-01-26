package com.gvendas.gestaovendas.dto.venda;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "Itens da Venda Requisição DTO")
public class ItemVendaRequestDTO {

	@Schema(description = "Código produto")
	@NotNull(message = "Código produto")
	private Long codigoProduto;
	
	@Schema(description = "Quantidade")
	@NotNull(message = "Quantidade")
	@Min(value = 1, message = "Quantidade")
	private Integer quantidade;
	
	@Schema(description = "Preço Venda")
	@NotNull(message = "Preço venda")
	private BigDecimal precoVenda;
}
