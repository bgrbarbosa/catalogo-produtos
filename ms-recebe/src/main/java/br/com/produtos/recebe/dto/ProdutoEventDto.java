package br.com.produtos.recebe.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ProdutoEventDto {

    private UUID idProduto;
    private String descProduto;
    private String catProduto;
    private double precoProduto;
    private String actionType;
    private String codBarras;
}
