package com.example.anagrafica.presentation.webui.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.business.IndirizzoService;
import com.example.anagrafica.data.Cliente;
import com.example.anagrafica.data.Indirizzo;
import com.example.anagrafica.utils.Utils;

import data.NewCliente;

@Controller
public class ClienteCreateController {

	@Autowired
	ClienteService clienteService;

	@Autowired
	IndirizzoService indirizzoService;

	@GetMapping("/aggiungiCliente")
	public String c() {
		return "createCliente";
	}

	@GetMapping("/aggiungiCliente/errore")
	public String c2() {
		return "error";
	}

	@PostMapping("/CreateCliente")
	public String clienteCreate(@ModelAttribute NewCliente cliente, ModelMap model) {

		try {
			indirizzoService.create(cliente.getIndirizzoResidenza());
			indirizzoService.create(cliente.getIndirizzoDomicilio());
		} catch(Exception e) {
			return "redirect:/aggiungiCliente/errore";
		}
		Map<String, Indirizzo> indirizzi = new HashMap<String, Indirizzo>();
		indirizzi.put("residenza", cliente.getIndirizzoResidenza());
		indirizzi.put("domicilio", cliente.getIndirizzoDomicilio());

		try {
			cliente.getCliente().setDataDiNascita(Utils.dataCreator2(cliente.getDataDiNascita()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cliente c = cliente.getCliente();
		if (clienteService.getByCf(c.getCf()).isPresent() == true) {
			model.addAttribute("existByCf", true);
		}


		if (c.equals(null)) {
			model.addAttribute("nullCliente", true);
		}
		try {
			boolean result = clienteService.create(cliente.getCliente(), indirizzi);
			if (result == true) {
				model.addAttribute("ClienteCreato", true);
			}
			//return "redirect:http://localhost:5679/";
			return "controllaRisultatoCreate";
		} catch (Exception e) {
			return "redirect:/aggiungiCliente/errore";
		}

		// System.out.println(clienteService.getByCf(cliente.getCliente().getCf()).toString());

	}

}
