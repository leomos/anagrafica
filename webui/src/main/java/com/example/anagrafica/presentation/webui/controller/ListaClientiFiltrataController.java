package com.example.anagrafica.presentation.webui.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.anagrafica.business.ClienteFilter;
import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.data.Cliente;


@Controller
public class ListaClientiFiltrataController {
@Autowired
ClienteService clService;

	@GetMapping("/ListaClientiFiltrata")
	public String ListaIndirizzi() {
		return "ListaClientiFiltro";
	}
	
	@PostMapping("/ListaClientiFiltrata/Filtro")
	public String ListaFiltro(@ModelAttribute ClienteFilter filter,ModelMap model) {
		try {
			Collection<Cliente> cliente=clService.findWithFilter(filter);
		if(cliente.size()==0)
			model.addAttribute("ListaFiltrataNulla",true);
		else {
			model.addAttribute("ListaFiltrataNonNulla",true);
			model.addAttribute("ListaFiltrata",cliente)	;}
		return "mostraListaFiltrata";
		}
		catch(Exception e) {
			model.addAttribute("ErroreFiltraggio",true)	;
		return "erroreFiltraggioCliente";
	}
}
}