package com.agencia.reservas.model.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class ValorEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "compra_id")
    private CompraEntity compraEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "geracao_id")
    private GeracaoEntity geracaoEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "preco_medio_id")
    private PrecoMedioEntity precoMedioEntity;
}
