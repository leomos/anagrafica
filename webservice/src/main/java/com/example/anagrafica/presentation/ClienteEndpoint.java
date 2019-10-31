package com.example.anagrafica.presentation;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.anagrafica.Utils.MetodiUtili;
import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.data.Cliente;
import com.example.anagrafica.data.ClienteRepository;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Endpoint
public class ClienteEndpoint {
	private static final String NAMESPACE_URI = "presentation.anagrafica.example.com";

	@Autowired
	private ClienteService clienteService;
	

	

	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "postModificaClienteRequest")
	@ResponsePayload
	public PostModificaClienteResponse postModificaCliente(@RequestPayload PostModificaClienteRequest request)
			
			

			
			throws Exception {
		System.out.println(request.getClienteX().getIdCliente());
		String risposta = "";
		
		MetodiUtili mt=new MetodiUtili();
		
		Cliente cli = new Cliente(request.getClienteX().getNome(), request.getClienteX().getCognome(),
				request.getClienteX().getSesso().charAt(0), request.getClienteX().getCf(),
				mt.dataCreator(request.getClienteX().getDataDiNascita()), request.getClienteX().getLuogoDiNascita(),
				request.getClienteX().getMail(), request.getClienteX().getTelefono());
		cli.setId(request.getClienteX().getIdCliente());

		if (clienteService.update(

				cli)) {

			risposta += "cliente modificato";

		} else {
			risposta += "cliente da modificare non trovato";
		}

		
		
		PostModificaClienteResponse response = new PostModificaClienteResponse();
		response.setRisposta(risposta);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getListaFiltrataRequest")
	@ResponsePayload
	public GetListaFiltrataResponse GetListaFiltrata(@RequestPayload GetListaFiltrataRequest request) throws Exception {
	
		MetodiUtili mt=new MetodiUtili();
		GetListaFiltrataResponse response= new GetListaFiltrataResponse();
		
		System.out.println(request.getClienteX2().toString());
	
		
		
	Collection<Cliente> CCli =	clienteService.getAll();
	System.out.println(CCli.toString());
	
	for(Cliente c:CCli) {
		if(!request.getClienteX2().getNome().isEmpty()) {
			if(!c.getNome().equalsIgnoreCase(request.getClienteX2().getNome())) {
				CCli.remove(c);
			};
			
		};
		
		if(!request.getClienteX2().getCognome().isEmpty()) {
			if(!c.getCognome().equalsIgnoreCase(request.getClienteX2().getCognome())) {
				CCli.remove(c);
			};
			
		};
		if(!request.getClienteX2().getSesso().isEmpty()) {
			if(!c.getSesso().toString().equalsIgnoreCase(request.getClienteX2().getSesso())) {
				CCli.remove(c);
			};
			
		};
		if(!request.getClienteX2().getCf().isEmpty()) {
			if(!c.getCf().equalsIgnoreCase(request.getClienteX2().getCf())) {
				CCli.remove(c);
			};
			
		};
		if(!request.getClienteX2().getCf().isEmpty()) {
			if(!c.getCf().equalsIgnoreCase(request.getClienteX2().getCf())) {
				CCli.remove(c);
			};
			
		};
		if(!request.getClienteX2().getDataIniziale().isEmpty()) {
			if(c.getDataDiNascita().compareTo(mt.dataCreator(request.getClienteX2().getDataIniziale()))<0) {
				CCli.remove(c);
			}
		};
		if(!request.getClienteX2().getDataFinale().isEmpty()) {
			if(c.getDataDiNascita().compareTo(mt.dataCreator(request.getClienteX2().getDataFinale()))>0) {
				CCli.remove(c);
			}
		};
		
	}
		
	System.out.println("222222"+CCli.toString());
		/*
		
		
		
				
		
		
		List<Cliente> lCli=	clienteService.findAllByAll(
			
			
			request.getClienteX2().getNome(), 
				request.getClienteX2().getCognome(),
				request.getClienteX2().getSesso().charAt(0),
				request.getClienteX2().getCf(),
				
				
				
				
				
				mt.dataCreator(request.getClienteX2().getDataIniziale()), 
				mt.dataCreator(request.getClienteX2().getDataFinale()),
				request.getClienteX2().getLuogoDiNascita(), 
				request.getClienteX2().getMail(),
				request.getClienteX2().getTelefono()
			
				);
		
		
		
		System.out.println(lCli.toString());
		GetListaFiltrataResponse response= new GetListaFiltrataResponse();
		
		
		*/
		for (Cliente c: CCli) {
			
			ClienteX x2=new ClienteX();
			
			x2.setNome(c.getNome());
			x2.setCognome(c.getCognome());
			x2.setCf(c.getCf());
			x2.setDataDiNascita(c.getDataDiNascita().toString());
			x2.setIdCliente(c.getId());
			x2.setLuogoDiNascita(c.getLuogoDiNascita());
			x2.setMail(c.getMail());
			x2.setSesso(c.getSesso().toString());
			x2.setTelefono(c.getTelefono());
			
			response.getClienteX().add(x2);
			System.out.println(x2.toString());
		}
		

		return response;
		
	}
	
	
	
	
}
