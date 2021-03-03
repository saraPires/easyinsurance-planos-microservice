package br.com.fiap.microservices.easyinsurance.planos.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.fiap.microservices.easyinsurance.planos.enuns.Comercializacao;
import br.com.fiap.microservices.easyinsurance.planos.enuns.TipoContratacao;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_plano")
public class Plano {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @JsonProperty("codigoPlanoANS")
    private Long codigoPlanoANS;
    
    @JsonProperty("nomePlano")
    private String nomePlano;
    
    @JsonProperty("tipoContratacao")
    private TipoContratacao tipoContratacao;

    @JsonProperty("comercializacao")
    private Comercializacao comercializacao;

    @JsonProperty("cobertura")
    private String cobertura;

    @JsonProperty("abrangencia")
    private String abrangencia;

    
}
