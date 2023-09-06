package com.agencia.reservas.service.impl;

import com.agencia.reservas.mapper.Mapper;
import com.agencia.reservas.model.dto.*;
import com.agencia.reservas.model.entity.*;
import com.agencia.reservas.repository.AgenteRepository;
import com.agencia.reservas.repository.AgentesRepository;
import com.agencia.reservas.service.DadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.util.ArrayList;
import java.util.List;

@Service
public class DadosServiceImpl implements DadosService {

    @Autowired
    private AgentesRepository agentesRepository;

    @Autowired
    private AgenteRepository agenteRepository;

    public DadosServiceImpl(AgentesRepository agentesRepository) {
    }

    @Override
    public AgentesEntity processarArquivoXML(MultipartFile arquivo) {

        AgentesEntity response = null;

        try {
            // Realize o parse do arquivo XML usando JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Agentes.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Agentes agentes = (Agentes) jaxbUnmarshaller.unmarshal(arquivo.getInputStream());

            AgentesEntity agentesEntity = new AgentesEntity();
            AgenteEntity agenteEntity = new AgenteEntity();

            List<AgenteEntity> agenteEntities = new ArrayList<>();

            agentesEntity.setVersao(agentes.getVersao());

           for (Agente agente : agentes.getAgente()){

               agenteEntity.setData(agente.getData());
               agenteEntity.setCodigo(agente.getCodigo());

               List<RegiaoEntity> regiaoEntities = new ArrayList<>();

               for (Regiao regiao : agente.getRegiao()) {

                   RegiaoEntity regiaoEntity = Mapper.mapToEntity(regiao);
                   regiaoEntities.add(regiaoEntity);

               }

               agenteEntity.setRegioes(regiaoEntities);
               agenteEntities.add(agenteEntity);
               agentesEntity.setAgenteEntity(agenteEntities);

               response =  agentesRepository.save(agentesEntity);

           }

        } catch (Exception e) {
            throw new RuntimeException("Erro no processamento do arquivo XML", e);
        }

        return response;
    }

    @Override
    public AgentesEntity listarAgentesPorSigla(String sigla) {
        return agentesRepository.getOne(sigla);
    }
}
