package com.agencia.reservas.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class AgenteEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private int codigo;

    private Date data;

    @ManyToOne(fetch = FetchType.EAGER) // Muitos Agentes pertencem a um Agentes (inverso do relacionamento)
    @JoinColumn(name = "agentes_id") // Nome da coluna de chave estrangeira na tabela Agente
    private AgentesEntity agentesEntity;

    @OneToMany(mappedBy = "agenteEntity", cascade = CascadeType.ALL)
    private List<RegiaoEntity> regioes;

}
