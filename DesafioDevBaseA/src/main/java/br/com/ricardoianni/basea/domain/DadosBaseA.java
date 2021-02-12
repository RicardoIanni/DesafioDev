package br.com.ricardoianni.basea.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Data
public class DadosBaseA implements Serializable {

	private Integer idDadosBaseA;
	
	private String nome;
	
	private String cPF;
	
	private String endereco;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Divida> dividas;
}
