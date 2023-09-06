package com.agencia.reservas.model.dto;

import lombok.Data;
import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "agentes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Agentes {

    @XmlAttribute
    private String versao;

    @XmlElement(name = "agente")
    private List<Agente> agente;

}