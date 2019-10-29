package com.example.anagrafica;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.anagrafica.business.ClienteService;
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
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/")
	public String index(ModelMap model) {
		Collection<Cliente> clienti=this.clienteService.getAll();
		System.out.println(clienti);
//		Cliente stampCliente=this.clienteRepository.findById(1).get();
//		Indirizzo stampIndirizzo=this.indirizzoRepository.findById(1).get();
//		System.out.println(stampCliente.getCf());
//		System.out.println(stampIndirizzo.getCitta());
//		for(IndirizzoCliente i:stampCliente.getIndirizziClienti()) {
//		System.out.println(i.getIndirizzo());
//		}
//		Indirizzo indirizzoDiResidenza = this.indirizzoRepository.findById(1).get(); 
//		Cliente cliente = this.clienteRepository.findById(1).get();
//		
//		for(IndirizzoCliente ic : cliente.getIndirizziClienti()) {
//			System.out.println(ic.getId().getTipo());
//		}
////		IndirizzoClientePK icpk = new IndirizzoClientePK();
////		icpk.setIdCliente(cliente.getId());
////		icpk.setIdIndirizzo(indirizzoDiResidenza.getId());
////		icpk.setTipo("residenza");
//		
////		IndirizzoCliente indc = new IndirizzoCliente(indirizzoDiResidenza, cliente, "residenza");
////		indirizzoClienteRepository.save(indc);
		
		return "index";
	}

	@GetMapping("/addCliente")
	public String postiamo() {
		Cliente cliente= new Cliente("Alessio","Rozzano",'F',"dfuhdfeds56sa",new Date(),"Vercfdli","luca.onorrri@gmail.com","333-3333336");
		Indirizzo indirizzoDiResidenza = indirizzoRepository.save(new Indirizzo("Via Arezzo",4,"Arezzo","VT","Lazio","Italia"));
		Indirizzo indirizzoDiDomicilio = indirizzoRepository.save(new Indirizzo("Via Sile",18,"Milano","MI","Lombardia","Italia"));
		Map<String,Indirizzo> indirizzi=new HashMap<String, Indirizzo>();
		indirizzi.put("residenza", indirizzoDiResidenza);
		indirizzi.put("domicilio", indirizzoDiDomicilio);
		
		
		
		this.clienteService.create(cliente, indirizzi);
	
	
		return "index";
		
		
	}
}
