package com.example.anagrafica.presentation.webui.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.business.IndirizzoService;
import com.example.anagrafica.data.Cliente;
import com.example.anagrafica.data.Indirizzo;
import com.example.anagrafica.data.IndirizzoCliente;

@Controller
public class MostraIndirizzoController {
@Autowired
IndirizzoService indService;

@Autowired
ClienteService clienteService;

	@GetMapping("modificaCliente/indirizzi")
	public String mostraIndirizzo(@RequestParam("id") int idCliente, ModelMap model) {
		Optional<Cliente> cl=clienteService.get(idCliente);
		Set<IndirizzoCliente> indirizziClienti=cl.get().getIndirizziClienti();
		Collection<Indirizzo> indirizzi=new ArrayList<Indirizzo>();
		for (IndirizzoCliente ic:indirizziClienti) {
			indirizzi.add(ic.getIndirizzo());	
		}
		model.addAttribute("indirizziCliente", indirizzi);
		
		return "mostraIndirizziCliente";
	}
}
