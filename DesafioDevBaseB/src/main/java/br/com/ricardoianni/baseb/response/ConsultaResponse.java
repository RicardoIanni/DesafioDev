package br.com.ricardoianni.baseb.response;

import br.com.ricardoianni.baseb.domain.DadosBaseB;

public class ConsultaResponse {

	private DadosBaseB dados;
	private String error;
	
	public ConsultaResponse(DadosBaseB dados) {
		this.dados = dados;
	}
	
	public ConsultaResponse(String error) {
		this.error = error;
	}
	
	public DadosBaseB getDados() {
		return dados;
	}
	
	public String getError() {
		return error;
	}

}
