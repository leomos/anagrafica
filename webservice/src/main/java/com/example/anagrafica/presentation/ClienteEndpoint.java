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
import com.example.anagrafica.data.IndirizzoCliente;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Endpoint
public class ClienteEndpoint {
	private static final String NAMESPACE_URI = "presentation.anagrafica.example.com";

	@Autowired
	private ClienteService clienteService;
	

	/**
	 * 
	 * prende un cliente, modifica e  ritorna una stringa
	 */

	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "postModificaClienteRequest")
	@ResponsePayload
	public PostModificaClienteResponse postModificaCliente(@RequestPayload PostModificaClienteRequest request)
			
			

			
			throws Exception {
		System.out.println(request.getClienteX().getIdCliente());
		String risposta = "";
		
		MetodiUtili mt=new MetodiUtili();
		Character c =  'c';
		if(!request.getClienteX().getSesso().isEmpty()) {
		 c=request.getClienteX().getSesso().charAt(0);
		};
		System.out.println("nnn");
		
		Cliente cli = new Cliente(request.getClienteX().getNome(), request.getClienteX().getCognome(),
				c, request.getClienteX().getCf(),
				mt.dataCreator(request.getClienteX().getDataDiNascita()), request.getClienteX().getLuogoDiNascita(),
				request.getClienteX().getMail(), request.getClienteX().getTelefono());
	
	
System.out.println("creato cli");
		Cliente clibase= new Cliente();
				System.out.println("creato il cliente");
				
			if(!request.getClienteX().getIdCliente().equals(null)) {
				System.out.println("dentro il nulla");
			clibase=	clienteService.get(request.getClienteX().getIdCliente().intValue()).get();
			}
			else if(!request.getClienteX().getCf().isEmpty()){
				System.out.println("dentro il cf");
				clibase=clienteService.getByCf(request.getClienteX().getCf()).get();
				cli.setId(clibase.getId());};
			
		if(request.getClienteX().getNome().isEmpty()) {
			cli.setNome(clibase.getNome());
		};
		if(request.getClienteX().getCognome().isEmpty()) {
			cli.setCognome(clibase.getCognome());
		};
		if(request.getClienteX().getCf().isEmpty()) {
			cli.setCf(clibase.getCf());
		};
		if(request.getClienteX().getMail().isEmpty()) {
			cli.setMail(clibase.getMail());
		};
		if(request.getClienteX().getLuogoDiNascita().isEmpty()) {
			cli.setLuogoDiNascita(clibase.getLuogoDiNascita());
		};
		if(request.getClienteX().getTelefono().isEmpty()) {
			cli.setTelefono(clibase.getTelefono());
		};
		if(request.getClienteX().getSesso().isEmpty()) {
			cli.setSesso(clibase.getSesso());
		};
		if(request.getClienteX().getDataDiNascita().isEmpty()) {
			cli.setDataDiNascita(clibase.getDataDiNascita());
		};
	
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

	
	/**
	 * 
	 *prende in ingresso dei parametri e filtra il getall grazie ad essi, tornando il risultante
	 */
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

	
			if(!request.getClienteX2().getProvinciaDiResidenza().isEmpty()) {
				boolean bic= false;
				for (IndirizzoCliente ic:c.getIndirizziClienti()) {
				if(ic.getIndirizzo().getProvincia().equalsIgnoreCase(request.getClienteX2().getProvinciaDiResidenza()))
				{
					bic=true;
				};
				
				};
				if(bic==false) {
					CCli.remove(c);
				}
			};
			if(!request.getClienteX2().getRegioneDiResidenza().isEmpty()) {
				boolean bic= false;
				for (IndirizzoCliente ic:c.getIndirizziClienti()) {
				if(ic.getIndirizzo().getRegione().equalsIgnoreCase(request.getClienteX2().getRegioneDiResidenza())){
					bic=true;
				};
				
				};
				if(bic==false) {
					CCli.remove(c);
				}
			};
			
		
	}
		
	System.out.println("222222"+CCli.toString());
	
		for (Cliente c: CCli) {
			
			ClienteX x2=new ClienteX();
			
			x2.setNome(c.getNome());
			x2.setCognome(c.getCognome());
			x2.setCf(c.getCf());
			x2.setDataDiNascita(c.getDataDiNascita().toString());
			x2.setIdCliente(BigInteger.valueOf(c.getId()));
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
