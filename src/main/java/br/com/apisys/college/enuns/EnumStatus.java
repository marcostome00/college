package br.com.apisys.college.enuns;

public enum EnumStatus {

	MATRICULADO("Matriculado"), TRANCADO("Trancado"), JUBILADO("Jubilado");

	private String descricao;

	private EnumStatus(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	

}
