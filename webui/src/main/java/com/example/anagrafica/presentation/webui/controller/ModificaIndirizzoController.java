package com.example.anagrafica.presentation.webui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.anagrafica.business.IndirizzoService;


import data.NewIndirizzo;

@Controller
public class ModificaIndirizzoController {
	@Autowired
	IndirizzoService indService;
@PostMapping ("modificaCliente/modificaIndirizzi")
public String modificaCliente (@ModelAttribute NewIndirizzo indirizzo) {
	indService.update(indirizzo.getIndirizzo());
	return "mostraRisultatoUpdateIndirizzo";
}
}
