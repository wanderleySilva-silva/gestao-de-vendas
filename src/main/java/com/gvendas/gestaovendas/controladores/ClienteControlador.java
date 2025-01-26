package com.gvendas.gestaovendas.controladores;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gvendas.gestaovendas.dto.cliente.ClienteRequestDTO;
import com.gvendas.gestaovendas.dto.cliente.ClienteResponseDTO;
import com.gvendas.gestaovendas.entidades.Cliente;
import com.gvendas.gestaovendas.servicos.ClienteServico;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
@Tag(name = "Clientes", description = "Cliente controlador")
public class ClienteControlador {

	@Autowired
	private ClienteServico clienteServico;

	@Operation(summary = "Listar")
	@GetMapping
	public List<ClienteResponseDTO> listarTodos() {
		return clienteServico.listarTodos().stream()
				.map(cliente -> ClienteResponseDTO.converterClienteParaClienteResponseDto(cliente))
				.collect(Collectors.toList());
	}

	@Operation(summary = "Listar por código")
	@GetMapping("/{codigo}")
	public ResponseEntity<ClienteResponseDTO> buscaPorCodigo(@PathVariable(name = "codigo") Long codigo) {
		Optional<Cliente> cliente = clienteServico.buscarClientePorCodigo(codigo);

		return cliente.isPresent()
				? ResponseEntity.ok(ClienteResponseDTO.converterClienteParaClienteResponseDto(cliente.get()))
				: ResponseEntity.notFound().build();
	}
	
	@Operation(summary = "Salvar")
	@PostMapping
	public ResponseEntity<ClienteResponseDTO> salvar(@Valid @RequestBody ClienteRequestDTO clienteDTO) {
		Cliente clienteSalvo = clienteServico.salvar(clienteDTO.converterParaEntidade());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ClienteResponseDTO.converterClienteParaClienteResponseDto(clienteSalvo));
	}
	
	@Operation(summary = "Atualizar")
	@PutMapping("/{codigo}")
	public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable Long codigo, @Valid @RequestBody ClienteRequestDTO clienteDto){
		Cliente clienteAtualizado = clienteServico.atualizar(codigo, clienteDto.converterParaEntidade(codigo));
		return ResponseEntity.ok(ClienteResponseDTO.converterClienteParaClienteResponseDto(clienteAtualizado));
	}
	
	@Operation(summary = "Deletar")
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> deletar(@PathVariable Long codigo) {
		clienteServico.deletar(codigo);
		return ResponseEntity.noContent().build();
	}
}
