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

	/**
	 * @return the codigoPlanoANS
	 */
	public Long getCodigoPlanoANS() {
		return codigoPlanoANS;
	}

	/**
	 * @param codigoPlanoANS the codigoPlanoANS to set
	 */
	public void setCodigoPlanoANS(Long codigoPlanoANS) {
		this.codigoPlanoANS = codigoPlanoANS;
	}

	/**
	 * @return the nomePlano
	 */
	public String getNomePlano() {
		return nomePlano;
	}

	/**
	 * @param nomePlano the nomePlano to set
	 */
	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}

	/**
	 * @return the tipoContratacao
	 */
	public TipoContratacao getTipoContratacao() {
		return tipoContratacao;
	}

	/**
	 * @param tipoContratacao the tipoContratacao to set
	 */
	public void setTipoContratacao(TipoContratacao tipoContratacao) {
		this.tipoContratacao = tipoContratacao;
	}

	/**
	 * @return the comercializacao
	 */
	public Comercializacao getComercializacao() {
		return comercializacao;
	}

	/**
	 * @param comercializacao the comercializacao to set
	 */
	public void setComercializacao(Comercializacao comercializacao) {
		this.comercializacao = comercializacao;
	}

	/**
	 * @return the cobertura
	 */
	public String getCobertura() {
		return cobertura;
	}

	/**
	 * @param cobertura the cobertura to set
	 */
	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}

	/**
	 * @return the abrangencia
	 */
	public Abrangencia getAbrangencia() {
		return abrangencia;
	}

	/**
	 * @param abrangencia the abrangencia to set
	 */
	public void setAbrangencia(Abrangencia abrangencia) {
		this.abrangencia = abrangencia;
	}


    
    

    

   
}
