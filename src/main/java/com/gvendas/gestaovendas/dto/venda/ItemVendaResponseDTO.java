package com.gvendas.gestaovendas.dto.venda;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(name = "Itens Venda Response DTO")
public class ItemVendaResponseDTO {
	
	@Schema(description = "Código")
	private Long codigo;
	
	@Schema(description = "Quantidade")
	private Integer quantidade;
	
	@Schema(description = "Preço Venda")
	private BigDecimal precoVenda;
			
	@Schema(description = "Código Produto")
	private Long codigoProduto;
	
	@Schema(description = "Descrição Produto")
	private String descricaoProduto;

}
