package br.com.ricardoianni.basec.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Data
public class Compra implements Serializable {

	@Id
	private Integer idCompra;
	
	private String estabelecimento;
	
	private BigDecimal valor;
	
	private LocalDateTime dataHoraCompra;
	
	private String numCartao;
	
	@ManyToOne
	@JoinColumn(name = "idDadosBaseC")
	private DadosBaseC pessoa;
	
}
