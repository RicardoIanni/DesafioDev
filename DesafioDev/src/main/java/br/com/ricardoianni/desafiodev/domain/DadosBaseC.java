package br.com.ricardoianni.desafiodev.domain;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
public class DadosBaseC {

	@Id
	private Integer idDadosBaseC;
	
	private String cPF;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Consulta> consulta;
	
	@OneToMany(mappedBy = "pessoa")
	private List<MovimentacaoFinanceira> movFinanceira;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Compra> compras;
	
}
