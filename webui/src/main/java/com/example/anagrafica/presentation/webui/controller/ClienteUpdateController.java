package com.example.anagrafica.presentation.webui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.anagrafica.business.ClienteService;

@Controller
public class ClienteUpdateController {
@Autowired
ClienteService clienteService;

@PostMapping("/clienti/update")
public String update(@RequestParam("cf") String cf,Model model) {
	
	return "pagina2";
}
}
