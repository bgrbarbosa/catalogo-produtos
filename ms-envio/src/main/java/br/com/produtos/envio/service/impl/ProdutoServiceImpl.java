package br.com.produtos.envio.service.impl;



import br.com.produtos.envio.dto.ProdutoDto;
import br.com.produtos.envio.dto.ProdutoEventDto;
import br.com.produtos.envio.entity.Produto;
import br.com.produtos.envio.publisher.ProdutoPublisher;
import br.com.produtos.envio.publisher.enums.ActionType;
import br.com.produtos.envio.repository.ProdutoRepository;
import br.com.produtos.envio.service.ProdutoService;
import org.springframework.beans.BeanUtils;
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

    @Autowired
    ProdutoPublisher produtoPublisher;

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
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Transactional
    @Override
    public Produto insertProduto(Produto produto){
        produto = insert(produto);
        var dto = new ProdutoEventDto();
        BeanUtils.copyProperties(produto, dto);
        produtoPublisher.publisheProdutoEvent(dto, ActionType.CREATE);
        return produto;
    }

    @Transactional
    @Override
    public Produto updateProduto(Produto produto) {
       produto = update(produto);
        var dto = new ProdutoEventDto();
        BeanUtils.copyProperties(produto, dto);
        produtoPublisher.publisheProdutoEvent(dto, ActionType.UPDATE);
        return produto;
    }

    @Override
    public void deleteProduto(Produto produto) {
        delete(produto.getIdProduto());
        var dto = new ProdutoEventDto();
        BeanUtils.copyProperties(produto,dto);
        produtoPublisher.publisheProdutoEvent(dto, ActionType.DELETE);
    }

    @Override
    public List<Produto> buscarProduto() {
        return null;
    }




}
