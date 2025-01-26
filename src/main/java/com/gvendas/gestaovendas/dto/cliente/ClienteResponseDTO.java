package com.gvendas.gestaovendas.dto.cliente;

import com.gvendas.gestaovendas.dto.endereco.EnderecoResponseDTO;
import com.gvendas.gestaovendas.entidades.Cliente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Schema(name = "Cliente Response DTO", description = "Cliente Response DTO")
public class ClienteResponseDTO {

	@Schema(name = "Código")
	private Long codigo;

	@Schema(name = "Nome")
	private String nome;

	@Schema(name = "Telefone")
	private String telefone;

	@Schema(name = "Ativo")
	private Boolean ativo;

	private EnderecoResponseDTO enderecoResponseDTO;

	public static ClienteResponseDTO converterClienteParaClienteResponseDto(Cliente cliente) {

		EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO(cliente.getEndereco().getLogradouro(),
				cliente.getEndereco().getNumero(), cliente.getEndereco().getComplemento(),
				cliente.getEndereco().getBairro(), cliente.getEndereco().getCep(), cliente.getEndereco().getCidade(),
				cliente.getEndereco().getEstado());
		return new ClienteResponseDTO(cliente.getCodigo(), cliente.getNome(), cliente.getTelefone(), cliente.getAtivo(),
				enderecoResponseDTO);
	}

}
