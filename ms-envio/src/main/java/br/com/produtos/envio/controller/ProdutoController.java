package br.com.produtos.envio.controller;


import br.com.produtos.envio.dto.ProdutoDto;
import br.com.produtos.envio.dto.ProdutoEventDto;
import br.com.produtos.envio.entity.Produto;
import br.com.produtos.envio.publisher.ProdutoPublisher;
import br.com.produtos.envio.service.ProdutoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
@Log4j2
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @Autowired
    ProdutoPublisher produtoPublisher;

    @GetMapping
    public ResponseEntity<Page<Produto>> listarProdutos(@PageableDefault(page = 0, size = 10, sort = "descProduto",
            direction = Sort.Direction.ASC) Pageable pageable){
        log.info("Consultando lista de produtos!!");
        Page<Produto> produtoModel = service.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(produtoModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>buscarPorCodigo(@PathVariable(value = "id") UUID id){
        Optional<Produto> produto = service.buscarPorId(id);
        if (!produto.isPresent()) {
            log.info("Registro: " + id + " não foi encontrado!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao encontrado");
        }else {
            log.info("Registro: " + id);
            return ResponseEntity.status(HttpStatus.OK).body(produto.get());
        }
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarProduto(@RequestBody ProdutoDto dto){

        var produto = new Produto();
        BeanUtils.copyProperties(dto, produto);
        service.insertProduto(produto);
        log.info("Registro: " + produto + " criado com sucesso!!");
        return  ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @PutMapping
    public ResponseEntity<Object>atualizarProduto(@RequestBody ProdutoDto produtoDto){
        var produto = new Produto();
        BeanUtils.copyProperties(produtoDto, produto);
        if (!service.buscarPorId(produto.getIdProduto()).isPresent()){
            log.info("Registro não foi encontrado!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!!!");
        }else {
            service.updateProduto(produto);
            log.info("Registro: " + produtoDto.getIdProduto() + " com sucesso!!" );
            return  ResponseEntity.status(HttpStatus.CREATED).body(produto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object>deleteProduto(@PathVariable(value = "id")UUID id){
        Optional<Produto>produto = service.buscarPorId(id);
        if (!produto.isPresent()) {
            log.info("Registro não foi encontrado!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!!!");
        }else {
            UUID aux =id;
            service.deleteProduto(produto.get());
            log.info("Registro: " + id + " com sucesso!!");
            return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso!!!");
        }
    }

}
