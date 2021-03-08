package br.com.fiap.microservices.easyinsurance.planos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.fiap.microservices.easyinsurance.planos.enuns.Abrangencia;
import br.com.fiap.microservices.easyinsurance.planos.enuns.Comercializacao;
import br.com.fiap.microservices.easyinsurance.planos.enuns.TipoContratacao;
import lombok.Data;

@Data
@Entity
@Table(name="tb_plano")
public class Plano {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false)
    @JsonProperty("codigoPlanoANS")
    private Long codigoPlanoANS;
    
    @Column(nullable = false)
    @JsonProperty("nomePlano")
    private String nomePlano;
    
    @JsonProperty("tipoContratacao")
    private TipoContratacao tipoContratacao;

    @JsonProperty("comercializacao")
    private Comercializacao comercializacao;
    
    @Column(nullable = false)
    @JsonProperty("cobertura")
    private String cobertura;
    
    @Column(nullable = false)
    @JsonProperty("abrangencia")
    private Abrangencia abrangencia;

}
