package com.agencia.reservas.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class CompraEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    @OneToMany(mappedBy = "compraEntity", cascade = CascadeType.ALL)
    private List<ValorEntity> valores;

}
