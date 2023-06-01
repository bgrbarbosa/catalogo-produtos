package br.com.produtos.envio.service;



import br.com.produtos.envio.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoService {

    Produto insert(Produto produto);

	List<Produto>buscarProduto();

    Page<Produto>findAll(Pageable pageable);

    Produto update(Produto produto);

    Optional<Produto>buscarPorId(UUID id);

    void delete(UUID id);

    Produto insertProduto(Produto produto);
    void deleteProduto(Produto produto);
    Produto updateProduto(Produto produto);

}
