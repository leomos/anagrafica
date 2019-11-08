package com.example.anagrafica.presentation.webui.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.data.Cliente;

@Controller
public class MostraListaClienti {

	@Autowired
	ClienteService clService;
	
	@GetMapping("/ListaClienti")
	public String mostraListaClienti(ModelMap model) {
		Collection <Cliente> cl=clService.getAll();
		model.addAttribute("listaCliente", cl);
		return "mostraListaCliente";
	}
}
