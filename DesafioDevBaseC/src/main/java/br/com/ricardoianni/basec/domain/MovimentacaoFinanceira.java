package br.com.ricardoianni.basec.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Data
public class MovimentacaoFinanceira implements Serializable {

	@Id
	private Integer idMovFinanceira;
	
	private LocalDate data;
	
	private LocalTime hora;
	
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "idDadosBaseC")
	private DadosBaseC pessoa;

}
