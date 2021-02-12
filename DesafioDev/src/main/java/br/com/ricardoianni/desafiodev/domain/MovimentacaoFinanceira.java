package br.com.ricardoianni.desafiodev.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
public class MovimentacaoFinanceira {

	@Id
	private Integer idMovFinanceira;
	
	private LocalDate data;
	
	private LocalTime hora;
	
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "idDadosBaseC")
	private DadosBaseC pessoa;

}
