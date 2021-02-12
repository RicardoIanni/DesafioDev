package br.com.ricardoianni.basec.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Integer>{

	public Compra findFirstByPessoaOrderByDataHoraCompraDesc(DadosBaseC pessoa);
}
