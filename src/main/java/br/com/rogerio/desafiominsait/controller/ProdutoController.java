package br.com.rogerio.desafiominsait.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rogerio.desafiominsait.model.Produto;
import br.com.rogerio.desafiominsait.service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto){
		produtoService.cadastrar(produto);
		return ResponseEntity.ok().body(produto);
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscarTodos(){
		List<Produto> list = produtoService.buscarTodos();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Produto>> buscarId(@PathVariable Long id){
		Optional<Produto> produto = produtoService.buscarId(id);
		return ResponseEntity.ok().body(produto);
		
	}
	
    @PutMapping(value ="/{id}")
	public ResponseEntity<Produto> atualizar(@RequestBody Produto produto,@PathVariable Long id){
		Produto obj = produtoService.atualizar(produto, id);
		return ResponseEntity.ok().body(obj);
	}
    
    @DeleteMapping(value= "/{id}")
    	public ResponseEntity<Void> delete(@PathVariable Long id){
    	produtoService.delete(id);
    	return ResponseEntity.noContent().build();
    	
    }
	
	

}
