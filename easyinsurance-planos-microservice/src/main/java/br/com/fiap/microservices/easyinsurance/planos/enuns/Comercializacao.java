package br.com.fiap.microservices.easyinsurance.planos.enuns;

public enum Comercializacao {
	
	LIBERADA("Liberada"),
	SUSPENSA_PELA_ANS("Suspensa pela ANS"),
	SUSPENSA_A_PEDIDO_OPERADORA("Suspensa a pedido da operadora");
	
	private String descricao;
		
	Comercializacao(String descricao){
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
