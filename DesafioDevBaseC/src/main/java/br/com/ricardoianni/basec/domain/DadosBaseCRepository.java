package br.com.ricardoianni.basec.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DadosBaseCRepository extends JpaRepository<DadosBaseC, Integer>{

	public DadosBaseC findByCPF(String cPF);
	
}
