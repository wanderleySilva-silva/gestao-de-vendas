package com.gvendas.gestaovendas.dto.produto;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import com.gvendas.gestaovendas.entidades.Categoria;
import com.gvendas.gestaovendas.entidades.Produto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Produto requisição DTO", name = "Produto requisição DTO")
public class ProdutoRequestDTO {
	
	@Schema(name = "Descrição")
	@NotBlank(message = "Descrição")
	@Length(min = 3, max = 100, message = "Descrição")
	private String descricao;

	@Schema(name = "Quantidade")
	@NotNull(message = "Quantidade")
	private Integer quantidade;

	@Schema(name = "Preço Custo")
	@NotNull(message = "Preço custo")
	private BigDecimal precoCusto;

	@Schema(name = "Preço Venda")
	@NotNull(message = "Preço venda")
	private BigDecimal precoVenda;

	@Schema(name = "Observação")
	@Length(max = 500, message = "Observação")
	private String observacao;
	
	
	public Produto converterParaEntidade(Long codigoCategoria) {
		return new Produto(descricao, quantidade, precoCusto, precoVenda, observacao, new Categoria(codigoCategoria));
	}
	
	public Produto converterParaEntidade(Long codigoCategoria, Long codigoProduto) {
		return new Produto(codigoProduto, descricao, quantidade, precoCusto, precoVenda, observacao, new Categoria(codigoCategoria));
	}

}
