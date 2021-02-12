package br.com.ricardoianni.desafiodev.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
public class Consulta {

	@Id
	private Integer idConsulta;
	
	private LocalDate data;
	
	private LocalTime hora;
	
	@ManyToOne
	@JoinColumn(name = "idDadosBaseC")
	private DadosBaseC pessoa;
	
	
}
