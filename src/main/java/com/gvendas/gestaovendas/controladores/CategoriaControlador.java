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

import com.gvendas.gestaovendas.entidades.Categoria;
import com.gvendas.gestaovendas.servicos.CategoriaServico;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
@Tag(name = "Categorias", description = "Categoria controlador")
public class CategoriaControlador {

	@Autowired
	private CategoriaServico categoriaServico;

	@Operation(summary = "Listar")
	@GetMapping
	public List<Categoria> listarTodasCategorias() {
		return categoriaServico.listarTodasCategorias();
	}

	@Operation(summary = "Listar por código")
	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Categoria>> buscarCategoriaPorCodigo(@PathVariable(name = "codigo") Long codigo) {
		Optional<Categoria> categoria = categoriaServico.buscarCategoriaPorCodigo(codigo);

		return categoria.isPresent() ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
	}
	
	@Operation(summary = "Salvar")
	@PostMapping
	public ResponseEntity<Categoria> salvarCategoria(@Valid @RequestBody Categoria categoria) {
		Categoria categoriaSalva = categoriaServico.salvarCategoria(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}

	@Operation(summary = "Atualizar")
	@PutMapping("/{codigo}")
	public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long codigo,@Valid @RequestBody Categoria categoria) {
		Categoria categoriaAtualizada = categoriaServico.atualizarCategoria(codigo, categoria);

		return ResponseEntity.status(HttpStatus.OK).body(categoriaAtualizada);
	}
	
	@Operation(summary = "Deletar")
	@DeleteMapping("/{codigo}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletarCategoria(@PathVariable Long codigo) {
		categoriaServico.deletarCategoria(codigo);
	}
}
