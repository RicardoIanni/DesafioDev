package br.com.ricardoianni.basec.domain;

import java.io.Serializable;
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
public class Consulta implements Serializable {

	@Id
	private Integer idConsulta;
	
	private LocalDate data;
	
	private LocalTime hora;
	
	@ManyToOne
	@JoinColumn(name = "idDadosBaseC")
	private DadosBaseC pessoa;
	
	
}
