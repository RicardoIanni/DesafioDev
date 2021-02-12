package br.com.ricardoianni.desafiodev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ricardoianni.desafiodev.domain.DadosBaseA;
import br.com.ricardoianni.desafiodev.domain.DadosBaseB;
import br.com.ricardoianni.desafiodev.domain.DadosBaseC;
import br.com.ricardoianni.desafiodev.service.basea.BaseAServiceClient;
import br.com.ricardoianni.desafiodev.service.baseb.BaseBServiceClient;
import br.com.ricardoianni.desafiodev.service.basec.BaseCServiceClient;

@Controller
@RequestMapping(path = "/consulta")
public class ConsultaDadosController {
	
	private static final String MSG_ERROR = "msg_error";
	
	@Autowired
	private BaseAServiceClient baseAService;
	
	@Autowired
	private BaseBServiceClient baseBService;
	
	@Autowired
	private BaseCServiceClient baseCService;

	@PostMapping(path = "/basea")
	public String consultaBaseA(@RequestParam("cpf") String cPF, 
								Model model) {

		DadosBaseA dadosA = new DadosBaseA();
		
		baseAService.setCPF(cPF);
		
		try {
			dadosA = baseAService.consumeBaseAService();	
		} catch (Exception e) {
			model.addAttribute(MSG_ERROR, e.getMessage());
		}

		model.addAttribute("dadosA", dadosA);
		
		return "dadosA";
	}
	
	@PostMapping(path = "/baseb")
	public String consultaBaseB(@RequestParam("cpf") String cPF, 
								Model model) {

		DadosBaseB dadosB = new DadosBaseB();
		
		baseBService.setCPF(cPF);
		
		try {
			dadosB = baseBService.consumeBaseBService();	
		} catch (Exception e) {
			model.addAttribute(MSG_ERROR, e.getMessage());
		}

		model.addAttribute("dadosB", dadosB);
		
		return "dadosB";
	}
	
	@PostMapping(path = "/basec")
	public String consultaBaseC(@RequestParam("cpf") String cPF, 
								Model model) {

		DadosBaseC dadosC = new DadosBaseC();
		
		baseCService.setCPF(cPF);
		
		try {
			dadosC = baseCService.consumeBaseCService();	
		} catch (Exception e) {
			model.addAttribute(MSG_ERROR, e.getMessage());
		}

		model.addAttribute("dadosC", dadosC);
		
		return "dadosC";
	}
	
}
