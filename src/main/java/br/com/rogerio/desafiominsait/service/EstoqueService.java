package br.com.rogerio.desafiominsait.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rogerio.desafiominsait.model.Estoque;
import br.com.rogerio.desafiominsait.repository.EstoqueRepository;

@Service
public class EstoqueService {
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	
	public Estoque cadastrar(Estoque estoque) {
		return estoqueRepository.save(estoque);
	}
	
	public List<Estoque> buscarTodos(){
		return estoqueRepository.findAll();
	}
	
	public Optional<Estoque> buscarId(Long id) {
		return estoqueRepository.findById(id);
	}
	
	public Estoque atualizar(Estoque estoque, Long id) {
		Estoque obj = findById(id);
		obj.setProduto(obj.getProduto());
		obj.setQuantidade(obj.getQuantidade());
		return estoqueRepository.save(obj);
	}

	private Estoque findById(Long id) {
		
		return null;
	}
	
	public void delete (Long id) {
		estoqueRepository.deleteById(id);
		
	}

}
