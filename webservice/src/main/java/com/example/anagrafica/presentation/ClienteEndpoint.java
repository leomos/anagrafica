package com.example.anagrafica.presentation;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.example.anagrafica.data.Cliente;
import com.example.anagrafica.business.ClienteService;

@Endpoint
public class ClienteEndpoint {
	private static final String NAMESPACE_URI = "presentation.anagrafica.example.com";

	@Autowired
	private ClienteService clienteService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClientiVisibiliRequest")
	@ResponsePayload
	public GetClientiVisibiliResponse deleteCliente(@RequestPayload GetClientiVisibiliRequest request) {
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
}
