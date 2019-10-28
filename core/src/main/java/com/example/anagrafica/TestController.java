package com.example.anagrafica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.anagrafica.data.Cliente;
import com.example.anagrafica.data.ClienteRepository;
import com.example.anagrafica.data.Indirizzo;
import com.example.anagrafica.data.IndirizzoCliente;
import com.example.anagrafica.data.IndirizzoRepository;

@Controller
public class TestController {
	
	@Autowired
	IndirizzoRepository indirizzoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/")
	public String index(ModelMap model) {
		Indirizzo ind = this.indirizzoRepository.findById(1).get();
		System.out.println(ind.getLuogo());
		
		Cliente c = this.clienteRepository.findById(1).get();
		System.out.println(c.getCf());
		System.out.println(c.getDataDiNascita());
		System.out.println( ((List<Indirizzo>)c.getIndirizzi()).get(0).getLuogo() );
		
		
		List<IndirizzoCliente> ic = (List<IndirizzoCliente>) this.clienteRepository.findById(1).get().getIndirizziClienti();
		System.out.println(ic.get(0).getTipo());
		return "index";
	}
}
