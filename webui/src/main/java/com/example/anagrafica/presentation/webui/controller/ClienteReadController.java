package com.example.anagrafica.presentation.webui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.anagrafica.business.ClienteService;

@Controller
public class ClienteReadController {
	@Autowired
	ClienteService clienteService;

	@GetMapping("/clienti")
	public String getAll(Model model, @RequestParam(value = "cf", defaultValue = "") String cf) {
		if (cf == null || cf.isEmpty()) {
			model.addAttribute("clienti", clienteService.getAll());
//			model.addAttribute("cfVuoto", true);
		} else if (!clienteService.getByCf(cf).isPresent() || !clienteService.getByCf(cf).get().isVisibile()) {
			model.addAttribute("cercato", false);
		} else {
			model.addAttribute("cliente", clienteService.getByCf(cf).get());
		}
		return "pagina2";
	}

	@GetMapping("/clienti/{id}")
	public String getById(Model model, @PathVariable("id") int id) {
		model.addAttribute("cliente", clienteService.get(id).get());
		return "pagina2";
	}
}
