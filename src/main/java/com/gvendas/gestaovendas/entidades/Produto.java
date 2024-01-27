package com.gvendas.gestaovendas.entidades;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "descricao")
	@NotBlank(message = "Descrição")
	@Length(min = 3, max = 100, message = "Descrição")
	private String descricao;

	@Column(name = "quantidade")
	@NotNull(message = "Quantidade")
	private Integer quantidade;

	@NotNull(message = "Preço custo")
	@Column(name = "preco_custo")
	private BigDecimal precoCusto;

	@NotNull(message = "Preço venda")
	@Column(name = "preco_venda")
	private BigDecimal precoVenda;

	@Length(max = 500, message = "Observação")
	@Column(name = "observacao")
	private String observacao;

	@NotNull(message = "O código da categoria")
	@ManyToOne
	@JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo")
	private Categoria categoria;

}
