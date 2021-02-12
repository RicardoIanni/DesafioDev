package br.com.ricardoianni.desafiodev.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
public class Compra {

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
