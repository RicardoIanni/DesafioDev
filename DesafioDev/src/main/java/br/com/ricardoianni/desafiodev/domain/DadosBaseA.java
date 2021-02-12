package br.com.ricardoianni.desafiodev.domain;

import java.util.List;

import javax.persistence.OneToMany;

import lombok.Data;

@Data
public class DadosBaseA {

	private Integer idDadosBaseA;
	
	private String nome;
	
	private String cPF;
	
	private String endereco;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Divida> dividas;
}
