package br.com.produtos.recebe.service;


import br.com.produtos.recebe.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoService {

    Produto insert(Produto produto);

    Page<Produto>findAll(Pageable pageable);

    Produto update(Produto produto);

    Optional<Produto>buscarPorId(UUID id);

    Optional<Produto>buscarPorCodBarras(String cod);

    void delete(UUID id);

    Produto insertProduto(Produto produto);

    Produto updateProduto(Produto produto);

    void deleteProduto(UUID id);
}
