package br.com.fiap.microservices.easyinsurance.planos.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.fiap.microservices.easyinsurance.planos.entity.Plano;

/**
 * @author SaraRegina
 * Com essa classe não se faz necessária a implementacao do método Service
 * 
 */

@RepositoryRestResource( path = "plano", collectionResourceRel = "plano")
public interface PlanoRepository extends PagingAndSortingRepository<Plano, Long>{

}
