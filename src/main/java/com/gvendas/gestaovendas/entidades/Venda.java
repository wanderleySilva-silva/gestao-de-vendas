package com.gvendas.gestaovendas.entidades;

import java.time.LocalDate;

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
@Table(name = "tb_venda")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "data")
	private LocalDate data;

	@ManyToOne
	@JoinColumn(name = "tb_cliente_codigo", referencedColumnName = "codigo")
	private Cliente cliente;

}
