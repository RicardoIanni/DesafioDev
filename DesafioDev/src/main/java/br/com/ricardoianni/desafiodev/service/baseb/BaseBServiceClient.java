package br.com.ricardoianni.desafiodev.service.baseb;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import br.com.ricardoianni.desafiodev.domain.DadosBaseB;
import br.com.ricardoianni.desafiodev.service.ServiceClientException;
import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class BaseBServiceClient {

	@Value("${baseB.url}")
	private String endpoint;
	
	@Value("${baseB.token}")
	private String token;
	
	private String cPF;
	
	@SuppressWarnings("unchecked")
	public DadosBaseB consumeBaseBService() throws ServiceClientException {
		
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
		
		if (response != null) {
			return (DadosBaseB) response.get("dados");
		}
		
		return new DadosBaseB();
		
	}
}
