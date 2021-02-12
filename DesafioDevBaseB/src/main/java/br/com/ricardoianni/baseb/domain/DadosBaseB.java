package br.com.ricardoianni.baseb.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Data
public class DadosBaseB implements Serializable {

	private Integer idDadosBaseB;
	
	private String cPF;
	
	private String endereco;
	
	private String fonteRenda;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Bens> bens;
	
}
