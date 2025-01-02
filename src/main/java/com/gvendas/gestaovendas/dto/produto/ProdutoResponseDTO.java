package com.gvendas.gestaovendas.dto.produto;

import java.math.BigDecimal;

import com.gvendas.gestaovendas.dto.categoria.CategoriaResponseDTO;
import com.gvendas.gestaovendas.entidades.Produto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "Produto retorno DTO", name = "Produto retorno DTO")
public class ProdutoResponseDTO {

	@Schema(name = "Código")
	private Long codigo;

	@Schema(name = "Descrição")
	private String descricao;

	@Schema(name = "Quantidade")
	private Integer quantidade;

	@Schema(name = "Preço Custo")
	private BigDecimal precoCusto;

	@Schema(name = "Preço Venda")
	private BigDecimal precoVenda;

	@Schema(name = "Observação")
	private String observacao;

	@Schema(name = "Categoria")
	private CategoriaResponseDTO categoriaDto;

	public static ProdutoResponseDTO converterProdutoParaProdutoResponseDto(Produto produto) {
		return new ProdutoResponseDTO(produto.getCodigo(), produto.getDescricao(), produto.getQuantidade(),
				produto.getPrecoCusto(), produto.getPrecoVenda(), produto.getObservacao(),
				CategoriaResponseDTO.converterCategoriaParaCategoriaResponseDTO(produto.getCategoria()));
	}
}
