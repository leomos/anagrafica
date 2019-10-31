package com.example.anagrafica.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.anagrafica.presentation.GetListaClientiResponse;
import com.example.anagrafica.presentation.GetListaClientiRequest;
import com.example.anagrafica.business.ClienteService;
import com.example.anagrafica.data.Cliente;

@Endpoint
public class ClienteEndpoint {
	private static final String NAMESPACE_URI = "presentation.anagrafica.example.com";

	@Autowired
	private ClienteService clienteService;
	
	
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
