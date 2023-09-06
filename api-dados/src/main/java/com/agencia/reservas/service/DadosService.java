package com.agencia.reservas.service;

import com.agencia.reservas.model.entity.AgentesEntity;
import org.springframework.web.multipart.MultipartFile;

public interface DadosService {
    AgentesEntity processarArquivoXML(MultipartFile arquivo);
    AgentesEntity listarAgentesPorSigla(String sigla);
}
