package com.example.anagrafica.presentation.webui.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.anagrafica.business.ClienteFilter;
import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.data.Cliente;

@Controller
public class ClienteReadController {

	@Autowired
	ClienteService clienteService;

	@GetMapping("/clienti")
	public String index(@ModelAttribute ClienteFilter cf, ModelMap model) throws Exception {
		System.out.println(cf.toString());
		Collection<Cliente> cc = clienteService.findWithFilter(cf);
		boolean trovato=true;
		if (cc.isEmpty()) {
			Cliente errore = new Cliente();
			cc.add(errore);
			trovato=false;
		}
		model.addAttribute("trovato", trovato);
		model.addAttribute("clienteCollection", cc);
		System.out.println(cc);
		return "index";
	}

	@GetMapping("/clienti/{id}")
	public String getOne(@PathVariable("id") String id, ModelMap model, HttpServletResponse response) {
boolean trovato;
		Optional<Cliente> c = clienteService.get(Integer.parseInt(id));
		ArrayList<Cliente> cc = new ArrayList<>();
		if (!c.isPresent()) {
			Cliente errore = new Cliente();
			cc.add(errore);
			trovato=false;
		} else {
trovato=true;
			cc.add(c.get());
		}
		model.addAttribute("trovato", trovato);
		model.addAttribute("clienteCollection", cc);
		response.addHeader("Content-Security-Policy", "frame-ancestors 'self'");
		return "index";

	}
}
