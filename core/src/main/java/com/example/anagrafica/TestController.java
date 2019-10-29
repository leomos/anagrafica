package com.example.anagrafica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.anagrafica.data.Cliente;
import com.example.anagrafica.data.ClienteRepository;
import com.example.anagrafica.data.Indirizzo;
import com.example.anagrafica.data.IndirizzoCliente;
import com.example.anagrafica.data.IndirizzoClientePK;
import com.example.anagrafica.data.IndirizzoClienteRepository;
import com.example.anagrafica.data.IndirizzoRepository;

@Controller
public class TestController {
	
	@Autowired
	IndirizzoRepository indirizzoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	IndirizzoClienteRepository indirizzoClienteRepository;
	
	@GetMapping("/")
	public String index(ModelMap model) {		
		Indirizzo indirizzoDiResidenza = this.indirizzoRepository.findById(1).get(); 
		Cliente cliente = this.clienteRepository.findById(1).get();
		
		for(IndirizzoCliente ic : cliente.getIndirizziClienti()) {
			System.out.println(ic.getId().getTipo());
		}
//		IndirizzoClientePK icpk = new IndirizzoClientePK();
//		icpk.setIdCliente(cliente.getId());
//		icpk.setIdIndirizzo(indirizzoDiResidenza.getId());
//		icpk.setTipo("residenza");
		
//		IndirizzoCliente indc = new IndirizzoCliente(indirizzoDiResidenza, cliente, "residenza");
//		indirizzoClienteRepository.save(indc);
		
		return "index";
	}
}
