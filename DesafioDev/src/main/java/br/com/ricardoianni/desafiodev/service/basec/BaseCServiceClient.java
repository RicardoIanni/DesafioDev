package br.com.ricardoianni.desafiodev.service.basec;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import br.com.ricardoianni.desafiodev.domain.Compra;
import br.com.ricardoianni.desafiodev.domain.Consulta;
import br.com.ricardoianni.desafiodev.domain.DadosBaseC;
import br.com.ricardoianni.desafiodev.domain.MovimentacaoFinanceira;
import br.com.ricardoianni.desafiodev.service.ServiceClientException;
import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class BaseCServiceClient {

	@Value("${baseC.url}")
	private String endpoint;
	
	@Value("${baseC.url}")
	private String token;
	
	private String cPF;
	
	@SuppressWarnings("unchecked")
	public DadosBaseC consumeBaseCService() throws ServiceClientException {
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Token", token);
		
		HttpEntity<String> requestEntity = new HttpEntity<>(cPF, headers);
		
		RestTemplate restTemplate = new RestTemplate();
		
		Map<String, Object> response;
		
		try {
			response = restTemplate.postForObject(endpoint, requestEntity, Map.class);
		} catch (Exception e) {
			throw new ServiceClientException(e.getMessage());
		}
		
		DadosBaseC dados = new DadosBaseC();
		
		if (response == null) {
			return dados;
		}

		Consulta ultConsultaCPF = (Consulta) response.get("ultConsultaCPF");
		List<MovimentacaoFinanceira> movFinanceira = (List<MovimentacaoFinanceira>) response.get("movFinanceira");
		Compra ultCompra = (Compra) response.get("ultCompra");
		
		dados.setCPF(cPF);
		dados.setConsulta(List.of(ultConsultaCPF));
		dados.setMovFinanceira(movFinanceira);
		dados.setCompras(List.of(ultCompra));
		
		return dados;
	}
}
