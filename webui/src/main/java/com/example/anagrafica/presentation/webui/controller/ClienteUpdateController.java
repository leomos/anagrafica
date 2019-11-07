package com.example.anagrafica.presentation.webui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.data.Cliente;
@RequestMapping("/MergeRobiSamu")
@Controller
public class ClienteUpdateController {
	@Autowired
	ClienteService clienteService;

	@PostMapping("/clienti/update")
	public String update(@RequestParam("cf") String cf, Model model, @ModelAttribute Cliente cliente) {
		try {
			Boolean bool = this.clienteService.update(cliente);
			model.addAttribute("aggiornato", bool);
		} catch (Exception e) {
			model.addAttribute("aggiornato", false);
		}

		return "pagina2";
	}
}