package com.gvendas.gestaovendas.controladores;

import java.util.List;
import java.util.Optional;

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
	public List<Produto> listarTodas(@PathVariable Long codigoCategoria) {
		return produtoServico.listarTodos(codigoCategoria);
	}

	@Operation(summary = "Listar por código")
	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Produto>> buscarPorCodigo(@PathVariable Long codigo,
			@PathVariable Long codigoCategoria) {
		Optional<Produto> produto = produtoServico.buscarPorCodigo(codigo, codigoCategoria);

		return produto.isPresent() ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
	}
	
	@Operation(summary = "Salvar")
	@PostMapping
	public ResponseEntity<Produto> salvarProduto(@PathVariable Long codigoCategoria, @Valid @RequestBody Produto produto){
		Produto produtoSalvo = produtoServico.salvarProduto(codigoCategoria, produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
	}
	
	@Operation(summary = "Atualizar")
	@PutMapping("/{codigoProduto}")
	public ResponseEntity<Produto> atualizarProduto(@PathVariable Long codigoCategoria, @PathVariable Long codigoProduto, @Valid @RequestBody Produto produto){
		Produto produtoAtualizado = produtoServico.atualizarProduto(codigoCategoria, codigoProduto, produto);
		return ResponseEntity.ok(produtoAtualizado);
	}
	@Operation(summary = "Deletar")
	@DeleteMapping("/{codigoProduto}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarProduto(@PathVariable Long codigoCategoria, @PathVariable Long codigoProduto) {
		produtoServico.deletarProduto(codigoCategoria, codigoProduto);
	}
}
