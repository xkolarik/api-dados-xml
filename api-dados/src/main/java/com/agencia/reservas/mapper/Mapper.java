package com.agencia.reservas.mapper;

import com.agencia.reservas.model.dto.Agente;
import com.agencia.reservas.model.dto.Agentes;
import com.agencia.reservas.model.dto.Compra;
import com.agencia.reservas.model.dto.Geracao;
import com.agencia.reservas.model.dto.PrecoMedio;
import com.agencia.reservas.model.dto.Regiao;
import com.agencia.reservas.model.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    public static AgenteEntity mapToEntity(Agente agente) {
        AgenteEntity agenteEntity = new AgenteEntity();
        agenteEntity.setCodigo(agente.getCodigo());
        System.out.println("Codigo de Agente: " + agente.getCodigo());
        agenteEntity.setData(agente.getData());

        return agenteEntity;
    }

    public static AgentesEntity mapToEntity(Agentes agentes) {
        AgentesEntity agentesEntity = new AgentesEntity();
        agentesEntity.setVersao(agentes.getVersao());
        // Certifique-se de configurar corretamente o mapeamento entre Agentes e AgenteEntity

        return agentesEntity;
    }

    public static CompraEntity mapToEntity(Compra compra) {
        CompraEntity compraEntity = new CompraEntity();


        ValorEntity valorEntity = new ValorEntity();
        List<ValorEntity> valorEntities = new ArrayList<>();

        for (Double valor : compra.getValor()) {
            valorEntity.setValor(valor);
            compraEntity.setValor(valor);
            valorEntities.add(valorEntity);

        }

        compraEntity.setValores(valorEntities);
        return compraEntity;

    }

    public static GeracaoEntity mapToEntity(Geracao geracao) {
        GeracaoEntity geracaoEntity = new GeracaoEntity();
        ValorEntity valorEntity = new ValorEntity();
        List<ValorEntity> valorEntities = new ArrayList<>();

        for (Double valor : geracao.getValor()) {
            valorEntity.setValor(valor);
            valorEntities.add(valorEntity);
        }

        geracaoEntity.setValores(valorEntities);
        return geracaoEntity;

    }


    public static PrecoMedioEntity mapToEntity(PrecoMedio precoMedio) {
        PrecoMedioEntity precoMedioEntity = new PrecoMedioEntity();

        ValorEntity valorEntity = new ValorEntity();
        List<ValorEntity> valorEntities = new ArrayList<>();

        for (Double valor : precoMedio.getValor()) {
            valorEntity.setValor(valor);
            valorEntities.add(valorEntity);

        }

        precoMedioEntity.setValores(valorEntities);
        return precoMedioEntity;

    }


    public static RegiaoEntity mapToEntity(Regiao regiao) {
        RegiaoEntity regiaoEntity = new RegiaoEntity();
        regiaoEntity.setSigla(regiao.getSigla());

        GeracaoEntity geracaoEntity = mapToEntity(regiao.getGeracao());
        regiaoEntity.setGeracaoEntity(geracaoEntity);

        CompraEntity compraEntity = mapToEntity(regiao.getCompra());
        regiaoEntity.setCompraEntity(compraEntity);

        PrecoMedioEntity precoMedioEntity = mapToEntity(regiao.getPrecoMedio());
        regiaoEntity.setPrecoMedioEntity(precoMedioEntity);

        return regiaoEntity;
    }

}
