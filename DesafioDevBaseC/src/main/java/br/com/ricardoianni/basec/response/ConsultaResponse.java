package br.com.ricardoianni.basec.response;

import java.util.List;

import br.com.ricardoianni.basec.domain.Compra;
import br.com.ricardoianni.basec.domain.Consulta;
import br.com.ricardoianni.basec.domain.MovimentacaoFinanceira;
import lombok.Data;

@Data
public class ConsultaResponse {

	private Consulta ultConsultaCPF;
	private List<MovimentacaoFinanceira> movFinanceira;
	private Compra ultCompra;
	private String error;
	
	public ConsultaResponse(Consulta ultConsultaCPF, 
							List<MovimentacaoFinanceira> movFinanceira, 
							Compra ultCompra) {
		this.ultConsultaCPF = ultConsultaCPF;
		this.movFinanceira = movFinanceira;
		this.ultCompra = ultCompra;
	}
	
	public ConsultaResponse(String error) {
		this.error = error;
	}
	
	public String getError() {
		return error;
	}

}
