package com.example.anagrafica.presentation;


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

	@Autowired
	private ClienteService clienteService;
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
