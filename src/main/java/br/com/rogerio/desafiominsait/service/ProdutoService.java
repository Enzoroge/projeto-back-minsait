package br.com.rogerio.desafiominsait.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rogerio.desafiominsait.model.Produto;
import br.com.rogerio.desafiominsait.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto cadastrar(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public List<Produto> buscarTodos(){
		return produtoRepository.findAll();
	}
	
	public Optional<Produto> buscarId(Long id) {
		return produtoRepository.findById(id);
	}
	
	public Produto atualizar(Produto produto, Long id) {
		Produto obj = findById(id);
		produto.setNome(produto.getNome());
		produto.setPreco(produto.getPreco());
		produto.setCodigoBarras(produto.getCodigoBarras());
		return produtoRepository.save(produto);
	}
	
	private Produto findById(Long id) {
		
		return null;
	}

	public void delete(Long id) {
		produtoRepository.deleteById(id);
	}
	

}
