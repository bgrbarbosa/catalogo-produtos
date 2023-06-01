package br.com.produtos.recebe.repository;


import br.com.produtos.recebe.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

    Optional<Produto> findByCodBarras(String url);
}
