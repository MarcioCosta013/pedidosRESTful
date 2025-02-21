package br.com.marcio.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marcio.pedidos.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    //Repository: Acesso ao banco de dados.
}
