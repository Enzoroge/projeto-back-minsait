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

import br.com.rogerio.desafiominsait.model.Estoque;
import br.com.rogerio.desafiominsait.service.EstoqueService;

@RestController
@RequestMapping(value = "/estoque")
public class EstoqueController {
	
	@Autowired
	private EstoqueService estoqueService;
	
	@PostMapping
	public ResponseEntity<Estoque> cadastrar(@RequestBody Estoque estoque){
		estoqueService.cadastrar(estoque);
		return ResponseEntity.ok().body(estoque);
	}
	
	@GetMapping
	public ResponseEntity<List<Estoque>> buscarTodos(){
		List<Estoque> list = estoqueService.buscarTodos();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Estoque>> buscarId(@PathVariable Long id){
		Optional<Estoque> estoque = estoqueService.buscarId(id);
		return ResponseEntity.ok().body(estoque);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Estoque> atualizar(@RequestBody Estoque estoque, @PathVariable Long id){
		Estoque obj = estoqueService.atualizar(estoque, id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		estoqueService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
