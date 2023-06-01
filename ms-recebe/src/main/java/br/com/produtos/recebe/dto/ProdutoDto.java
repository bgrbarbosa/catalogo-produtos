package br.com.produtos.recebe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto implements Serializable {
    private static final long serialVersionUID = 1L;


    private UUID idProduto;

    @NotBlank
    @Size(max = 60)
    private String descProduto;

    @NotBlank
    @Size(max = 60)
    private String catProduto;

    @NotBlank
    @Size(max = 60)
    private double precoProduto;

    @NotBlank
    @Size(min = 13, max = 13)
    private String codBarras;
}
