package com.gvendas.gestaovendas.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gvendas.gestaovendas.dto.venda.VendaRequestDTO;
import com.gvendas.gestaovendas.dto.venda.ClienteVendaResponseDTO;
import jakarta.validation.Valid;
import com.gvendas.gestaovendas.servicos.VendaServico;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/vendas")
@Tag(name = "Vendas", description = "Venda controlador")
public class VendaControlador {
	
	@Autowired
	private VendaServico vendaServico;

	@Operation(summary = "Listar vendas por cliente")
	@GetMapping("/cliente/{codigoCliente}")
	public ResponseEntity<ClienteVendaResponseDTO> listarVendasPorCliente(@PathVariable Long codigoCliente){
		return ResponseEntity.ok(vendaServico.listaVendaPorCliente(codigoCliente));
	}
	
	@Operation(summary = "Listar vendas por código")
	@GetMapping("/{codigoVenda}")
	public ResponseEntity<ClienteVendaResponseDTO> listarVendaPorCodigo(@PathVariable Long codigoVenda){
		return ResponseEntity.ok(vendaServico.listarVendaPorCodigo(codigoVenda));
	}
	
	@Operation(summary = "Registrar venda")
	@PostMapping("/cliente/{codigoCliente}")
	public ResponseEntity<ClienteVendaResponseDTO> salvar(@PathVariable Long codigoCliente, @Valid @RequestBody VendaRequestDTO vendaDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(vendaServico.salvar(codigoCliente, vendaDto));
	}
}
