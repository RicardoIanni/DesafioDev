package br.com.ricardoianni.baseb.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DadosBaseBRepository extends JpaRepository<DadosBaseB, Integer>{

	public DadosBaseB findByCPF(String cPF);
	
}
