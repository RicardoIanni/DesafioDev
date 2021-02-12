package br.com.ricardoianni.basea.response;

import br.com.ricardoianni.basea.domain.DadosBaseA;

public class ConsultaResponse {

	private DadosBaseA dados;
	private String error;
	
	public ConsultaResponse(DadosBaseA dados) {
		this.dados = dados;
	}
	
	public ConsultaResponse(String error) {
		this.error = error;
	}
	
	public DadosBaseA getDados() {
		return dados;
	}
	
	public String getError() {
		return error;
	}

}
