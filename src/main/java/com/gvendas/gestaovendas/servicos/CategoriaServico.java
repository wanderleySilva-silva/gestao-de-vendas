package com.gvendas.gestaovendas.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gvendas.gestaovendas.entidades.Categoria;
import com.gvendas.gestaovendas.excecao.RegraNegocioException;
import com.gvendas.gestaovendas.repositorios.CategoriaRepositorio;

@Service
public class CategoriaServico {

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

	public List<Categoria> listarTodasCategorias() {
		return categoriaRepositorio.findAll();
	}

	public Optional<Categoria> buscarCategoriaPorCodigo(Long codigo) {
		return categoriaRepositorio.findById(codigo);
	}

	public Categoria salvarCategoria(Categoria categoria) {
		validarCategoriaDuplicada(categoria);
		return categoriaRepositorio.save(categoria);
	}

	public Categoria atualizarCategoria(Long codigo, Categoria categoria) {
		Categoria categoriaSalva = validarCategoriaExiste(codigo);
		validarCategoriaDuplicada(categoria);
		BeanUtils.copyProperties(categoria, categoriaSalva, "codigo");
		Categoria categoriaAtualizada = categoriaSalva;
		categoriaRepositorio.save(categoriaAtualizada);

		return categoriaAtualizada;
	}

	public void deletarCategoria(Long codigo) {
		categoriaRepositorio.deleteById(codigo);
	}

	private Categoria validarCategoriaExiste(Long codigo) {
		Optional<Categoria> categoria = buscarCategoriaPorCodigo(codigo);

		if (categoria.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return categoria.get();
	}

	private void validarCategoriaDuplicada(Categoria categoria) {
		Categoria categoriaEncontrada = categoriaRepositorio.findByNomeContainingIgnoreCase(categoria.getNome());
		if (categoriaEncontrada != null && categoriaEncontrada.getCodigo() != categoria.getCodigo()) {
			throw new RegraNegocioException(
					String.format("A categoria %s já está cadastrada.", categoria.getNome().toUpperCase()));
		}
	}
}
