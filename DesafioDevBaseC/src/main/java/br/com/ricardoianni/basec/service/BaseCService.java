package br.com.ricardoianni.basec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import br.com.ricardoianni.basec.domain.Compra;
import br.com.ricardoianni.basec.domain.CompraRepository;
import br.com.ricardoianni.basec.domain.Consulta;
import br.com.ricardoianni.basec.domain.ConsultaRepository;
import br.com.ricardoianni.basec.domain.DadosBaseC;
import br.com.ricardoianni.basec.domain.DadosBaseCRepository;
import br.com.ricardoianni.basec.response.ConsultaResponse;

@RestController
public class BaseCService {
	
	private static final String AUTO_TOKEN = "DesafioSerasaBaseA";
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private DadosBaseCRepository dadosBaseCRepository;

	@PostMapping(path = "/consulta", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConsultaResponse> consultaBaseC(
			@RequestHeader("Token") String token,
			@RequestBody String cPF ) {
		
		if (! validaToken(token) ) {
			return ResponseEntity.badRequest().body(new ConsultaResponse("Token Inválido"));
		}
		
		DadosBaseC dados = dadosBaseCRepository.findByCPF(cPF);
		Compra ultCompra = compraRepository.findFirstByPessoaOrderByDataHoraCompraDesc(dados);
		Consulta ultConsultaCPF = consultaRepository.findFirstByPessoaOrderByDataHoraCompraDesc(dados);
	
		return ResponseEntity.ok(new ConsultaResponse( ultConsultaCPF, dados.getMovFinanceira(), ultCompra));
	}
	
	public boolean validaToken(String token) {
		return AUTO_TOKEN.equals(token);
	}
}
