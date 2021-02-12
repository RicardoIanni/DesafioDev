package br.com.ricardoianni.basea.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DadosBaseARepository extends JpaRepository<DadosBaseA, Integer>{

	public DadosBaseA findByCPF(String cPF);
	
}
