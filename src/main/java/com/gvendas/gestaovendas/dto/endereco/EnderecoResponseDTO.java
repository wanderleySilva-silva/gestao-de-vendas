package com.gvendas.gestaovendas.dto.endereco;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(name = "Endeço Response DTO", description = "Endereço Response DTO")
public class EnderecoResponseDTO {
	
	@Schema(name = "Logradouro")
	private String logradouro;
	
	@Schema(name = "Número")
	private Integer numero;
	
	@Schema(name = "Complemento")
	private String complemento;
	
	@Schema(name = "Bairro")
	private String bairro;
	
	@Schema(name = "CEP")
	private String cep;
	
	@Schema(name = "Cidade")
	private String cidade;
	
	@Schema(name = "Estado")
	private String estado;

}
