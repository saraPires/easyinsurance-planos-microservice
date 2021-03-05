/**
 * 
 */
package br.com.fiap.microservices.easyinsurance.planos;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.junit.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;


import br.com.fiap.microservices.easyinsurance.planos.entity.Plano;
import br.com.fiap.microservices.easyinsurance.planos.enuns.Abrangencia;
import br.com.fiap.microservices.easyinsurance.planos.enuns.Comercializacao;
import br.com.fiap.microservices.easyinsurance.planos.enuns.TipoContratacao;
import br.com.fiap.microservices.easyinsurance.planos.model.PlanoRepository;

import java.io.IOException;
import java.util.List;

/**
 * @author SaraRegina
 * Classes de testes unitários para verificar os serviços do plano.
 */
@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DataJpaTest
@ContextConfiguration(classes = PlanoApplication.class)
@AutoConfigureWebMvc
public class PlanoTest {
	
	private final String BASE_URL = "http://localhost:8082/easyinsurance/plano";
	
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private PlanoRepository planoRepository;
	
	
    private RestTemplate restTemplate;
	
    @Before
    public void setUp() {
    	
    	planoRepository.deleteAll();
    	
    	Plano plano = new Plano();
       	plano.setCodigoPlanoANS(7393L);
    	plano.setNomePlano("A R CONTABILIDADE LTDA");
    	plano.setTipoContratacao(TipoContratacao.COLETIVO_EMPRESARIAL);
    	plano.setComercializacao(Comercializacao.LIBERADA);
    	plano.setCobertura("Ambulatorial + Hospitalar com obstetrícia");
    	plano.setAbrangencia(Abrangencia.NACIONAL);
      	planoRepository.save(plano);
    	restTemplate = new RestTemplate();
        
    }
    
    @Test
    public void criando_novo_plano_retorno() throws Exception{
    	restTemplate.delete(BASE_URL);
    	Plano plano1 = new Plano();
       	plano1.setCodigoPlanoANS(485662207L);
    	plano1.setNomePlano("Absoluto ADM Nacional ADS - A (EA)");
    	plano1.setTipoContratacao(TipoContratacao.COLETIVO_POR_ADESAO);
    	plano1.setComercializacao(Comercializacao.LIBERADA);
    	plano1.setCobertura("Hospitalar com obstetrícia");
    	plano1.setAbrangencia(Abrangencia.NACIONAL);
    	Plano response = restTemplate.postForObject(BASE_URL, plano1, Plano.class);
    	assertEquals(485662207l, response.getCodigoPlanoANS().longValue());
    }
    
    
    
    @Test
    public void buscar_plano() throws Exception {
    	String response = restTemplate.getForObject(BASE_URL + "/findAll", String.class);
    	List<Plano> planos = mapper.readValue(response, mapper.getTypeFactory().constructCollectionLikeType(List.class, Plano.class));
    	Plano plano = restTemplate.getForObject(BASE_URL+ "/"+ planos.get(1).getCodigoPlanoANS(), Plano.class);
    	assertNotNull(plano);
    	assertEquals(7393l, plano.getCodigoPlanoANS().longValue());
    	assertEquals(Abrangencia.NACIONAL, plano.getAbrangencia());
   	
    }
    
    
    @Test
    public void atualizando_plano() throws IOException{
    	String response = restTemplate.getForObject(BASE_URL + "/findAll", String.class);
        List<Plano> planos = mapper.readValue(response, mapper.getTypeFactory().constructCollectionType(List.class, Plano.class));
        
        Plano plano2 = restTemplate.getForObject(BASE_URL + "/" + planos.get(1).getCodigoPlanoANS(), Plano.class);
    	plano2.setCodigoPlanoANS(485662207L);
    	plano2.setTipoContratacao(TipoContratacao.COLETIVO_POR_ADESAO);
    	plano2.setComercializacao(Comercializacao.SUSPENSA_PELA_ANS);
    	plano2.setCobertura("Hospitalar");
        restTemplate.put(BASE_URL, plano2);
        
        Plano plano3 = restTemplate.getForObject(BASE_URL + "/" + planos.get(1).getCodigoPlanoANS(), Plano.class);
        assertNotNull(plano3);
    	assertEquals(485662207l, plano3.getCodigoPlanoANS().longValue());
    	assertEquals(Comercializacao.LIBERADA, plano3.getComercializacao());
        
    }
    
    
    
    
    
    
    

}
