package com.example.anagrafica.presentation.webui.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.business.IndirizzoService;
import com.example.anagrafica.data.Cliente;
import com.example.anagrafica.data.Indirizzo;
import com.example.anagrafica.data.IndirizzoCliente;

@Controller
public class ClienteCreateController {
	@Autowired
	ClienteService clienteService;
	@Autowired
	IndirizzoService indirizzoService;

	@PostMapping("/clienti")
	public String create(@ModelAttribute("cliente") Cliente cliente,
			@ModelAttribute("indirizzi") Map<String, Indirizzo> indirizzoCliente) {
		this.indirizzoService.create(indirizzoCliente.get("domicilio"));
		this.indirizzoService.create(indirizzoCliente.get("residenza"));
		this.clienteService.create(cliente, indirizzoCliente);
		return "index";
	}
}
