package br.com.rogerio.desafiominsait.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rogerio.desafiominsait.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
