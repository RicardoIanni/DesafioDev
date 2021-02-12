package br.com.ricardoianni.baseb.service;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import br.com.ricardoianni.baseb.domain.DadosBaseB;
import br.com.ricardoianni.baseb.domain.DadosBaseBRepository;
import br.com.ricardoianni.baseb.response.ConsultaResponse;

@RestController
public class BaseBService {
	
	private static final String AUTO_TOKEN = "DesafioSerasaBaseB";
	
	private DadosBaseBRepository dadosBaseBRepository;

	@PostMapping(path = "/consulta", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConsultaResponse> consultaBaseB(
			@RequestHeader("Token") String token,
			@RequestBody String cPF ) {
		
		if (! validaToken(token) ) {
			return ResponseEntity.badRequest().body(new ConsultaResponse("Token Inválido"));
		}
		
		DadosBaseB dados = dadosBaseBRepository.findByCPF(cPF);
		
		return ResponseEntity.ok(new ConsultaResponse(dados));
	}
	
	public boolean validaToken(String token) {
		return AUTO_TOKEN.equals(token);
	}
}
