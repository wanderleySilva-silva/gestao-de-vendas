package com.gvendas.gestaovendas.entidades;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "tb_item_venda")
public class ItemVenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "quantidade")
	private Integer quantidade;

	@Column(name = "preco_venda")
	private BigDecimal precoVenda;

	@ManyToOne
	@JoinColumn(name = "tb_produto_codigo", referencedColumnName = "codigo")
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "tb_venda_codigo", referencedColumnName = "codigo")
	private Venda venda;
	
	public ItemVenda() {
	}

	public ItemVenda(Long codigo, Integer quantidade, BigDecimal precoVenda, Produto produto, Venda venda) {
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.precoVenda = precoVenda;
		this.produto = produto;
		this.venda = venda;
	}
	
	public ItemVenda(Integer quantidade, BigDecimal precoVenda, Produto produto, Venda venda) {
		this.quantidade = quantidade;
		this.precoVenda = precoVenda;
		this.produto = produto;
		this.venda = venda;
	}
}
