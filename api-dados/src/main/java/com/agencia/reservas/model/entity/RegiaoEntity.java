package com.agencia.reservas.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class RegiaoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String sigla;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agentes_id")
    private AgenteEntity agenteEntity;

    @OneToOne(cascade = CascadeType.PERSIST)
    private GeracaoEntity geracaoEntity;

    @OneToOne(cascade = CascadeType.PERSIST)
    private CompraEntity compraEntity;

    @OneToOne(cascade = CascadeType.PERSIST)
    private PrecoMedioEntity precoMedioEntity;

}
