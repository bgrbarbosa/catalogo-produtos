package br.com.produtos.recebe.service.impl;


import br.com.produtos.recebe.entity.Produto;
import br.com.produtos.recebe.repository.ProdutoRepository;
import br.com.produtos.recebe.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository repository;

    @Override
    public Produto insert(Produto produto) {
        return repository.save(produto);
    }

    @Override
    public Page<Produto> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Produto update(Produto produto) {
        return repository.save(produto);
    }

    @Override
    public Optional<Produto> buscarPorId(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Produto> buscarPorCodBarras(String cod) {
        return repository.findByCodBarras(cod);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Transactional
    @Override
    public Produto insertProduto(Produto produto) {
        produto = insert(produto);
        return produto;
    }

    @Transactional
    @Override
    public Produto updateProduto(Produto produto) {
        return update(produto);
    }

    @Transactional
    @Override
    public void deleteProduto(UUID id) {
        repository.deleteById(id);
    }
}
