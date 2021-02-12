package br.com.ricardoianni.desafiodev.domain;

import java.math.BigDecimal;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
public class Bens {

	enum TipoBem {
		IMOVEL,
		CARRO,
		INVESTIMENTO,
		OUTRO;
	}
	
	private Integer idBens;
	
	private TipoBem tipoBem;
	
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "idDadosBaseB")
	private DadosBaseB pessoa;
	
}
