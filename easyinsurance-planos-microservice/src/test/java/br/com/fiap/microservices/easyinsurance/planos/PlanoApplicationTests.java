package br.com.fiap.microservices.easyinsurance.planos;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;



import br.com.fiap.microservices.easyinsurance.planos.entity.Plano;
import br.com.fiap.microservices.easyinsurance.planos.enuns.Abrangencia;
import br.com.fiap.microservices.easyinsurance.planos.enuns.Comercializacao;
import br.com.fiap.microservices.easyinsurance.planos.enuns.TipoContratacao;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PlanoApplicationTests {

	 	@Autowired
	    private TestRestTemplate restTemplate;
	     
	    @LocalServerPort
	    int randomServerPort;
	 
	    @Test
	    public void testeCriandoPlano() throws URISyntaxException 
	    {
	        final String baseUrl = "http://localhost:"+randomServerPort+"/easyinsurance/plano";
	        URI uri = new URI(baseUrl);
	    	Plano plano = new Plano();
	       	plano.setCodigoPlanoANS(7393L);
	    	plano.setNomePlano("A R CONTABILIDADE LTDA");
	    	plano.setTipoContratacao(TipoContratacao.COLETIVO_EMPRESARIAL);
	    	plano.setComercializacao(Comercializacao.LIBERADA);
	    	plano.setCobertura("Ambulatorial + Hospitalar com obstetrícia");
	    	plano.setAbrangencia(Abrangencia.NACIONAL);
	         
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("X-COM-PERSIST", "true");      
	 
	        HttpEntity<Plano> request = new HttpEntity<>(plano, headers);
	         
	        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
	         
	        assertEquals(201, result.getStatusCodeValue());
	    }
	     
	    @Test
	    public void testeCriandoPlanoMissingHeader() throws URISyntaxException 
	    {
	        final String baseUrl = "http://localhost:"+randomServerPort+"/easyinsurance/plano";
	        URI uri = new URI(baseUrl);
	    	Plano plano = new Plano();
	       	plano.setCodigoPlanoANS(null);
	    	plano.setNomePlano(null);
	    	plano.setTipoContratacao(null);
	    	plano.setComercializacao(Comercializacao.LIBERADA);
	    	plano.setCobertura("Ambulatorial + Hospitalar com obstetrícia");
	    	plano.setAbrangencia(Abrangencia.GRUPO_ESTADOS);
	         
	        HttpHeaders headers = new HttpHeaders();
	 
	        HttpEntity<Plano> request = new HttpEntity<>(plano, headers);
	         
	        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
	         
	        
	        assertEquals(401, result.getStatusCodeValue());
	        assertEquals(true, result.getBody().contains("Missing request header"));
	    }

}
