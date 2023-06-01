package br.com.produtos.envio.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
public class ProdutoEventDto {

    private UUID idProduto;
    private String descProduto;
    private String catProduto;
    private double precoProduto;
    private String codBarras;
    private String actionType;
}
