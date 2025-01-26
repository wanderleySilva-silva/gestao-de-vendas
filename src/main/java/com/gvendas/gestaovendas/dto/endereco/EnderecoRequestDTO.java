package com.gvendas.gestaovendas.dto.endereco;

import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "Endereço Requisição DTO", description = "Endereço Requisição DTO")
public class EnderecoRequestDTO {

	@Schema(description = "Logradouro")
	@NotBlank(message = "Logradouro")
	@Length(min = 3, max = 30, message = "Logradouro")
	private String logradouro;

	@Schema(description = "Número")
	@NotNull(message = "Número")
	private Integer numero;

	@Schema(description = "complemento")
	@Length(max = 30, message = "Complemento")
	private String complemento;

	@Schema(description = "Bairro")
	@NotBlank(message = "Bairro")
	@Length(min = 3, max = 30, message = "Bairro")
	private String bairro;

	
	@Schema(description = "CEP")
	@NotBlank(message = "CEP")
	@Pattern(regexp = "[\\d]{5}-[\\d]{3}", message = "CEP")
	private String cep;

	@Schema(description = "Cidade")
	@NotBlank(message = "Cidade")
	@Length(min = 3, max = 30, message = "Cidade")
	private String cidade;

	@Schema(description = "Estado")
	private String estado;

}
