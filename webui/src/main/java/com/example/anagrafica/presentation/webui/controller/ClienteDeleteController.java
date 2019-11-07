package com.example.anagrafica.presentation.webui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.anagrafica.business.ClienteService;

@Controller
public class ClienteDeleteController {
	@Autowired
	ClienteService clienteService;

	@PostMapping("/clienti/delete")
	public String deleteCliente(@RequestParam("cf") String cf, Model model) {
		System.out.println("Richiesta Cancellazione avvenuta correttamente.");
		model.addAttribute("cancellato", true);
		this.clienteService.deleteLogical(this.clienteService.getByCf(cf).get());
		return "pagina2";
	}
}
