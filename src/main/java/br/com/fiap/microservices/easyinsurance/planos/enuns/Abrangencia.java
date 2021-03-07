package br.com.fiap.microservices.easyinsurance.planos.enuns;

public enum Abrangencia {
	NACIONAL("Nacional"),
	GRUPO_ESTADOS("Grupo de Estados"),
	ESTADUAL("Estadual"),
	GRUPO_MUNICIPIOS("Grupo de municipios"),
	MUNICIPAL("Municipal");
	
	private String descricao;
	
	Abrangencia(String descricao) {
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

