package com.gvendas.gestaovendas.dto.cliente;

import org.hibernate.validator.constraints.Length;

import com.gvendas.gestaovendas.dto.endereco.EnderecoRequestDTO;
import com.gvendas.gestaovendas.entidades.Cliente;
import com.gvendas.gestaovendas.entidades.Endereco;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "Cliente Requisição DTO", description = "Cliente Requisição DTO")
public class ClienteRequestDTO {

	@Schema(description = "Nome")
	@NotBlank(message = "Nome")
	@Length(min = 3, max = 50, message = "Nome")
	private String nome;

	@Schema(description = "Telefone")
	@NotBlank(message = "Telefone")
	@Pattern(regexp = "\\([\\d]{2}\\)[\\d]{5}[- .][\\d]{4}", message = "Telefone")
	private String telefone;

	@Schema(description = "Ativo")
	@NotNull(message = "Ativo")
	private Boolean ativo;

	@Schema(description = "Endereço RequestDTO")
	@NotNull(message = "Endereço")
	@Valid
	private EnderecoRequestDTO enderecoRequestDTO;

	public Cliente converterParaEntidade() {
		Endereco endereco = new Endereco(enderecoRequestDTO.getLogradouro(), enderecoRequestDTO.getNumero(),
				enderecoRequestDTO.getComplemento(), enderecoRequestDTO.getBairro(), enderecoRequestDTO.getCep(),
				enderecoRequestDTO.getCidade(), enderecoRequestDTO.getEstado());
		
		return new Cliente(nome, telefone, ativo, endereco);
	}
	
	public Cliente converterParaEntidade(Long codigo) {
		Endereco endereco = new Endereco(enderecoRequestDTO.getLogradouro(), enderecoRequestDTO.getNumero(),
				enderecoRequestDTO.getComplemento(), enderecoRequestDTO.getBairro(), enderecoRequestDTO.getCep(),
				enderecoRequestDTO.getCidade(), enderecoRequestDTO.getEstado());
		
		return new Cliente(codigo, nome, telefone, ativo, endereco);
	}

}
