package com.example.anagrafica.presentation;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.data.Cliente;

@Endpoint
public class ClienteEndpoint {
	private static final String NAMESPACE_URI = "presentation.anagrafica.example.com";

	@Autowired
	private ClienteService clienteService;

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

}
