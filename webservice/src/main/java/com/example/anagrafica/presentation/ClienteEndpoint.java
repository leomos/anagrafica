package com.example.anagrafica.presentation;

import javax.xml.datatype.XMLGregorianCalendar;

import org.hibernate.Criteria;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.example.anagrafica.data.Cliente;

import com.example.anagrafica.Utils.MetodiUtili;
import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.data.Cliente;
import com.example.anagrafica.data.ClienteRepository;
import com.example.anagrafica.data.IndirizzoCliente;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.example.anagrafica.business.*;
import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.data.Cliente;
import com.example.anagrafica.data.Indirizzo;
import com.example.anagrafica.presentation.*;
import com.example.anagrafica.presentation.GetListaClientiResponse;
import com.example.anagrafica.presentation.GetListaClientiRequest;
import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.data.Cliente;

@Endpoint
public class ClienteEndpoint {
	private static final String NAMESPACE_URI = "presentation.anagrafica.example.com";

	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClientiVisibiliRequest")
	@ResponsePayload
	public GetClientiVisibiliResponse getClientiVisibili(@RequestPayload GetClientiVisibiliRequest request) {
		GetClientiVisibiliResponse response = new GetClientiVisibiliResponse();
        for(Cliente cl:this.clienteService.getAllVisibile()){
        	com.example.anagrafica.presentation.Cliente client=new com.example.anagrafica.presentation.Cliente();
        	client.setNome(cl.getNome());
        	client.setCognome(cl.getCognome());
        	client.setSesso(Character.toString(cl.getSesso()));
        	client.setCf(cl.getCf());
        	client.setDataDiNascita(cl.getDataDiNascita().toString());
        	client.setLuogoDiNascita(cl.getLuogoDiNascita());
        	client.setMail(cl.getMail());
        	client.setTelefono(cl.getTelefono());
        	response.getClientiVisibili().add(client);
        }
		return response;
		
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteClienteByIdRequest")
	@ResponsePayload
	public GetDeletedClienteResponse deleteByIdCliente(@RequestPayload DeleteClienteByIdRequest request) {
		System.out.println(request.idCliente);
		GetDeletedClienteResponse response = new GetDeletedClienteResponse();
		System.out.print(clienteService.get(request.idCliente).get().isVisibile());
		response.setClienteVisibile(this.clienteService.deleteLogical(clienteService.get(request.idCliente).get()));      
		System.out.print(this.clienteService.deleteLogical(clienteService.get(request.idCliente).get()));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteClienteByCfRequest")
	@ResponsePayload
	public GetDeletedClienteResponse deleteByCfCliente(@RequestPayload DeleteClienteByCfRequest request) {
		System.out.println(request.cfCliente);
		GetDeletedClienteResponse response = new GetDeletedClienteResponse();
		System.out.print(clienteService.getByCf(request.cfCliente).get().isVisibile());
		response.setClienteVisibile(this.clienteService.deleteLogical(clienteService.getByCf(request.cfCliente).get()));      
		System.out.print(clienteService.getByCf(request.cfCliente).get().isVisibile());
		return response;
	}
	
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
				if(ic.getIndirizzo().getProvincia().equalsIgnoreCase(request.getClienteX2().getProvinciaDiResidenza())){
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
	
	@Autowired
	private IndirizzoService indirizzoService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createClienteRequest")
	@ResponsePayload
	public CreateClienteResponse create(@RequestPayload CreateClienteRequest req ) throws ParseException {
		CreateClienteResponse ccr = new CreateClienteResponse();
		Map<String, Indirizzo> m = new HashMap<String, Indirizzo>();
		Cliente2 cl=req.getCliente();
		Indirizzo indirizzo=new Indirizzo(req.getIndirizzo().getLuogo(),req.getIndirizzo().getNumeroCivico(),req.getIndirizzo().getCitta(),req.getIndirizzo().getProvincia(),req.getIndirizzo().getRegione(),req.getIndirizzo().getNazione());
		indirizzoService.create(indirizzo);
		char s = cl.getSesso().charAt(0);
		
		Date d = dataConverter(	cl.getDataDiNascita());
		
		Cliente c = new Cliente(cl.getNome(), cl.getCognome(), s, cl.getCf(), d, cl.getLuogoDiNascita(), cl.getMail(), cl.getTelefono());
		m.put(req.getTipo(), indirizzo);

		ccr.setResponse(clienteService.create(c, m));
		return ccr;
		
	}
	
	public Date dataConverter (String s) throws ParseException {
		Date data1 = new SimpleDateFormat("dd/mm/yyyy").parse(s);
		return data1;
	}


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetClienteByDettaglioRequest")
	@ResponsePayload
	public GetClienteByDettaglioResponse getClienteByDettaglio(@RequestPayload GetClienteByDettaglioRequest request) {
		GetClienteByDettaglioResponse response = new GetClienteByDettaglioResponse();
		Cliente c = clienteService.getByCf(request.getCfCliente());

		ClienteByCf clienteRichiesto = new ClienteByCf();
		clienteRichiesto.setNome(c.getNome());
		clienteRichiesto.setCognome(c.getCognome());
		clienteRichiesto.setSesso(Character.toString(c.getSesso()));
		clienteRichiesto.setCf(c.getCf());
		clienteRichiesto.setDataDiNascita(dateConversione(c));
		clienteRichiesto.setLuogoDiNascita(c.getLuogoDiNascita());
		clienteRichiesto.setMail(c.getMail());
		clienteRichiesto.setTelefono(c.getTelefono());
		response.getClienteRichiesto().add(clienteRichiesto);
		return response;
	}

	// metodo per effettuare la conversione della data di tipo Date in
	// XMLGregorianCalendar
	public static XMLGregorianCalendar dateConversione(Cliente c) {
		XMLGregorianCalendar xmlDate = null;
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(c.getDataDiNascita());

		try {
			xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return xmlDate;
	}
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getListaClientiRequest")
	@ResponsePayload
	public GetListaClientiResponse getListaClienti(@RequestPayload GetListaClientiRequest request) {
		GetListaClientiResponse response = new GetListaClientiResponse();
		for(Cliente ic: clienteService.getAll()) {
			com.example.anagrafica.presentation.Cliente nuovocliente = new com.example.anagrafica.presentation.Cliente();
			nuovocliente.setCf(ic.getCf());
			nuovocliente.setNome(ic.getNome());
			nuovocliente.setCognome(ic.getCognome());
			nuovocliente.setLuogoDiNascita(ic.getLuogoDiNascita());
			nuovocliente.setMail(ic.getMail());
			nuovocliente.setTelefono(ic.getMail());
			nuovocliente.setDataDiNascita(ic.getDataDiNascita().toString());
			nuovocliente.setSesso(ic.getSesso().toString());
	        response.getI().add(nuovocliente);

			
		}
		return response;
	}
}
