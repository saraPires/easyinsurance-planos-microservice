package br.com.fiap.microservices.easyinsurance.planos.model;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.fiap.microservices.easyinsurance.planos.entity.Plano;

/**
 * @author SaraRegina
 * Com essa classe n�o se faz necess�ria a implementacao do m�todo Service
 * 
 */

@RepositoryRestResource( path = "plano", collectionResourceRel = "plano")
public interface PlanoRepository extends PagingAndSortingRepository<Plano, Long>{
	
	List<Plano> findByNomePlano(@Param("nomePlano") String nomeDoPlano);
	
	List<Plano> findByCodigoPlanoANS(@Param("codigoPlanoANS") Long codigoPlano);

}
