package com.agencia.reservas.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
public class AgentesEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String versao;

    @OneToMany(mappedBy = "agentesEntity", cascade = CascadeType.ALL)
    private List<AgenteEntity> agenteEntity;
}