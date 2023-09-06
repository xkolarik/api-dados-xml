package com.agencia.reservas.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class PrecoMedioEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "precoMedioEntity", cascade = CascadeType.ALL)
    private List<ValorEntity> valores = new ArrayList<>();

}
