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
import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.data.Cliente;
import com.example.anagrafica.data.ClienteRepository;
import com.example.anagrafica.data.IndirizzoCliente;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.anagrafica.business.*;
import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.data.Cliente;
import com.example.anagrafica.data.Indirizzo;
import com.example.anagrafica.presentation.*;
import com.example.anagrafica.presentation.GetListaClientiResponse;
import com.example.anagrafica.utils.Utils;
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
        for(Cliente cl:this.clienteService.getAll()){
        	XClienteResponse client=new XClienteResponse();
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
	public PostModificaClienteResponse postModificaCliente(@RequestPayload PostModificaClienteRequest request) throws Exception {
		PostModificaClienteResponse response = new PostModificaClienteResponse();
		XClienteRequest cx = request.getCliente();
		Utils mt = new Utils();
		
		if(cx == null) {
			response.setRisposta("ClienteX is null");
			return response;
		}
		
		Optional<Cliente> newCliente;
		
		if(cx.getId() != null) {
			newCliente = this.clienteService.get(cx.getId().intValue());
		} else if(cx.getCf() != null && !cx.getCf().isEmpty()) {
			newCliente = this.clienteService.getByCf(cx.getCf());
		} else {
			response.setRisposta("ClienteX is missing both id and cf");
			return response;
		}
		
		if(newCliente.isPresent()) {
			Cliente effectiveCliente = newCliente.get();
			
			if(cx.getNome() != null) {
				effectiveCliente.setNome(cx.getNome());
			}
			if(cx.getCognome() != null) {
				effectiveCliente.setCognome(cx.getCognome());
			}
			if(cx.getCf() != null) {
				effectiveCliente.setCf(cx.getCf());
			}
			if(cx.getMail() != null) {
				effectiveCliente.setMail(cx.getMail());
			}
			if(cx.getLuogoDiNascita() != null) {
				effectiveCliente.setLuogoDiNascita(cx.getLuogoDiNascita());
			}
			if(cx.getTelefono() != null) {
				effectiveCliente.setTelefono(cx.getTelefono());
			}
			if(cx.getSesso() != null) {
				effectiveCliente.setSesso(cx.getSesso().charAt(0));
			}
			if(cx.getDataDiNascita() != null) {
				effectiveCliente.setDataDiNascita(mt.dataCreator(cx.getDataDiNascita()));
			}
			
			if(this.clienteService.update(effectiveCliente)) {
				response.setRisposta("Update went fine!");
			} else {
				response.setRisposta("There was a problem with update.");
			}
			return response;
		} else {
			response.setRisposta("Can't find a Cliente with the specified identifier.");
			return response;
		}
	}

	
	/**
	 * 
	 *prende in ingresso dei parametri e filtra il getall grazie ad essi, tornando il risultante
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getListaFiltrataRequest")
	@ResponsePayload
	public GetListaFiltrataResponse GetListaFiltrata(@RequestPayload GetListaFiltrataRequest request) throws Exception {
	
		Utils mt=new Utils();
		GetListaFiltrataResponse response= new GetListaFiltrataResponse();
		
		System.out.println(request.getClienteFilter().toString());
	
		ClienteFilter cf=new ClienteFilter(request.getClienteFilter().getNome(),
				request.getClienteFilter().getCognome(), 
				request.getClienteFilter().getSesso(),
				request.getClienteFilter().getCf(), 
				request.getClienteFilter().getDataIniziale(), 
				request.getClienteFilter().getDataFinale(), 
				request.getClienteFilter().getProvinciaDiResidenza(), 
				request.getClienteFilter().getRegioneDiResidenza());

		Collection<Cliente> CCli=clienteService.findWithFilter(cf); 
		
		for (Cliente c: CCli) {
			
			XClienteResponse x2=new XClienteResponse();
			
			x2.setNome(c.getNome());
			x2.setCognome(c.getCognome());
			x2.setCf(c.getCf());
			x2.setDataDiNascita(c.getDataDiNascita().toString());
			
			x2.setLuogoDiNascita(c.getLuogoDiNascita());
			x2.setMail(c.getMail());
			x2.setSesso(c.getSesso().toString());
			x2.setTelefono(c.getTelefono());
			
			response.getCliente().add(x2);
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
		XClienteRequest cl=req.getCliente();
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
		Cliente c = clienteService.getByCf(request.getCfCliente()).get();

		XClienteResponse clienteRichiesto = new XClienteResponse();
		clienteRichiesto.setNome(c.getNome());
		clienteRichiesto.setCognome(c.getCognome());
		clienteRichiesto.setSesso(Character.toString(c.getSesso()));
		clienteRichiesto.setCf(c.getCf());
		clienteRichiesto.setDataDiNascita(c.getDataDiNascita().toString());
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
			XClienteResponse nuovocliente = new XClienteResponse();
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
