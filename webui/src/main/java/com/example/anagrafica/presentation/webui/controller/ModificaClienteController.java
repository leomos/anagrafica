package com.example.anagrafica.presentation.webui.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.data.Cliente;
import com.example.anagrafica.data.ClienteRepository;
import com.example.anagrafica.utils.Utils;

import data.NewClienteDaModificare;

@Controller
public class ModificaClienteController {
	@Autowired
	ClienteService clienteSer;
	
	
@GetMapping("/modificaCliente")
public String modifica() {
	return "modificaCliente";
}

@GetMapping("/modifyCliente")
public String modificaCliente (@RequestParam("cf") String cf,ModelMap model) {
	
	Optional<Cliente> clienti=clienteSer.getByCf(cf);
	model.addAttribute("presente", clienti.isPresent());
	
	if(clienti.isPresent()==true) {
		model.addAttribute("cliente", clienti.get());
	return "mostraClienteDaModificare";}
	else {
		model.addAttribute("CfUpdateNull",true);
		return "erroreUpdateCliente";}
}

@PostMapping("/UpdateProdotto")
public String updateCliente(@ModelAttribute NewClienteDaModificare cliente) {
	try {
		cliente.getCliente().setDataDiNascita(Utils.dataCreator2(cliente.getDataDiNascita()));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	clienteSer.update(cliente.getCliente());
	return "redirect:http://localhost:5679/";
}
}
