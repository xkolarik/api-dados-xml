package com.agencia.reservas.model.dto;

import lombok.Data;
import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Regiao {

    @XmlAttribute
    private String sigla;

    private Geracao geracao;

    private Compra compra;

    private PrecoMedio precoMedio;

}
