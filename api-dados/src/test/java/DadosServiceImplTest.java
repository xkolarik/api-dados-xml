import com.agencia.reservas.model.dto.Agentes;
import com.agencia.reservas.model.entity.AgentesEntity;
import com.agencia.reservas.repository.AgentesRepository;
import com.agencia.reservas.service.impl.DadosServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class DadosServiceImplTest {

    @Mock
    private AgentesRepository agentesRepository;

    private DadosServiceImpl dadosService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        dadosService = new DadosServiceImpl(agentesRepository);
    }

    @Test
    public void testProcessarArquivoXML() throws Exception {
        // Crie um arquivo XML de exemplo (substitua com um arquivo real, se necessário)
        String xmlData = "<agentes><versao>1.0</versao></agentes>";
        MultipartFile arquivo = new MockMultipartFile("arquivo.xml", new ByteArrayInputStream(xmlData.getBytes()));

        // Crie um objeto de entidade fictício para simular o resultado do repository
        AgentesEntity agentesEntity = new AgentesEntity();
        when(agentesRepository.save(any())).thenReturn(agentesEntity);

        // Chame o método processarArquivoXML
        AgentesEntity result = dadosService.processarArquivoXML(arquivo);

        // Verifique se o repository foi chamado com os parâmetros corretos
        verify(agentesRepository, times(1)).save(any());

        // Verifique se o resultado não é nulo
        assertNotNull(result);
    }

    @Test
    public void testListarAgentesPorSigla() {
        // Crie um objeto de entidade fictício para simular o resultado do repository
        AgentesEntity agentesEntity = new AgentesEntity();
        when(agentesRepository.getOne("sigla")).thenReturn(agentesEntity);

        // Chame o método listarAgentesPorSigla
        AgentesEntity result = dadosService.listarAgentesPorSigla("sigla");

        // Verifique se o repository foi chamado com os parâmetros corretos
        verify(agentesRepository, times(1)).getOne("sigla");

        // Verifique se o resultado não é nulo
        assertNotNull(result);
    }
}
