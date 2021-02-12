package br.com.ricardoianni.basec.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Data
public class DadosBaseC implements Serializable {

	@Id
	private Integer idDadosBaseC;
	
	private String cPF;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Consulta> consulta;
	
	@OneToMany(mappedBy = "pessoa")
	private List<MovimentacaoFinanceira> movFinanceira;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Compra> compras;

	public String getcPF() {
		return cPF;
	}

	public List<Consulta> getConsulta() {
		return consulta;
	}

	public List<MovimentacaoFinanceira> getMovFinanceira() {
		return movFinanceira;
	}

	public List<Compra> getCompras() {
		return compras;
	}
	
}
