package com.agencia.reservas.model.dto;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Date;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Agente {

    private int codigo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    private List<Regiao> regiao;

}