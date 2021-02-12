package br.com.ricardoianni.basea.service;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import br.com.ricardoianni.basea.domain.DadosBaseA;
import br.com.ricardoianni.basea.domain.DadosBaseARepository;
import br.com.ricardoianni.basea.response.ConsultaResponse;

@RestController
public class BaseAService {
	
	private static final String AUTO_TOKEN = "DesafioSerasaBaseA";
	
	private DadosBaseARepository dadosBaseARepository;

	@PostMapping(path = "/consulta", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConsultaResponse> consultaBaseA(
			@RequestHeader("Token") String token,
			@RequestBody String cPF ) {
		
		if (! validaToken(token) ) {
			return ResponseEntity.badRequest().body(new ConsultaResponse("Token Inválido"));
		}
		
		DadosBaseA dados = dadosBaseARepository.findByCPF(cPF);
		
		return ResponseEntity.ok(new ConsultaResponse(dados));
	}
	
	public boolean validaToken(String token) {
		return AUTO_TOKEN.equals(token);
	}
}
