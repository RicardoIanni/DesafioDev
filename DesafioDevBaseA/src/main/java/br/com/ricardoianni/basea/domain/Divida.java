package br.com.ricardoianni.basea.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Data
public class Divida implements Serializable {

	private Integer id;
	
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "idDadosBaseA")
	private DadosBaseA pessoa;
	
}
