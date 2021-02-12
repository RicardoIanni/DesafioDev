package br.com.ricardoianni.desafiodev.domain;

import java.math.BigDecimal;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
public class Divida {

	private Integer id;
	
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "idDadosBaseA")
	private DadosBaseA pessoa;
	
}
