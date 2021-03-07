package br.com.fiap.microservices.easyinsurance.planos.enuns;

public enum TipoContratacao {
	INDIVIDUAL_FAMILIAR("Indiviual ou familiar"),
	COLETIVO_EMPRESARIAL("Coletivo Empresarial"),
	COLETIVO_POR_ADESAO("Coletivo por Adesao");
	
	private String descricao;
	
	TipoContratacao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
