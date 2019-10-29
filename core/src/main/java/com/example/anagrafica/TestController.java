package com.example.anagrafica;

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
	
	@GetMapping("/create")
	public String create(ModelMap model) {		
		Indirizzo indirizzoDiResidenza = this.indirizzoRepository.findById(1).get(); 
		Cliente cliente = this.clienteRepository.findById(1).get();
		
	//	System.out.println("indirizzoDKNSDKFKSJDFKSDJKFJKSDFJKSDJKFJSDKJFKS"+indirizzoDiResidenza);
		//for(IndirizzoCliente ic : cliente.getIndirizziClienti()) {
		//	System.out.println(ic.getId().getTipo());
		//}
//		IndirizzoClientePK icpk = new IndirizzoClientePK();
//		icpk.setIdCliente(cliente.getId());
//		icpk.setIdIndirizzo(indirizzoDiResidenza.getId());
//		icpk.setTipo("residenza");
		
//		IndirizzoCliente indc = new IndirizzoCliente(indirizzoDiResidenza, cliente, "residenza");
//		indirizzoClienteRepository.save(indc);
		
		HashMap<String,Indirizzo> indirizzi=new HashMap<String, Indirizzo>();
		indirizzi.put("domicilio", indirizzoDiResidenza);
		indirizzi.put("residenza", indirizzoDiResidenza);
		//System.out.println("SAKDOADOASODKOASKDO" +indirizzi);
		//ClienteService cs= new ClienteService();
		clienteService.create(cliente, indirizzi);
		
	//	for(Cliente c:	this.clienteRepository.findAll()) {
		//	System.out.println(c);
//			for(IndirizzoCliente ic:c.getIndirizziClienti() ) {
		//	System.out.println(	ic.getIndirizzo());
		//	System.out.println(ic.getId().getTipo());
	//		}
	//	}
	//	org.hibernate.Transaction.commit();
		//ClienteService clienteService2= new ClienteService(); 
		//clienteService2.stampaclienteid();
		
		
		return "index";
	}
	@GetMapping("/update")
	public String update() {
		
		Cliente cliente = this.clienteRepository.findById(1).get();
		cliente.setCognome("cicciopasticcino");
		System.out.println(cliente);
		System.out.println(cliente.getId());
	
		this.clienteService.update(cliente);
		
		
		return "sss";		
		
	}
	@GetMapping("/")
	public String index(ModelMap model) {		
		Indirizzo indirizzoDiResidenza = this.indirizzoRepository.findById(1).get(); 
		Cliente cliente = this.clienteRepository.findById(1).get();
		System.out.println(cliente);
		
		return "index";}
}
