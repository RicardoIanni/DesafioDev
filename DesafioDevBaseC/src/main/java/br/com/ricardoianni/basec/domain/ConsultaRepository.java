package br.com.ricardoianni.basec.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer>{

	public Consulta findFirstByPessoaOrderByDataHoraCompraDesc(DadosBaseC pessoa);

}