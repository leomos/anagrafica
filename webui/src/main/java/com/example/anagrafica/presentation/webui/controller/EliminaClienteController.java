package com.example.anagrafica.presentation.webui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.data.Cliente;

@Controller
public class EliminaClienteController {

	@Autowired
	ClienteService clService;
	
	@PostMapping("/EliminaCliente")
	public String elCliente() {
		return "EliminaCliente";
	}
	
	@PostMapping("/deleteCliente")
	public String eliminaCliente(@RequestParam ("cf") String cf,ModelMap model) {
		if (cf.equals(null)) {
			model.addAttribute("CfDeleteNull", true);
			return "erroreUpdateCliente";
		}
		try {
		Cliente c=clService.getByCf(cf).get();
		clService.deleteLogical(c);
		return "mostraRisultatoDelete";
		}
		catch(Exception e) {
			model.addAttribute("CfDeleteNull", true);
			return "erroreUpdateCliente";
		}
		
	}
}
