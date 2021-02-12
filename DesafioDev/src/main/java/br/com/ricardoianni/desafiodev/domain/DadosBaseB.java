package br.com.ricardoianni.desafiodev.domain;

import java.util.List;

import javax.persistence.OneToMany;

import lombok.Data;

@Data
public class DadosBaseB {

	private Integer idDadosBaseB;
	
	private String cPF;
	
	private String endereco;
	
	private String fonteRenda;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Bens> bens;
	
}
