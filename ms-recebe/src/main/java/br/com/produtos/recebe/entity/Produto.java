package br.com.produtos.recebe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_CATALOGO_PRODUTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private UUID idProduto;

    @Column(nullable = false)
    private String descProduto;

    @Column(nullable = false)
    private String catProduto;

    @Column(nullable = false)
    private double precoProduto;

    @Column(nullable = false)
    private String codBarras;
}
