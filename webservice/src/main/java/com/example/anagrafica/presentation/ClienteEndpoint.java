package com.example.anagrafica.presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

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
	
	
}
