package com.agencia.reservas.controller;

import com.agencia.reservas.model.entity.AgentesEntity;
import com.agencia.reservas.service.DadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/dados")
public class DadosController {

    @Autowired
    private DadosService dadosService;

    @PostMapping("/upload-xml")
    public ResponseEntity<String> uploadXML(@RequestParam("file") MultipartFile arquivo) {
        try {
            AgentesEntity resp = dadosService.processarArquivoXML(arquivo);
            return ResponseEntity.ok("Arquivo XML processado com sucesso! " + resp);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro no processamento do arquivo XML");
        }
    }

    @GetMapping("/agentes")
    public AgentesEntity listarAgentesPorSigla(@RequestParam(name = "sigla") String sigla) {
        return dadosService.listarAgentesPorSigla(sigla);
    }

}
