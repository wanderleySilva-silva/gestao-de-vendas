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

import com.gvendas.gestaovendas.dto.categoria.CategoriaRequestDTO;
import com.gvendas.gestaovendas.dto.categoria.CategoriaResponseDTO;
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
	public List<CategoriaResponseDTO> listarTodasCategorias() {
		return categoriaServico.listarTodasCategorias().stream()
				.map(categoria -> CategoriaResponseDTO.converterCategoriaParaCategoriaResponseDTO(categoria))
				.collect(Collectors.toList());
	}

	@Operation(summary = "Listar por código")
	@GetMapping("/{codigo}")
	public ResponseEntity<CategoriaResponseDTO> buscarCategoriaPorCodigo(@PathVariable(name = "codigo") Long codigo) {
		Optional<Categoria> categoria = categoriaServico.buscarCategoriaPorCodigo(codigo);

		return categoria.isPresent()
				? ResponseEntity.ok(CategoriaResponseDTO.converterCategoriaParaCategoriaResponseDTO(categoria.get()))
				: ResponseEntity.notFound().build();
	}

	@Operation(summary = "Salvar")
	@PostMapping
	public ResponseEntity<CategoriaResponseDTO> salvarCategoria(@Valid @RequestBody CategoriaRequestDTO categoriaDto) {
		Categoria categoriaSalva = categoriaServico.salvarCategoria(categoriaDto.converterParaEntidade());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CategoriaResponseDTO.converterCategoriaParaCategoriaResponseDTO(categoriaSalva));
	}

	@Operation(summary = "Atualizar")
	@PutMapping("/{codigo}")
	public ResponseEntity<CategoriaResponseDTO> atualizarCategoria(@PathVariable Long codigo,
			@Valid @RequestBody CategoriaRequestDTO categoriaDto) {
		Categoria categoriaAtualizada = categoriaServico.atualizarCategoria(codigo,
				categoriaDto.converterParaEntidade(codigo));

		return ResponseEntity.status(HttpStatus.OK)
				.body(CategoriaResponseDTO.converterCategoriaParaCategoriaResponseDTO(categoriaAtualizada));
	}

	@Operation(summary = "Deletar")
	@DeleteMapping("/{codigo}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletarCategoria(@PathVariable Long codigo) {
		categoriaServico.deletarCategoria(codigo);
	}
}
