package br.com.ricardoianni.baseb.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Data
public class Bens implements Serializable {

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
