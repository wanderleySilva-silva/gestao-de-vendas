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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gvendas.gestaovendas.dto.produto.ProdutoRequestDTO;
import com.gvendas.gestaovendas.dto.produto.ProdutoResponseDTO;
import com.gvendas.gestaovendas.entidades.Produto;
import com.gvendas.gestaovendas.servicos.ProdutoServico;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Produtos", description = "Produto controlador")
@RestController
@RequestMapping("/categorias/{codigoCategoria}/produtos")
public class ProdutoControlador {

	@Autowired
	private ProdutoServico produtoServico;

	@Operation(summary = "Listar")
	@GetMapping
	public List<ProdutoResponseDTO> listarTodas(@PathVariable Long codigoCategoria) {

		return produtoServico.listarTodos(codigoCategoria).stream()
				.map(produto -> ProdutoResponseDTO.converterProdutoParaProdutoResponseDto(produto))
				.collect(Collectors.toList());
	}

	@Operation(summary = "Listar por código")
	@GetMapping("/{codigo}")
	public ResponseEntity<ProdutoResponseDTO> buscarPorCodigo(@PathVariable Long codigo,
			@PathVariable Long codigoCategoria) {
		Optional<Produto> produto = produtoServico.buscarPorCodigo(codigo, codigoCategoria);

		return produto.isPresent() ? ResponseEntity.ok(ProdutoResponseDTO.converterProdutoParaProdutoResponseDto(produto.get())) : ResponseEntity.notFound().build();
	}

	@Operation(summary = "Salvar")
	@PostMapping
	public ResponseEntity<ProdutoResponseDTO> salvarProduto(@PathVariable Long codigoCategoria,
			@Valid @RequestBody ProdutoRequestDTO produto) {
		Produto produtoSalvo = produtoServico.salvarProduto(codigoCategoria, produto.converterParaEntidade(codigoCategoria));
		return ResponseEntity.status(HttpStatus.CREATED).body(ProdutoResponseDTO.converterProdutoParaProdutoResponseDto(produtoSalvo));
	}

	@Operation(summary = "Atualizar")
	@PutMapping("/{codigoProduto}")
	public ResponseEntity<ProdutoResponseDTO> atualizarProduto(@PathVariable Long codigoCategoria,
			@PathVariable Long codigoProduto, @Valid @RequestBody ProdutoRequestDTO produto) {
		Produto produtoAtualizado = produtoServico.atualizarProduto(codigoCategoria, codigoProduto, produto.converterParaEntidade(codigoCategoria, codigoProduto));
		return ResponseEntity.ok(ProdutoResponseDTO.converterProdutoParaProdutoResponseDto(produtoAtualizado));
	}

	@Operation(summary = "Deletar")
	@DeleteMapping("/{codigoProduto}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarProduto(@PathVariable Long codigoCategoria, @PathVariable Long codigoProduto) {
		produtoServico.deletarProduto(codigoCategoria, codigoProduto);
	}
}
